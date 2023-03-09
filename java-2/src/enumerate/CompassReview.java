package enumerate;

public enum CompassReview {
	//값 초기화
	EAST("동"), WEST("서"), SOUTH("남"), NORTH("북"); 

	//매개변수 있는 생성자로 초기화
	private CompassReview(String value) {
		this.value=value;
	}
	
	//대표상수필드 선언
	private final String value;

	//Getter
	public String getValue() {
		return value;
	}
}
