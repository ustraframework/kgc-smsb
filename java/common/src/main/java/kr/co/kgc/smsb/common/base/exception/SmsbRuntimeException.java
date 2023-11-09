package kr.co.kgc.smsb.common.base.exception;

public class SmsbRuntimeException extends RuntimeException {

	private static final long serialVersionUID = 9145766571988970724L;

	private SmsbRuntimeException() {
		super();
	}

	private SmsbRuntimeException(String message) {
		super(message);
	}

	private SmsbRuntimeException(Throwable cause) {
		super(cause);
	}

	private SmsbRuntimeException(String message, Throwable cause) {
		super(message, cause);
	}
}
