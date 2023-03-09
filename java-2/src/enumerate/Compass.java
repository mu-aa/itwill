package enumerate;

public enum Compass {
	//열거형에 선언된 상수필드는 기본적으로 정수형(int)으로 설정
	//ㄴ 상수필드를 선언하면 기본생성자를 이용하여 초기화 - 0부터 1씩 증가하는 정수값 사용
	//ㄴ 매개변수가 있는 생성자를 선언하면 기본 생성자는 제공되지 않으므로 상수 선언 불가능
	//EAST, WEST, SOUTH, NORTH; 
	
	//매개변수가 선언된 생성자를 이용하여 상수필드 선언
	EAST("동"), WEST("서"), SOUTH("남"), NORTH("북");
	//상수필드의 자료형 또는 저장되는 값을 변경하기 위해서는 필드 선언
	//ㄴ private final 제한자를 이용하여 선언
	//ㄴ 필드에 저장된 값을 이용하여 상수필드값을 변경하기 위해 반드시 생성자 선언
	
	private final String value; //상수필드를 표현하기 위한 대표필드
	
	//private final 제한자로 선언된 대표필드에 초기값을 설정하기 위한 생성자
	//ㄴ 생성자를 반드시 은닉화 선언
	//ㄴ 매개변수의 전달값을 대표필드에 저장 - 상수필드 초기화
	private Compass(String value) {
		this.value=value;
	}

	//대표필드에 대한 Getter 메소드 - 상수필드에 저장된 값을 반환
	public String getValue() {
		return value;
	}
	
	
}
