package kr.co.kgc.smsb.common.base.config.authentication.permission;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import org.springframework.core.annotation.AliasFor;

import com.gsitm.ustra.java.security.authority.permission.Permission;

@Retention(RUNTIME)
@Target({ TYPE, METHOD })
@Permission
public @interface MasterPermission {
	@AliasFor(annotation = Permission.class, attribute = "roles")
	String[] roles() default { Permissions.ROLE_MASTER };
}
