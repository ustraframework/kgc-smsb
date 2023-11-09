package kr.co.kgc.smsb.common.base.config.authentication.user;

import java.time.LocalDateTime;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;

import com.gsitm.ustra.java.security.authentication.user.UstraUser;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public abstract class SmsbUser extends UstraUser {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -7684975026373730096L;

	protected SmsbUser(String username, String password, boolean enabled, boolean accountNonExpired,
			boolean credentialsNonExpired, boolean accountNonLocked,
			Collection<? extends GrantedAuthority> authorities) {
		super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
	}


	/**
	 * 노출 명
	 */
	private String displayName;

	/**
	 * 사용자 아이디
	 */
	private String userId;

	/**
	 * 로그인 실패 수
	 */
	private Integer loginFailCnt;

	/**
	 * 패스워드 초기화 여부
	 */
	private boolean resetPassword;

	/**
	 * 패스워드 변경 필요 여부
	 */
	private boolean requiredChangePassword;

	/**
	 * 최종 접속일
	 */
	private LocalDateTime lastConnectedDttm;

	/**
	 * 최종 접속 아이피
	 */
	private String lastConnIp;

}
