package kr.co.kgc.smsb.common.biz.bi.tm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gsitm.ustra.java.data.exception.UstraDataResponseCode;
import com.gsitm.ustra.java.data.utils.procedure.ProcedureCallOption;
import com.gsitm.ustra.java.data.utils.procedure.ProcedureCallResult;

import kr.co.kgc.smsb.common.base.config.SmsbUstraCustomOracleProcedureManager;
import kr.co.kgc.smsb.common.biz.bi.tm.model.ChlTmMngDto;
import kr.co.kgc.smsb.common.biz.bi.tm.model.ChlTmMngProcModel;

@Service
public class ChlTmMngService {
	@Autowired private SmsbUstraCustomOracleProcedureManager oracleProcedureManager;

	public ChlTmMngProcModel get(ChlTmMngDto.Criteria in) {
		ProcedureCallResult<ChlTmMngProcModel> result = oracleProcedureManager.call(
				ProcedureCallOption.returnObjectBuilder("STP_UI_BM_2101_SEL_01", in, ChlTmMngProcModel.class)
					.convertReturnKeyToCamelCase(false)
					.convertParameterKeyToUnderScore(false)
					.schemaName("KGC")
					.datasourceName("rds1")
					.resultRowMapper("ot_out_cursor", ChlTmMngDto.class)
					.build()
		);
		
		return result.getData();
	}
	
	@Transactional(rollbackFor = Exception.class)
	public ChlTmMngProcModel save(ChlTmMngDto in) {
		ProcedureCallResult<ChlTmMngProcModel> result = oracleProcedureManager.call(
				ProcedureCallOption.returnObjectBuilder("STP_UI_BM_2101_IUD_01", in, ChlTmMngProcModel.class)
					.convertReturnKeyToCamelCase(false)
					.convertParameterKeyToUnderScore(false)	
					.schemaName("KGC")
					.datasourceName("rds1")
					.build()
		);
		// SP 정상 응답이 아닌경우 Exception 발생
		if (!result.getData().getOtResponCode().equals("00000")) {
			throw UstraDataResponseCode.DATA_ACCESS_ERROR.exception();
		}
		return result.getData();
	}	
}
