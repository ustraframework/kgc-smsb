package kr.co.kgc.smsb.pos.exception;

import com.gsitm.ustra.java.core.exception.ResponseCode;
import com.gsitm.ustra.java.core.exception.UstraException;
import com.gsitm.ustra.java.security.exception.UstraSecurityException;

public enum SmsbPosResponseCode implements ResponseCode {

	FAILURE_SSO_LOGIN("4001", "SSO 인증을 실패하였습니다.");

	private String code;
	private String message;

	SmsbPosResponseCode(String code, String message) {
		this.code = code;
		this.message = message;
	}

	@Override
	public String getCode() {
		return this.code;
	}

	@Override
	public String getMessage() {
		return this.message;
	}

	public UstraException exception() {
		return new UstraSecurityException(this);
	}
}