package kr.co.kgc.smsb.bo.sample.model;

import com.gsitm.ustra.java.core.utils.UstraMaskingUtils.MaskingType;
import com.gsitm.ustra.java.core.utils.annotation.Masked;
import com.gsitm.ustra.java.management.models.base.UstraManagementBaseModel;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 사용자 (USTRA_USR)
 * @author keymasroy<keymasroy@gsitm.com>
 *
 */
@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
public class UserModel extends UstraManagementBaseModel {

	/**
	 * 사용자 아이디
	 */
	@NotBlank
	private String usrId;

	/**
	 * 사용자 명
	 */
	@NotBlank
	@Masked(MaskingType.NAME)
	private String usrNm;

	/**
	 * 부서 코드
	 */
	private String deptCd;

	/**
	 * 부서 명
	 */
	private String deptNm;

	/**
	 * 비밀번호
	 */
	@NotEmpty
	private String pwd;

	/**
	 * 비밀번호 최종 업데이트 일시
	 */
	private LocalDateTime pwdLstUpdDttm;

	/**
	 * 이메일
	 */
	@Masked(MaskingType.EMAIL)
	private String email;

	/**
	 * 전화번호
	 */
	@Masked(MaskingType.PHONE)
	private String phNo;

	/**
	 * 핸드폰 번호
	 */
	@Masked(MaskingType.PHONE)
	private String cphNo;

	/**
	 * 팩스 번호
	 */
	@Masked(MaskingType.PHONE)
	private String faxNo;

	/**
	 * 사용자 상태코드
	 */
	private String usrSttCd;

	/**
	 * 사용시작일
	 */
	private String useSrtDt;

	/**
	 * 사용종료일
	 */
	private String useEndDt;

	/**
	 * 사용 구분코드
	 */
	@NotBlank
	private String useDvCd;

	/**
	 * 사용구분 명
	 */
	private String useDvNm;

	/**
	 * 최종 로그인일시
	 */
	private LocalDateTime lstLoginDttm;

	/**
	 * 로그인 실패 수
	 */
	private Integer loginFailCnt;

	/**
	 * 비밀번호 초기화 여부
	 */
	private String pwdResetYn;

	/**
	 * IP 제한여부
	 */
	private String ipLmtYn;

	/**
	 * IP 목록
	 */
	private String ipList;

	/**
	 * 사번
	 */
	private String empNo;

	/**
	 * 비고
	 */
	private String rmk;

	/**
	 * 회사코드
	 */
	private String orgCd;

	/**
	 * 승인 완료 여부
	 */
	private String apvCmplYn;

	/**
	 * 사용자 승인 아이디
	 */
	private Integer usrApvId;

	/**
	 * 권한 그룹
	 */
	private String authGrp;

	/**
	 * 이전 비밀번호
	 */
	private String oldPwd;

	/**
	 * 권한 그룹 목록
	 */
	private List<Integer> authGrps;

	/**
	 * 검색 조건
	 * @author keymasroy<keymasroy@gsitm.com>
	 *
	 */
	@Data
	@Builder
	@NoArgsConstructor
	@AllArgsConstructor
	public static class Criteria {
		/**
		 * 사용자 아이디
		 */
		private String usrId;

		/**
		 * 사용자 명
		 */
		private String usrNm;

		/**
		 * 사용자 상태 코드
		 */
		private String usrSttCd;

		/**
		 * 사용 구분 코드
		 */
		private String useDvCd;

		/**
		 * 사용 구분 코드 목록
		 */
		private List<String> useDvCds;

		/**
		 * 부서 명 (코드 포함)
		 */
		private String deptNm;

		/**
		 * 권한 그룹 미존재 여부
		 */
		private String authGrpNoneYn;

		/**
		 * 권한 그룹 정보 포함 여부
		 */
		private Boolean showAuthNoneGrp;

		/**
		 * 정렬 컬럼 명
		 *  ex) REG_DTTM DESC
		 */
		private String sortColName;

		/**
		 * 개인정보 마스킹 여부
		 */
		private boolean maskPrivateInfo;
	}

}
