package kr.co.kgc.smsb.bo.sample.model;

import com.gsitm.ustra.java.core.utils.UstraMaskingUtils.MaskingType;
import com.gsitm.ustra.java.core.utils.annotation.Masked;
import com.gsitm.ustra.java.management.models.base.UstraManagementBaseModel;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.NotEmpty;

/**
 * 사용자 권한 그룹 모델 (USTRA_AUTH_GRP)
 * @author RoyLee
 *
 */
@Data
@SuperBuilder
@EqualsAndHashCode(callSuper=false)
@NoArgsConstructor
@AllArgsConstructor
public class AuthorityGroupUserModel extends UstraManagementBaseModel {

	/**
	 * 권한 그룹 아이디
	 */
	@NotEmpty
	private Integer authGrpId;

	/**
	 * 권한 그룹 명
	 */
	private String authGrpNm;

	/**
	 * 사용자 아이디
	 */
	@NotEmpty
	@Masked(MaskingType.ID)
	private String usrId;

	/**
	 * 사용자 명
	 */
	@Masked(MaskingType.NAME)
	private String usrNm;

	/**
	 * 부서 명
	 */
	private String deptNm;

	/**
	 * 상태 코드
	 */
	private String usrSttCd;

	/**
	 * 사용 구분 코드
	 */
	private String useDvCd;

	/**
	 * 조건
	 * @author RoyLee
	 *
	 */
	@Data
	@Builder
	@NoArgsConstructor
	@AllArgsConstructor
	public static class Criteria {

		/**
		 * 권한 그룹 아이디
		 */
		private Integer authGrpId;
	}
}
