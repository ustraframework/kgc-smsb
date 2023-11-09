package kr.co.kgc.smsb.common.base.config.authentication.user;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class SmsbBoUser extends SmsbUser {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 7647995839620972648L;


	@JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
	public SmsbBoUser(
			@JsonProperty("username") String username,
			@JsonProperty("password") String password,
			@JsonProperty("enabled") boolean enabled,
			@JsonProperty("accountNonExpired") boolean accountNonExpired,
			@JsonProperty("credentialsNonExpired") boolean credentialsNonExpired,
			@JsonProperty("accountNonLocked") boolean accountNonLocked,
			@JsonProperty("authorities") Collection<? extends GrantedAuthority> authorities) {
		super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
	}

	/**
	 * 개인정보 관리자 여부
	 */
	private boolean isPrivacyInfoManager = false;

	/**
	 * 부서 명
	 */
	private String deptNm;

	/**
	 * 공급사 코드
	 */
	private String suppcCd;

	/**
	 * 공급사 명
	 */
	private String suppcNm;

	/**
	 * 직급 명
	 */
	private String rankNm;
}
