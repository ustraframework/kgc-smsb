package kr.co.kgc.smsb.common.base.config.authentication;

import com.gsitm.ustra.java.management.services.defaults.DefaultUstraManagementRefreshTokenService;
import com.gsitm.ustra.java.security.authentication.request.token.UstraAuthenticationRequestToken;
import com.gsitm.ustra.java.security.jwt.authentication.UstraJwtAuthenticationConfigurer;
import com.gsitm.ustra.java.security.jwt.authentication.authentication.UstraJwtAuthentication;
import com.gsitm.ustra.java.security.jwt.authentication.parser.UstraJwtAuthenticationParser;
import com.gsitm.ustra.java.security.jwt.authentication.processor.UstraJwtAuthenticationProcessor;
import com.gsitm.ustra.java.security.jwt.authentication.properties.UstraJwtAuthenticationProperties;

import kr.co.kgc.smsb.common.base.config.authentication.claim.SmsbFoJwtClaimAppender;
import kr.co.kgc.smsb.common.base.config.authentication.listener.SmsbFoAuthenticationListener;
import kr.co.kgc.smsb.common.base.config.authentication.user.SmsbFoUserDetailChecker;
import kr.co.kgc.smsb.common.base.config.authentication.user.SmsbFoUserDetailProvider;

public class SmsbAuthenticationProcessor extends UstraJwtAuthenticationProcessor<UstraAuthenticationRequestToken, UstraJwtAuthentication> {

	public SmsbAuthenticationProcessor(UstraJwtAuthenticationConfigurer<UstraAuthenticationRequestToken, UstraJwtAuthentication> configurer) {
		super(configurer, UstraJwtAuthentication.class);
	}

	/**
	 * BO Authentication Processor 생성
	 * @param properties
	 * @param requestTokenChecker
	 * @return
	 */
//	public static SmsbAuthenticationProcessor createBoProcessor(UstraJwtAuthenticationProperties properties, UstraAuthenticationRequestTokenChecker<UstraAuthenticationRequestToken> requestTokenChecker) {
//
//		SmsbAuthenticationConfigurer configurer = new SmsbAuthenticationConfigurer(
//				properties,
//				new DefaultUstraManagementRefreshTokenService(UstraJwtAuthenticationParser.from(properties)),
//				new SmsbBoUserDetailProvider<SmsbBoUser>(SmsbBoUser.class),
//				new SmsbBoJwtClaimAppender(),
//				new SmsbBoAuthenticationListener(),
//				requestTokenChecker,
//				null);
//
//		return new SmsbAuthenticationProcessor(configurer);
//	}


	/**
	 * PO Authentication Processor 생성
	 * @param properties
	 * @param requestTokenChecker
	 * @return
	 */
//	public static SmsbAuthenticationProcessor createPoProcessor(UstraJwtAuthenticationProperties properties) {
//
//		SmsbAuthenticationConfigurer configurer = new SmsbAuthenticationConfigurer(
//				properties,
//				new DefaultUstraManagementRefreshTokenService(UstraJwtAuthenticationParser.from(properties)),
//				new SmsbPoUserDetailProvider(),
//				new SmsbPoJwtClaimAppender(),
//				new SmsbPoAuthenticationListener(),
//				null,
//				new SmsbPoAuthenticationKeyChecker());
//
//		return new SmsbAuthenticationProcessor(configurer);
//	}


	/**
	 * FO Authentication Processor 생성
	 * @param properties
	 * @param requestTokenChecker
	 * @return
	 */
	public static SmsbAuthenticationProcessor createFoProcessor(UstraJwtAuthenticationProperties properties) {

		SmsbAuthenticationConfigurer configurer = new SmsbAuthenticationConfigurer(
				properties,
				new DefaultUstraManagementRefreshTokenService(),
				new SmsbFoUserDetailProvider(),
				new SmsbFoJwtClaimAppender(),
				new SmsbFoAuthenticationListener(),
				null,
				null, // new SmsbFoAuthenticationKeyChecker(),
				new SmsbFoUserDetailChecker());

		return new SmsbAuthenticationProcessor(configurer);
	}
}
