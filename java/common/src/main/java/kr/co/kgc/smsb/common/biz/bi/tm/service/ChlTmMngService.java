package kr.co.kgc.smsb.common.biz.bi.tm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gsitm.ustra.java.data.utils.procedure.ProcedureCallOption;
import com.gsitm.ustra.java.data.utils.procedure.ProcedureCallResult;
import com.gsitm.ustra.java.data.utils.procedure.UstraOracleProcedureManager;

import kr.co.kgc.smsb.common.biz.bi.tm.model.ChlTmMngDto;
import kr.co.kgc.smsb.common.biz.bi.tm.model.ChlTmMngProcModel;

@Service
public class ChlTmMngService {
	@Autowired private UstraOracleProcedureManager oracleProcedureManager;

	public ChlTmMngProcModel get(ChlTmMngDto.Criteria in) {
		ProcedureCallResult<ChlTmMngProcModel> result = oracleProcedureManager.call(
				ProcedureCallOption.returnObjectBuilder("STP_UI_BM_2101_SEL_01", in, ChlTmMngProcModel.class)
					.schemaName("KGC")
					.datasourceName("rds1")
					.resultRowMapper("ot_out_cursor", ChlTmMngDto.class)
					.build()
		);
		
		return result.getData();
	}
	
	public ChlTmMngProcModel save(ChlTmMngDto in) {
		ProcedureCallResult<ChlTmMngProcModel> result = oracleProcedureManager.call(
				ProcedureCallOption.returnObjectBuilder("STP_UI_BM_2101_IUD_01", in, ChlTmMngProcModel.class)
					.schemaName("KGC")
					.datasourceName("rds1")
					.build()
		);
		
		return result.getData();
	}	
}
