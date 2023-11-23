package kr.co.kgc.smsb.common.base.model;

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
	 * SP 응답 코드
	 */
	private String otResponCode;
	/**
	 * SP 응답 메시지
	 */
	private String otResMsg;
}
