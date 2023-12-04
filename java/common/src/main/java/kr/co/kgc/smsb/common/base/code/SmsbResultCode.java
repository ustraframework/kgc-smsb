package kr.co.kgc.smsb.common.base.code;

public interface SmsbResultCode {

	/**
	 * 응답 코드
	 */
	String getCode();

	/**
	 * 응답 메시지
	 */
	String getMessage();

	/**
	 * 성공 여부
	 */
	default boolean isSuccess() {
		return "0000".equals(this.getCode());
	};
}