package kr.co.kgc.smsb.bo.sample.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.co.kgc.smsb.bo.config.BoConfigProperties;
import kr.co.kgc.smsb.bo.sample.model.SampleProcInutModel;
import kr.co.kgc.smsb.bo.sample.model.SampleProcOutModel;
import kr.co.kgc.smsb.bo.sample.service.SampleProcService;

@RestController
@RequestMapping("/api/sample")
public class SampleController {

	@Autowired private BoConfigProperties boConfigProperties;
	
	@GetMapping("/get-prop")
	public String getCmmCds() {
		return this.boConfigProperties.getSampleProp();
	}
	
	@Autowired private SampleProcService sampleProcService;
	@PostMapping("/get-proc")
	public Map<String,Object> sampleProc(@RequestBody SampleProcInutModel in) {
		return sampleProcService.sampleProc(in);
	}
	
	@PostMapping("/get-proc-list")
	public SampleProcOutModel sampleProcList(@RequestBody SampleProcInutModel in) {
		return sampleProcService.sampleProcList(in);
	}
}
