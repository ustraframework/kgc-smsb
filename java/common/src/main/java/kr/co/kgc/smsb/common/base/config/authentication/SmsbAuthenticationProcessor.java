package kr.co.kgc.smsb.common.base.config.authentication;

import com.gsitm.ustra.java.management.services.defaults.DefaultUstraManagementRefreshTokenService;
import com.gsitm.ustra.java.security.authentication.request.UstraAuthenticationRequestTokenChecker;
import com.gsitm.ustra.java.security.authentication.request.token.UstraAuthenticationRequestToken;
import com.gsitm.ustra.java.security.jwt.authentication.UstraJwtAuthenticationConfigurer;
import com.gsitm.ustra.java.security.jwt.authentication.authentication.UstraJwtAuthentication;
import com.gsitm.ustra.java.security.jwt.authentication.parser.UstraJwtAuthenticationParser;
import com.gsitm.ustra.java.security.jwt.authentication.processor.UstraJwtAuthenticationProcessor;
import com.gsitm.ustra.java.security.jwt.authentication.properties.UstraJwtAuthenticationProperties;

import kr.co.kgc.smsb.common.base.config.authentication.claim.SmsbBoJwtClaimAppender;
import kr.co.kgc.smsb.common.base.config.authentication.listener.SmsbBoAuthenticationListener;

public class SmsbAuthenticationProcessor extends UstraJwtAuthenticationProcessor<UstraAuthenticationRequestToken, UstraJwtAuthentication> {

	public SmsbAuthenticationProcessor(UstraJwtAuthenticationConfigurer<UstraAuthenticationRequestToken, UstraJwtAuthentication> configurer) {
		super(configurer, UstraJwtAuthentication.class);
	}

	/**
	 * BO Authentication Processor 持失
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
	 * PO Authentication Processor 持失
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
	 * FO Authentication Processor 持失
	 * @param properties
	 * @param requestTokenChecker
	 * @return
	 */
//	public static SmsbAuthenticationProcessor createFoProcessor(UstraJwtAuthenticationProperties properties) {
//
//		SmsbAuthenticationConfigurer configurer = new SmsbAuthenticationConfigurer(
//				properties,
//				new DefaultUstraManagementRefreshTokenService(UstraJwtAuthenticationParser.from(properties)),
//				new SmsbFoUserDetailProvider(),
//				new SmsbFoJwtClaimAppender(),
//				new SmsbFoAuthenticationListener(),
//				null,
//				new SmsbFoAuthenticationKeyChecker(),
//				new SmsbFoUserDetailChecker());
//
//		return new SmsbAuthenticationProcessor(configurer);
//	}
}
