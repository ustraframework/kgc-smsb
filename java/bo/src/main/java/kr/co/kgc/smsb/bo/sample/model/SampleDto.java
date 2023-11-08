package kr.co.kgc.smsb.bo.sample.model;

import com.gsitm.ustra.java.data.base.UstraBaseModel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@EqualsAndHashCode(callSuper = false)
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class SampleDto extends UstraBaseModel {
	/**
	 * 그룹코드
	 */
	private String grpCd;

	/**
	 * 상세코드
	 */
	private String dtlCd;

	/**
	 * 코드명
	 */
	private String cdNm;

	/**
	 * 코드설명
	 */
	private String cdDesc;

	/**
	 * 검색 조건
	 * @author
	 *
	 */
	@Data
	@Builder
	@NoArgsConstructor
	@AllArgsConstructor
	public static class Criteria {
		/**
		 * 그룹코드
		 */
		private String grpCd;

		/**
		 * 상세코드
		 */
		private String dtlCd;
	}
}
