package kr.co.kgc.smsb.api.sample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.co.kgc.smsb.api.config.SmsbApiConfigProperties;

@RestController
@RequestMapping("/api/sample")
public class SampleController {

	
	/**
	 * 프로퍼티 조회
	 */
	@Autowired private SmsbApiConfigProperties smsbApiConfigProperties;
	@GetMapping("/get-prop")
	public String getProp() {
		return this.smsbApiConfigProperties.getSampleProp();
	}
}
