package kr.co.kgc.smsb.common.base.utils;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class DateTimeUtils {

	public enum Pattern {
		yyyyMMdd("yyyyMMdd"),
		yyyyMMddHHmmss("yyyyMMddHHmmss");

		private String PatternString;
		Pattern(String PatternString) {
			this.PatternString = PatternString;
		}

		public String get() {
			return this.PatternString;
		}
	}

	/***
	 * 기본값으로 yyyyMMddHHmmss 포멧 형식의 날짜 반환
	 * @return
	 */
	public static String NowDateTime() {
		return NowDateTime("yyyyMMddHHmmss");
	}

	/***
	 * DateTime Formatter에 맞는 날짜 형식 반환
	 * @param dtPattern ex) yyyyMMddHHmmss
	 * @return String 문자열
	 */
	public static String NowDateTime(String dtPattern) {
		DateTimeFormatter dtFormat = DateTimeFormatter.ofPattern(dtPattern);
		LocalDateTime now = LocalDateTime.now(ZoneId.of("Asia/Seoul"));
		return now.format(dtFormat);
	}
}
