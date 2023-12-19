package kr.co.kgc.smsb.fo.config.authentication;

import lombok.Data;

@Data
public class LoginResultModel {

	private String resCd;

	/**
	 * 인증 여부
	 */
	private boolean isAuthenticated;

	/**
	 * 사용자 조회 여부
	 */
	private boolean hasUser;

	/**
	 * 사용자 아이디
	 */
	private String userKey;

	/**
	 * 사용자 명
	 */
	private String userName;

	/**
	 * 패스워드 초기화 여부
	 */
	private boolean resetPassword;

	/**
	 * 로그인 실패 수
	 */
	private Integer loginFailCnt;

	/**
	 * 비밀번호 미변경 일 수
	 */
	private boolean requiredChangePassword;

	/**
	 * 세션 아이디
	 */
	private String sessionId;
}
