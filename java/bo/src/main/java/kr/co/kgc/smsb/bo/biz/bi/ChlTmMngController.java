package kr.co.kgc.smsb.bo.biz.bi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.co.kgc.smsb.common.biz.bi.tm.model.ChlTmMngDto;
import kr.co.kgc.smsb.common.biz.bi.tm.model.ChlTmMngProcModel;
import kr.co.kgc.smsb.common.biz.bi.tm.service.ChlTmMngService;

@RestController
@RequestMapping("/api/biz/bi/tm/chl-tm-mgnt")
public class ChlTmMngController {

	@Autowired private ChlTmMngService chlTmMngService;
	
	@PostMapping("/gets")
	public ChlTmMngProcModel get(@RequestBody ChlTmMngDto.Criteria in) {
		return chlTmMngService.get(in);
	}
	
	@PostMapping("/save")
	public ChlTmMngProcModel save(@RequestBody ChlTmMngDto in) {
		return chlTmMngService.save(in);
	}
}
