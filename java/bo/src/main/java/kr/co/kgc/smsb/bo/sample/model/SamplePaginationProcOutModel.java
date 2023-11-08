package kr.co.kgc.smsb.bo.sample.model;

import java.math.BigDecimal;
import java.util.List;

import com.gsitm.ustra.java.core.utils.annotation.MapField;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SamplePaginationProcOutModel {
	private String pMessage;
	private BigDecimal pTotal;
	@MapField("pResult")
	private List<SampleDto> list;
}
