package kr.co.kgc.smsb.common.base.exception;

import com.gsitm.ustra.java.core.exception.ResponseCode;
import com.gsitm.ustra.java.core.exception.UstraCoreException;
import com.gsitm.ustra.java.core.exception.UstraException;

public enum SmsbResponseCode implements ResponseCode {

	FAILURE_SSO_LOGIN("4001", "SSO 인증을 실패하였습니다."),
	REQUIRE_TRY_SSO("4002", "SSO 인증 확인이 필요합니다."),
	INVALID_AUTHENTICATION_REQUEST_INFO("4003", "잘못된 인증 요청 정보입니다."),
	CANNOT_FOUND_AUTHENTICATION_USER("4004", "조회된 사용자 정보가 없습니다."),


	HAS_ERROR_ON_DRM_CONVERSION("SY01", "DRM 파일 변환 중 오류가 발생하였습니다. 오류코드 : {0}"),
	INVALIDATE_PASSWORD("SY02", "유효하지 않은 비밀번호입니다. : {0}"),

	HAS_ERROR_REGISTER_SUPPC("SC01", "공급사 가입 신청 중 오류가 발생하였습니다."),
	CANNOT_FOUND_USER("SC02", "사용자를 찾을 수 없습니다."),
	CANNOT_APPROVE_USER_STATUS("SC03", "승인할 수 없는 사용자입니다."),
	CANNOT_REJECT_USER_STATUS("SC04", "비승인할 수 없는 사용자입니다."),
	CANNOT_STOP_USER_STATUS("SC05", "중단할 수 없는 사용자입니다."),
	CANNOT_AVAILABLE_USER_STATUS("SC06", "중단해제할 수 없는 사용자입니다."),
	ALREADY_INITIALIZED_PASSWORD_USER("SC07", "이미 비밀번호가 초기화된 사용자입니다."),
	CANNOT_CHANGE_MASTER_USER("SC08", "마스터 사용자로 전환할 수 없습니다."),
	MUST_HAVE_MASTER_USER("SC09", "마스터 사용자는 한 명 이상 존재해야 합니다."),
	NOT_AVALIABLE_SET_AUTHORITY("SC10", "사용자에게 배정 불가능한 권한이 할당되었습니다."),


	EXISTS_EMAIL("SC11", "이미 사용 중인 이메일 주소입니다. 다른 이메일 주소를 사용해 주십시오."),
	EXISTS_TEL_NO("SC12", "이미 사용 중인 전화번호입니다. 다른 전화번호를 사용해 주십시오."),

	HAS_ERROR_REGISTER_MEMBER("CU01", "가입 신청 정보 등록 중 오류가 발생하였습니다."),
	HAS_ERROR_UPDATE_MEMBER("CU02", "사용자 정보 수정 중 오류가 발생하였습니다."),
	HAS_ERROR_UPDATE_COMPANY("CU03", "회원사 정보 수정 중 오류가 발생하였습니다."),
	CANNOT_REMOVE_MASTER_USER("CU04", "마스터 사용자는 삭제할 수 없습니다."),
	APPLICATION_STATUS_USER("CU05", "관리자 승인 대기 중입니다. 승인 완료 후 이용가능합니다."),
	INVALID_REFUND_BANK_ACCOUNT("CU07", "유효하지 않은 환불계좌 정보입니다. 재 확인 후 입력해주세요.");


	private String code;
	private String message;

	SmsbResponseCode(String code, String message) {
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
		return new UstraCoreException(this);
	}

	public UstraException exception(String message) {
		return new UstraCoreException(this, message);
	}
}