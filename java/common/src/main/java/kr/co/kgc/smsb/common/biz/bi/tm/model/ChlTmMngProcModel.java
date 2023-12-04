package kr.co.kgc.smsb.common.biz.bi.tm.model;

import java.util.List;

import com.gsitm.ustra.java.core.utils.annotation.MapField;

import kr.co.kgc.smsb.common.base.model.SmsbProcBaseModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChlTmMngProcModel extends SmsbProcBaseModel {
	
	@MapField("otOutCursor")
	private List<ChlTmMngDto> record;

}
