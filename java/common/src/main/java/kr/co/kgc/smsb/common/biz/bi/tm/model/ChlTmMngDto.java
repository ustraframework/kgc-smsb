package kr.co.kgc.smsb.common.biz.bi.tm.model;

import com.gsitm.ustra.java.core.utils.annotation.MapField;

import kr.co.kgc.smsb.common.base.model.SmsbBaseModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * 채널 약관 관리 DTO  
 *
 */
@Data
@EqualsAndHashCode(callSuper = false)
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class ChlTmMngDto extends SmsbBaseModel {
	
	/**
	 * 채널_코드
	 */
	@MapField("in_chnl_cd")
	private String chnlCd;
	/**
	 * 약관_코드
	 */
	@MapField("in_term_cd")
	private String termCd;
	/**
	 * 약관_버전_번호
	 */
	@MapField("in_term_ver_no")
	private String termVerNo;
	/**
	 * 약관_유형_구분코드
	 */
	@MapField("in_term_patr_dvcd")
	private String termPatrDvcd;
	/**
	 * 약관_명
	 */
	@MapField("in_term_nm")
	private String termNm;
	/**
	 * 적용_시작_일자
	 */
	@MapField("in_apl_st_dt")
	private String aplStDt;
	/**
	 * 적용_종료_일자
	 */
	@MapField("in_apl_ed_dt")
	private String aplEdDt;
	/**
	 * 약관_내용
	 */
	@MapField("in_term_cntt")
	private String termCntt;
	/**
	 * 필수_동의_약관_여부
	 */
	@MapField("in_esnt_agrm_term_yn")
	private String esntAgrmTermYn;
	
	/**
	 * 요청구분(C/U)
	 */
	@MapField("in_req_gbn")
	private String inReqGbn;
	
	
	/**
	 * 검색조건
	 */
	@Data
	@NoArgsConstructor
	@AllArgsConstructor
	public static class Criteria extends SmsbBaseModel {
	
		/**
		 * 채널 코드
		 */
		@MapField("in_chnl_cd")
		private String schChnlCd;
		/**
		 * 약관 유형 코드
		 */
		@MapField("in_term_patr_dvcd")
		private String schTermPatrDvcd;
		
		/**
		 * 약관 명
		 */
		@MapField("in_term")
		private String schTermNm;
		
		/**
		 * 기준 일자
		 */
		@MapField("in_apl_dt")
		private String schAplDt;

		
	}
}
