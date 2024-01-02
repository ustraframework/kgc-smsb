package kr.co.kgc.smsb.bo.sample.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gsitm.ustra.java.data.domains.PaginationList;

import kr.co.kgc.smsb.bo.config.BoConfigProperties;
import kr.co.kgc.smsb.bo.sample.model.SampleDto;
import kr.co.kgc.smsb.bo.sample.model.SampleProcInutModel;
import kr.co.kgc.smsb.bo.sample.model.SampleProcOutModel;
import kr.co.kgc.smsb.bo.sample.service.SamplePaginationService;
import kr.co.kgc.smsb.bo.sample.service.SampleProcService;

@RestController
@RequestMapping("/api/sample")
public class SampleController {

	/**
	 * 프로퍼티 조회
	 */
	@Autowired private BoConfigProperties boConfigProperties;
	@GetMapping("/get-prop")
	public String getProp() {
		return this.boConfigProperties.getSampleProp();
	}

	@GetMapping("/get-props")
	public BoConfigProperties getProps() {
		return this.boConfigProperties;
	}
	
	/**
	 * 프로시저 조회 - Map
	 */
	@Autowired private SampleProcService sampleProcService;
	@PostMapping("/get-proc")
	public Map<String,Object> sampleProc(@RequestBody SampleProcInutModel in) {
		return sampleProcService.sampleProc(in);
	}
	/**
	 * 프로시저 조회 - Class
	 */
	@PostMapping("/get-proc-list")
	public SampleProcOutModel sampleProcList(@RequestBody SampleProcInutModel in) {
		return sampleProcService.sampleProcList(in);
	}
	
	/**
	 * 프로시저 조회 - Class
	 */
	@PostMapping("/get-proc-list-repo")
	public SampleProcOutModel sampleProcListByRepo(@RequestBody SampleProcInutModel in) {
		return sampleProcService.sampleProcListByRepo(in);
	}
	
	/**
	 * 페이징 조회 - 쿼리xml
	 */
	@Autowired private SamplePaginationService samplePaginationService;
	@GetMapping("/get-cmm-cds-by-header")
	// @Permission
	PaginationList<SampleDto> getCmmCdsByHeader(
			@RequestParam(required = false) String grpCd,
			@RequestParam(required = false) String dtlCd) {
		return samplePaginationService.getCmmCdPageList(
				SampleDto.Criteria
					.builder()
					.grpCd(grpCd)
					.dtlCd(dtlCd)
					.build()
				);
	}
	
	/**
	 * 페이징 조회 - SP
	 */
	@GetMapping("/get-cmm-cds-by-header-sp")
	// @Permission
	PaginationList<SampleDto> getCmmCdsByHeaderSp(
			@RequestParam(required = false) String grpCd,
			@RequestParam(required = false) String dtlCd) {
		return samplePaginationService.getCmmCdPageSpList(
				SampleDto.Criteria
					.builder()
					.grpCd(grpCd)
					.dtlCd(dtlCd)
					.build()
				);
	}
}
