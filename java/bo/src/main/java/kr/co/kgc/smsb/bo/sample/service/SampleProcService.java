package kr.co.kgc.smsb.bo.sample.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gsitm.ustra.java.data.utils.procedure.ProcedureCallOption;
import com.gsitm.ustra.java.data.utils.procedure.ProcedureCallResult;
import com.gsitm.ustra.java.data.utils.procedure.UstraOracleProcedureManager;
import com.gsitm.ustra.java.management.models.UstraUserModel;

import kr.co.kgc.smsb.bo.sample.model.SampleProcInutModel;
import kr.co.kgc.smsb.bo.sample.model.SampleProcOutModel;
import kr.co.kgc.smsb.bo.sample.repository.SampleProcRepository;

@Service
public class SampleProcService {
	@Autowired private UstraOracleProcedureManager oracleProcedureManager;
	
	public Map<String,Object> sampleProc(SampleProcInutModel in) {
		ProcedureCallResult<Map<String, Object>> result = oracleProcedureManager.call(
				ProcedureCallOption.returnMapBuilder("SP_SAMPLE_CASE1", in)
					.schemaName("KGC")
					.datasourceName("rds1")
					.build()
		);
		
		return result.getData();
	}

	/**
	 * 서비스 내에서 프로시저 실행 - 프로시저 코드를 재사용하지 않는 경우 Service에서 바로 실행
	 * @param in
	 * @return
	 */
	public SampleProcOutModel sampleProcList(SampleProcInutModel in) {
		ProcedureCallResult<SampleProcOutModel> result = oracleProcedureManager.call(
				ProcedureCallOption.returnObjectBuilder("SP_SAMPLE_CASE2", in, SampleProcOutModel.class)
					.schemaName("KGC")
					.datasourceName("rds1")
					.resultRowMapper("P_RESULT", UstraUserModel.class)
					.build()
		);
		
		return result.getData();
	}

	/**
	 * Repository 클래스를 만들고 해당 Repository 에서 프로시저 실행 - 프로시저 코드를 재사용 하는 경우 Repository 생성후 사용
	 * @param in
	 * @return
	 */
	@Autowired private SampleProcRepository sampleProcRepository;
	public SampleProcOutModel sampleProcListByRepo(SampleProcInutModel in) {
		return sampleProcRepository.sampleProcList(in);
	}
}
