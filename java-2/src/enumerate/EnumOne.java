package enumerate;

//열거형(Enumerate Type) : 상수만을 선언하기 위한 Java 자료형(참조형)
//형식) public enum 열거형명 { 상수명, 상수명, ...; }
//                  ㄴ파스칼 표기법
public enum EnumOne {
	//상수 필드 선언 - public static final int 생략
	//ㄴ 열거형에 상수필드에는 0부터 1씩 증가되는 값이 기본값으로 자동 저장
//	  ㄴ0      1       2       3
	INSERT, UPDATE, DELETE, SELECT;
	
	
}
