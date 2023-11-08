package kr.co.kgc.smsb.bo.sample.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gsitm.ustra.java.data.domains.PaginationList;
import com.gsitm.ustra.java.data.mybatis.pagination.domain.Paginator;
import com.gsitm.ustra.java.data.utils.procedure.ProcedureCallOption;
import com.gsitm.ustra.java.data.utils.procedure.ProcedureCallResult;
import com.gsitm.ustra.java.data.utils.procedure.UstraOracleProcedureManager;
import com.gsitm.ustra.java.mvc.rest.utils.UstraRestUtils;

import kr.co.kgc.smsb.bo.sample.model.SampleDto;
import kr.co.kgc.smsb.bo.sample.model.SamplePaginationProcOutModel;
import kr.co.kgc.smsb.bo.sample.repository.SamplePaginationRepository;

@Service
public class SamplePaginationService {
	@Autowired SamplePaginationRepository samplePaginationRepository;
	
	/**
	 * 공통코드 목록 페이징 조회 - 페이징 파라메터 제외
	 * @param paginationRequest 페이징 정보
	 * @param criteria 검색 조건
	 * @return 게시 목록
	 */
	public PaginationList<SampleDto> getCmmCdPageList(SampleDto.Criteria criteria) {
		return samplePaginationRepository.selectCmmCdListByHeader(criteria);
	}
	
	@Autowired private UstraOracleProcedureManager oracleProcedureManager;
	
	/**
	 * 공통코드 목록 SP 조회 - 페이징 파라메터 제외
	 * @param paginationRequest 페이징 정보
	 * @param criteria 검색 조건
	 * @return 게시 목록
	 */
	public PaginationList<SampleDto> getCmmCdPageSpList(SampleDto.Criteria criteria) {

		ProcedureCallResult<SamplePaginationProcOutModel> result = oracleProcedureManager.call(
				ProcedureCallOption.returnObjectBuilder("SP_SAMPLE_CASE3", criteria, SamplePaginationProcOutModel.class)
					.schemaName("KGC")
					.datasourceName("rds1")
					.resultRowMapper("P_RESULT", SampleDto.class)
					.build()
		);
		
		List<SampleDto> dataList = new ArrayList<SampleDto>();
		Paginator pInfo = new Paginator(UstraRestUtils.getCurrentApiHeader().getCurrentPage(), UstraRestUtils.getCurrentApiHeader().getPageSize(), result.getData().getPTotal().intValue());
		PaginationList<SampleDto> rtn = new PaginationList(dataList, pInfo);
		
		rtn.addAll(result.getData().getList());
		return rtn;
	}
}
