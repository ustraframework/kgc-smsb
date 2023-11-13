package kr.co.kgc.smsb.common.base.config.authentication;

import javax.validation.constraints.NotNull;

import org.springframework.lang.Nullable;

import com.gsitm.ustra.java.security.authentication.authentication.checker.UstraAuthenticationKeyChecker;
import com.gsitm.ustra.java.security.authentication.listener.UstraAuthenticationListener;
import com.gsitm.ustra.java.security.authentication.processor.UstraAuthenticationProcessor;
import com.gsitm.ustra.java.security.authentication.properties.UstraAuthenticationProperties;
import com.gsitm.ustra.java.security.authentication.request.UstraAuthenticationRequestTokenChecker;
import com.gsitm.ustra.java.security.authentication.request.token.UstraAuthenticationRequestToken;
import com.gsitm.ustra.java.security.authentication.user.UstraUserDetailProvider;
import com.gsitm.ustra.java.security.authentication.user.checker.UstraUserDetailChecker;
import com.gsitm.ustra.java.security.jwt.authentication.UstraJwtAuthenticationConfigurer;
import com.gsitm.ustra.java.security.jwt.authentication.authentication.UstraJwtAuthentication;
import com.gsitm.ustra.java.security.jwt.authentication.claims.UstraJwtClaimAppender;
import com.gsitm.ustra.java.security.jwt.authentication.properties.UstraJwtAuthenticationProperties;
import com.gsitm.ustra.java.security.jwt.authentication.store.UstraJwtRefreshTokenStore;

/**
 * ¿Œ¡ı Configuration
 */
public class SmsbAuthenticationConfigurer implements UstraJwtAuthenticationConfigurer<UstraAuthenticationRequestToken, UstraJwtAuthentication> {

	private UstraJwtAuthenticationProperties properties;
	private UstraJwtRefreshTokenStore refreshTokenStore;
	private UstraUserDetailProvider<UstraAuthenticationRequestToken, UstraJwtAuthentication> userDetailProvider;
	private UstraJwtClaimAppender jwtClaimAppender;
	private UstraAuthenticationListener<UstraAuthenticationRequestToken, UstraJwtAuthentication> authenticationListener;
	private UstraAuthenticationRequestTokenChecker<UstraAuthenticationRequestToken> requestTokenChecker;
	private UstraAuthenticationKeyChecker<UstraJwtAuthentication> keyChecker;
	private UstraUserDetailChecker<UstraAuthenticationRequestToken> userDetailChecker;

	public SmsbAuthenticationConfigurer(
			UstraJwtAuthenticationProperties properties,
			UstraJwtRefreshTokenStore refreshTokenStore,
			UstraUserDetailProvider<UstraAuthenticationRequestToken, UstraJwtAuthentication> userDetailProvider,
			UstraJwtClaimAppender jwtClaimAppender,
			@Nullable
			UstraAuthenticationListener<UstraAuthenticationRequestToken, UstraJwtAuthentication> authenticationListener) {
		this(properties, refreshTokenStore, userDetailProvider, jwtClaimAppender, authenticationListener, null, null);
	}

	public SmsbAuthenticationConfigurer(
			UstraJwtAuthenticationProperties properties,
			UstraJwtRefreshTokenStore refreshTokenStore,
			UstraUserDetailProvider<UstraAuthenticationRequestToken, UstraJwtAuthentication> userDetailProvider,
			UstraJwtClaimAppender jwtClaimAppender,
			@Nullable
			UstraAuthenticationListener<UstraAuthenticationRequestToken, UstraJwtAuthentication> authenticationListener,
			UstraAuthenticationRequestTokenChecker<UstraAuthenticationRequestToken> requestTokenChecker,
			UstraAuthenticationKeyChecker<UstraJwtAuthentication> keyChecker
			) {
		this(properties, refreshTokenStore, userDetailProvider, jwtClaimAppender, authenticationListener, requestTokenChecker, keyChecker, null);
	}

	public SmsbAuthenticationConfigurer(
			UstraJwtAuthenticationProperties properties,
			UstraJwtRefreshTokenStore refreshTokenStore,
			UstraUserDetailProvider<UstraAuthenticationRequestToken, UstraJwtAuthentication> userDetailProvider,
			UstraJwtClaimAppender jwtClaimAppender,
			@Nullable
			UstraAuthenticationListener<UstraAuthenticationRequestToken, UstraJwtAuthentication> authenticationListener,
			UstraAuthenticationRequestTokenChecker<UstraAuthenticationRequestToken> requestTokenChecker,
			UstraAuthenticationKeyChecker<UstraJwtAuthentication> keyChecker,
			UstraUserDetailChecker<UstraAuthenticationRequestToken> userDeailChecker
			) {
		this.properties = properties;
		this.refreshTokenStore = refreshTokenStore;
		this.userDetailProvider = userDetailProvider;
		this.jwtClaimAppender = jwtClaimAppender;
		this.authenticationListener = authenticationListener;
		this.requestTokenChecker = requestTokenChecker;
		this.keyChecker = keyChecker;
		this.userDetailChecker = userDeailChecker;
	}

	@Override
	public UstraAuthenticationRequestTokenChecker<UstraAuthenticationRequestToken> requestTokenChecker(
			UstraAuthenticationProcessor<UstraAuthenticationRequestToken, UstraJwtAuthentication> processor) {
		return this.requestTokenChecker != null ? this.requestTokenChecker :
			UstraJwtAuthenticationConfigurer.super.requestTokenChecker(processor);
	}

	@Override
	public UstraAuthenticationProperties authenticationProperties(
			UstraAuthenticationProcessor<UstraAuthenticationRequestToken, UstraJwtAuthentication> processor) {
		return this.properties;
	}

	@Override
	public UstraJwtRefreshTokenStore jwtRefreshTokenStore(
			UstraAuthenticationProcessor<UstraAuthenticationRequestToken, UstraJwtAuthentication> processor) {
		return this.refreshTokenStore;
	}

	@Override
	public @NotNull UstraJwtClaimAppender jwtClaimAppender(
			UstraAuthenticationProcessor<UstraAuthenticationRequestToken, UstraJwtAuthentication> processor) {
		return this.jwtClaimAppender;
	}

	@Override
	public @NotNull UstraUserDetailProvider<UstraAuthenticationRequestToken, UstraJwtAuthentication> userDetailProvider(
			UstraAuthenticationProcessor<UstraAuthenticationRequestToken, UstraJwtAuthentication> processor) {
		return this.userDetailProvider;
	}

	@Override
	public UstraAuthenticationListener<UstraAuthenticationRequestToken, UstraJwtAuthentication> authenticationListener(
			UstraAuthenticationProcessor<UstraAuthenticationRequestToken, UstraJwtAuthentication> processor) {
		return this.authenticationListener;
	}

	@Override
	public UstraAuthenticationKeyChecker<UstraJwtAuthentication> authenticationKeyChecker(
			UstraAuthenticationProcessor<UstraAuthenticationRequestToken, UstraJwtAuthentication> processor) {
		return this.keyChecker;
	}

	@Override
	public UstraUserDetailChecker<UstraAuthenticationRequestToken> userDetailChecker(
			UstraAuthenticationProcessor<UstraAuthenticationRequestToken, UstraJwtAuthentication> processor) {
		return this.userDetailChecker == null ? UstraJwtAuthenticationConfigurer.super.userDetailChecker(processor) : this.userDetailChecker;
	}

}
