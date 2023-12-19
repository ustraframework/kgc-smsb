package kr.co.kgc.smsb.common.base.config.authentication.user;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.security.core.GrantedAuthority;

import com.gsitm.ustra.java.security.authentication.cache.SecurityCacheSupport;
import com.gsitm.ustra.java.security.authentication.request.token.UstraAuthenticationRequestToken;
import com.gsitm.ustra.java.security.authentication.user.UstraAnonymousUser;
import com.gsitm.ustra.java.security.authentication.user.UstraCachedUserDetailProvider;
import com.gsitm.ustra.java.security.authentication.user.UstraUser;
import com.gsitm.ustra.java.security.jwt.authentication.authentication.UstraJwtAuthentication;

import kr.co.kgc.smsb.common.biz.authentication.SmsbFoAuthenticationModel;
import kr.co.kgc.smsb.common.biz.authentication.SmsbFoAuthenticationRepository;

/**
 * FO 사용자 조회 처리
 */
public class SmsbFoUserDetailProvider extends UstraCachedUserDetailProvider<UstraAuthenticationRequestToken, UstraJwtAuthentication, SmsbFoUser> {

	@Autowired SmsbFoAuthenticationRepository smsbFoAuthenticationRepository;
	
	
	public SmsbFoUserDetailProvider() {
		super(SmsbFoUser.class);
	}


	@Override
	protected UstraUser getInternalUserDetails(UstraAuthenticationRequestToken authenticationRequestToken) {
		return this.getUser(authenticationRequestToken.getUserName(), "10,20");
	}

	@Override
	protected UstraUser getInternalUserDetails(UstraJwtAuthentication authentication) {
		if (authentication == null) {
			return new UstraAnonymousUser(new ArrayList<>());
		}

		if (authentication instanceof UstraJwtAuthentication) {
			UstraJwtAuthentication jwtAuthentication = (UstraJwtAuthentication)authentication;

			if (jwtAuthentication.getClaims() == null ||
					StringUtils.isEmpty(jwtAuthentication.getClaims().getSubject())) {
				return new UstraAnonymousUser(new ArrayList<>());
			}
		}

		if (authentication.isAnonymous()) {
			return new UstraAnonymousUser(new ArrayList<>());
		}


		return this.getUser(authentication.getName(), "10,20");
	}

	@Override
	protected Cache getCache() {
		return SecurityCacheSupport.getDefaultUserCache();
	}


	/**
	 * 사용자 정보 조회
	 * @return 조회 사용자 정보
	 */
	protected SmsbFoUser getUser(String userName, String useDvCds) {

		
		SmsbFoAuthenticationModel user = smsbFoAuthenticationRepository.selectUser(userName);

		if (user == null) {
			return null;
		}

		boolean isEnabled = this.isEnabledUser(user);
		boolean isNonExpiredUser = this.isNonExpiredUser(user);
		boolean isCredentialsNonExpiredUser = this.isCredentialsNonExpiredUser(user);
		boolean isAccountNonLockedUser = this.isAccountNonLockedUser(user);
		
		List<GrantedAuthority> authorities = new ArrayList<>();
		
		SmsbFoUser userDetail = new SmsbFoUser(
				user.getWebId(),
				user.getLgnPwd(),
				isEnabled,
				isNonExpiredUser,
				isCredentialsNonExpiredUser,
				isAccountNonLockedUser,
				authorities);

		userDetail.setDisplayName(user.getMembNm());
		userDetail.setUserId(user.getWebId());
		userDetail.setLoginFailCnt(user.getLgnFailCnt());
		// TODO: 비밀번호 강제 설정 로직 반영
		userDetail.setResetPassword(false);

		return userDetail;
	}

	/**
	 * 활성화 된 사용자인지 체크
	 *
	 * @param user
	 * @return
	 */
	protected boolean isEnabledUser(final SmsbFoAuthenticationModel user) {

		// TODO: 사용자 활성 체크 로직 추가
		return true;
	}

	/**
	 * 만료되지 않은 사용자인지 체크
	 *
	 * @param user
	 * @return
	 */
	protected boolean isNonExpiredUser(final SmsbFoAuthenticationModel user) {

		// TODO: 계정 만료 기간 체크 로직 추가
		return true;
	}

	/**
	 * 패스워드가 만료되지 않은 사용자인지 확인
	 *
	 * @param user
	 * @return
	 */
	protected boolean isCredentialsNonExpiredUser(final SmsbFoAuthenticationModel user) {
		// TODO: 패스워드 만료 체크 로직 추가
		return true;
	}

	/**
	 * 계정이 블락되지 않은 사용자인지 확인
	 *
	 * @param user
	 * @return
	 */
	protected boolean isAccountNonLockedUser(final SmsbFoAuthenticationModel user) {
		// TODO: 계정 블락 체크 로직 추가
		return true;
	}


}
