package kr.co.kgc.smsb.common.base.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gsitm.ustra.java.core.utils.ApplicationContextProvider;
import com.gsitm.ustra.java.core.utils.UstraMaskingUtils.MaskingType;
import com.gsitm.ustra.java.core.utils.UstraNetUtils;
import com.gsitm.ustra.java.core.utils.annotation.MapField;
import com.gsitm.ustra.java.core.utils.annotation.Masked;
import com.gsitm.ustra.java.management.properties.UstraManagementCoreProperties;
import com.gsitm.ustra.java.security.authentication.UstraAuthenticationManager;

import io.swagger.annotations.ApiModel;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Data
@EqualsAndHashCode(callSuper=false)
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@ApiModel
public class SmsbBaseModel {

	@Getter(value=AccessLevel.PRIVATE)
	private final Object initValue = applySystemDefaultFieldValue(this);

	/**
	 * 등록 사용자 아이디
	 */
	@Masked(MaskingType.ID)
	@MapField("in_user_id")
	private String regUserId;
	
	/**
	 * 등록 사용자 아이피
	 */
	@MapField("in_ip")
	private String regUserIp;
	
	/**
	 * 등록일시
	 */
	private String regDttm;

	/**
	 * 수정 사용자 아이디
	 */
	@Masked(MaskingType.ID)
	private String modUserId;

	/**
	 * 수정 사용자 아이피
	 */
	private String modUserIp;

	/**
	 * 수정일시
	 */
	private String modDttm;


	/**
	 * 데이터 조회 카운트
	 */
	@Getter
	@Setter
	@JsonIgnore
	private Integer paginationTotalCnt;
	
	/**
	 * SP 기본 입력, 화면 ID
	 */
	@MapField("io_ui_id")
	private String ioUiId;
	
	/**
	 * SP 기본 입력, 프로세스 ID
	 */
	@MapField("io_prcd_id")
	private String ioPrcdId;

	/**
	 * 타 필드 유입 시 처리
	 */
	@Builder.Default
	private Map<String, Object> others = new HashMap<>();

	@JsonAnySetter
	public void setOthers(String key, Object value) {
		others.put(key, value);
	}

	@JsonAnyGetter
	public Map<String, Object> getOthers() {
		return others;
	}

	/**
	 * 시스템 필드를 복사한다.
	 * @param target 복사할 UstraBaseModel 객체
	 */
	public void copySystemField(SmsbBaseModel target) {
		target.setRegDttm(this.getRegDttm());
		target.setRegUserId(this.getRegUserId());
		target.setRegUserIp(this.getRegUserIp());
		target.setModDttm(this.getModDttm());
		target.setModUserId(this.getModUserId());
		target.setModUserIp(this.getModUserIp());
	}

	/**
	 * 시스템 필드를 제거한다.
	 */
	public void removeSystemField() {
		this.setRegDttm(null);
		this.setRegUserId(null);
		this.setRegUserIp(null);
		this.setModDttm(null);
		this.setModUserId(null);
		this.setModUserIp(null);
	}

	/**
	 * 모델에 시스템 필드 기본 값 설정
	 * @param model
	 */
	public static Object applySystemDefaultFieldValue(SmsbBaseModel model) {

		model.setRegDttm(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddhhmmss")));
		model.setRegUserIp(UstraNetUtils.getLocalIp());
		model.setModDttm(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddhhmmss")));
		model.setModUserIp(UstraNetUtils.getLocalIp());

		UstraAuthenticationManager manager = ApplicationContextProvider.getBeanSafety(UstraAuthenticationManager.class);

		if (manager != null && manager.getAuthentication() != null) {
			model.setRegUserId(manager.getAuthentication().getName());
			model.setModUserId(manager.getAuthentication().getName());
		}

		UstraManagementCoreProperties properties = ApplicationContextProvider.getBeanSafety(UstraManagementCoreProperties.class);

		if (properties != null) {
			if (StringUtils.isEmpty(model.getRegUserId())) {
				model.setRegUserId(properties.getDefaultUserName());
			}

			if (StringUtils.isEmpty(model.getModUserId())) {
				model.setModUserId(properties.getDefaultUserName());
			}
		}

		return null;
	}

	/**
	 * 시스템 필드 기본 값 설정
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public <T extends SmsbBaseModel> T applySystemDefaultFieldValue() {
		SmsbBaseModel.applySystemDefaultFieldValue(this);
		return (T) this;
	}
}
