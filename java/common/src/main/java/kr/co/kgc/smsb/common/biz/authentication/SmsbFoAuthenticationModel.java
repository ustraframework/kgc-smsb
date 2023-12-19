package kr.co.kgc.smsb.common.biz.authentication;

import lombok.Data;

@Data
public class SmsbFoAuthenticationModel {
	private String webId;
	private String lgnPwd;
	private String umbrno;
	private int lgnFailCnt;
	private String membNm;
}
