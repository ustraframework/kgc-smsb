package kr.co.kgc.smsb.common.base.model;

import com.gsitm.ustra.java.core.utils.annotation.MapField;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@EqualsAndHashCode(callSuper=false)
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@ApiModel
public class SmsbProcBaseModel {
	
	/**
	 * SP 상태 코드
	 */
	@MapField("OT_STATUS_CODE")
	private String otStatusCode;
	/**
	 * SP 응답 코드
	 */
	@MapField("OT_RESPON_CODE")
	private String otResponCode;
	/**
	 * SP 응답 메시지
	 */
	@MapField("OT_RES_MSG")
	private String otResMsg;
	
	/**
	 * SP 기본 입력, 화면 ID
	 */
	@MapField("IO_UI_ID")
	private String ioUiId;
	
	/**
	 * SP 기본 입력, 프로세스 ID
	 */
	@MapField("IO_PRCD_ID")
	private String ioPrcdId;
}
