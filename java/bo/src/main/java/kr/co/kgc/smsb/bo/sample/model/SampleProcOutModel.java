package kr.co.kgc.smsb.bo.sample.model;

import java.util.List;

import com.gsitm.ustra.java.core.utils.annotation.MapField;
import com.gsitm.ustra.java.management.models.UstraUserModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SampleProcOutModel {
	private String pMessage;
	@MapField("pResult")
	private List<UstraUserModel> list;
}
