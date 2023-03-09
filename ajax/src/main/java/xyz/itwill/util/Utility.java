package xyz.itwill.util;

public class Utility {
	//JSON 형식의 데이터를 전달받아 JSON 형식으로 사용 불가능한 문자값을
	//사용 가능한 문자값으로 변환하여 반환하는 메소드
	public static String toJSON(String source) {
		return source.replace("\\","\\\\").replace("\"","\\\"")
				.replace("\n","\\n").replace("\r\n","\\n");
	}
}
