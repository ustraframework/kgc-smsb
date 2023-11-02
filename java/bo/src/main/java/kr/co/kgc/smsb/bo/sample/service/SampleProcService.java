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

}
