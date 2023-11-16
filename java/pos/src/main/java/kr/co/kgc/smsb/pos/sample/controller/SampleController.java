package kr.co.kgc.smsb.pos.sample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.co.kgc.smsb.pos.config.SmsbPosConfigProperties;

@RestController
@RequestMapping("/api/sample")
public class SampleController {

	
	/**
	 * 프로퍼티 조회
	 */
	@Autowired private SmsbPosConfigProperties smsbPosConfigProperties;
	@GetMapping("/get-prop")
	public String getProp() {
		return this.smsbPosConfigProperties.getSampleProp();
	}
}
