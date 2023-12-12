package kr.co.kgc.smsb.bo.sample.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gsitm.ustra.java.data.utils.procedure.ProcedureCallOption;
import com.gsitm.ustra.java.data.utils.procedure.ProcedureCallResult;
import com.gsitm.ustra.java.data.utils.procedure.UstraOracleProcedureManager;
import com.gsitm.ustra.java.management.models.UstraUserModel;

import kr.co.kgc.smsb.bo.sample.model.SampleProcInutModel;
import kr.co.kgc.smsb.bo.sample.model.SampleProcOutModel;

@Repository
public class SampleProcRepository {
	
	@Autowired private UstraOracleProcedureManager oracleProcedureManager;
	
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
