package kr.co.kgc.smsb.common.base.config;

import java.util.Map;

import javax.sql.DataSource;

import org.springframework.stereotype.Component;

import com.gsitm.ustra.java.data.exception.UstraDataException;
import com.gsitm.ustra.java.data.utils.procedure.ProcedureCallOption;
import com.gsitm.ustra.java.data.utils.procedure.ProcedureCallResult;
import com.gsitm.ustra.java.data.utils.procedure.UstraOracleProcedureManager;

import kr.co.kgc.smsb.common.base.model.SmsbProcBaseModel;

@Component
public class SmsbUstraCustomOracleProcedureManager extends UstraOracleProcedureManager {

	public SmsbUstraCustomOracleProcedureManager(DataSource dataSource) {
		super(dataSource);
	}

	@SuppressWarnings("unchecked")
	@Override
	public <R> ProcedureCallResult<R> call(ProcedureCallOption<R> option) {
		ProcedureCallResult<R> procedureResult = super.call(option);

		// 응답 코드 비교
		if (procedureResult.getData() != null) {
			R bodyResult = procedureResult.getData();

			// map으로 반환될 경우 처리, 만약 model 인스턴스 일 경우는 별도의 처리 필요함.
			if (bodyResult instanceof Map) {
				Map<String, Object> mapResult = (Map<String, Object>)bodyResult;

				// 정상 응답 코드가 아닐 경우 처리
				if (!"00000".equals(mapResult.get("otResponCode"))) {
					// UstraDataException 에는 (string, string) 을 변수로 받는 메소드가 없음 (code, string)
					// throw new UstraDataException(mapResult.get("otResponCode").toString(), mapResult.get("otResMsg").toString());
				}
			}
			// model 인스턴스 일 경우
			else if(bodyResult instanceof SmsbProcBaseModel)  {
				// 상속받는 상위 model로 변환하여 SP 응답코드 점검
				SmsbProcBaseModel result = (SmsbProcBaseModel)bodyResult;
				if (!"00000".equals(result.getOtResponCode())) {
					// UstraDataException 에는 (string, string) 을 변수로 받는 메소드가 없음 (code, string)
					// throw new UstraDataException(mapResult.get("otResponCode").toString(), mapResult.get("otResMsg").toString(), null);
				}
			}
		}

		return procedureResult;
	}

}