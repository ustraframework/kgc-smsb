package kr.co.kgc.smsb.bo.sample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.co.kgc.smsb.bo.config.BoConfigProperties;

@RestController
@RequestMapping("/api/sample")
public class SampleController {

	@Autowired BoConfigProperties boConfigProperties;
	
	@GetMapping("/get-prop")
	String getCmmCds() {
		return boConfigProperties.getSampleProp();
	}
}
