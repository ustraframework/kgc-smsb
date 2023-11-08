package kr.co.kgc.smsb.bo.sample.repository;

import org.apache.ibatis.annotations.Mapper;

import com.gsitm.ustra.java.data.domains.PaginationList;

import kr.co.kgc.smsb.bo.sample.model.SampleDto;

@Mapper
public interface SamplePaginationRepository {
	/**
	 * 공통코드 페이징 조회
	 * @param paginationRequest
	 * @param criteria
	 * @return
	 */
	PaginationList<SampleDto> selectCmmCdListByHeader(SampleDto.Criteria criteria);
}
