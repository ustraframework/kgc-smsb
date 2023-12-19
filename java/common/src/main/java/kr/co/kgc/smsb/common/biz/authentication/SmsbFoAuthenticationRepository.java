package kr.co.kgc.smsb.common.biz.authentication;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SmsbFoAuthenticationRepository {
	SmsbFoAuthenticationModel selectUser(String webId);
}
