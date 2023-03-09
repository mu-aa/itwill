package basic;

/*

자료형(DataType) : 값이나 대상을 표현하기 위한 키워드 또는 식별자(변수 생성을 위해 사용)

 ㄴ1. 원시형(PrimitiveType) : 값을 표현하기 위한 자료형 - 키워드
   ㄴ 숫자형(정수형, 실수형, 문자형) - 연산 가능, 논리형 - 연산 불가능
  
 ㄴ2. 참조형(ReferenceType) : 특정 대상을 표현하기 위한 자료형 - 식별자(클래스)
   ㄴ String 클래스 : 문자열을 표현하기 위한 자료형(클래스)
  
  컴퓨터에서 값을 표현하는 단위 : Bit(0,1), Byte(Character) - 영문자, 숫자 하나
  ㄴ8Bit = 1Byte
  ㄴ1024Byte = 1KByte
  ㄴ1024KByte = 1MByte
  ㄴ1024MByte = 1GByte
  ㄴ1024GByte = 1TByte
 
  Bit - Byte - Word - Field(Column) - Record(Row) -/- Table - DataBase
               단어   값(단어 이상)     
  
  
  
  이진수 변환) 50(10) -> 110010(2)
                       1  1 0 0 1 0
  1024 512 256 128 64 32 16 8 4 2 1
  
  
																		                     50을 표현
 ● 정수형(IntegerType) : 소수점x, 정수형의 리터럴은 4Byte(최대 2,147,483,647) -> 00000000 00000000 00000000 00110010
 																	     				    -50을 표현
 00110010(50), 11001110(-50) -> 음수화 = 0과 1을 뒤집고 +1         		          11111111 11111111 11111111 11001110
 
 표현 가능한 갯수 : 2^(n) ~ -2^(n)-1 n=비트수
				    ㄴ ex) 1Byte = -2^7 ~ 2^7 -1 개 (8bit인데 7승인 이유는 음수까지 하면 2배가 되니까)
  										  ㄴ0을 포함하기 때문에 -1
*/
public class DataTypeApp {
	public static void main(String[] args) {
		
		System.out.println("\n<< 정수형(IntegerType) >>");
		System.out.println("정수값 100(10진수) = " + 100); // 10진수 정수값을 표현한 리터럴
//			       println 메소드는 무조건 10진수로 출력
		System.out.println("정수값 100(8진수) = " + 0100); // 8진수(0숫자) 정수값을 표현한 리터럴
		System.out.println("정수값 100(16진수) = " + 0x100); //16진수(0x숫자) 정수값을 표현한 리터럴
		System.out.println("정수값 100(Long타입) = " + 100L); //8Byte로(숫자L) 표현되는 정수값을 표현한 리터럴 -> Long타입
		
//      정수값 표현하는 자료형
		byte a1=127; // (1Byte)  -128 ~ 127
		short a2=32767; // (2Byte)  -32,768 ~ 32,767
		int a3=2147483647; // (4Byte)  -2,147,483,648 ~ 2,147,483,647
		long a4=9223372036854775807L; // (8Byte)   ...
		
		System.out.println("a1 = " + a1);
		System.out.println("a2 = " + a2);
		System.out.println("a3 = " + a3);
		System.out.println("a4 = " + a4);
		
//		int a5 = 100L;   데이터 손실이 발생될 수 있어서 에러
		long a5 = 100; //가능, 하지만 비효율적
		System.out.println("a5 = " + a5);
		System.out.println("\n================================\n");
		
		
		
//		● 실수형(DoubleType) 리터럴 : 소수점o
//		ㄴ Java의 실수형 리터럴은 기본적으로 8Byte(Double)로 표현
		
		System.out.println("<< 실수형(DoubleType) >>");
		System.out.println("실수값(4Byte) = " + 12.3F); // 4Byte(실숫값F) Float형의 실수값
		System.out.println("실수값(8Byte) = " + 12.3); // 8Byte Double형의 실수값
//		println 메소드는 아주 작은 실수값 또는 아주 커다란 실수값을 지수형태로 변환해 출력
		System.out.println("실수값(8Byte)" + 0.000000000123);
//		실수값을 지수형태로 표현하여 사용 가능
		System.out.println("실수값(8Byte)" + 1.23E-10);
		
//		실수값을 표현하기 위한 자료형
//		실수값은 부동소수점 방식으로 표현하기 때문에 범위가 매우 큼
		float b1 = 1.23456789F; // 4Byte, 정밀도 7자리(이하는 올림)
		double b2 = 1.23456789; // 8Byte, 정밀도 15자리
		
		System.out.println("b1 = " + b1);
		System.out.println("b2 = " + b2);
		System.out.println("\n================================\n");
			
		
//		● 문자형(CharacterType) 리터럴 : '' 안에 하나의 문자를 표현		
//		ㄴ Java의 문자형 리터럴은 기본적으로 2Byte로 표현
//		ㄴ Java의 문자형 리터럴은 내부적으로 약속된 정수값(0 ~ 65535)으로 표현(UniCode) = 숫자형이라고 하는 이유
//		ㄴ 일반 문자와 회피 문자로 구분
//		ㄴ 회피 문자(Escape Character) : 표현 불가능한 문자를 표현한 문자. \를 사용해 표기(\t, \0, \\, \" 등)

		System.out.println("<< 문자형(CharacterType) >>");
		System.out.println("문자형(2Byte) = " + 'A');
		System.out.println("문자형(2Byte) = " + '가');
		System.out.println("문자형(2Byte) = " + '\'');
		System.out.println("문자형(2Byte) = " + '\\');
		System.out.println("문자형(2Byte) = " + '\0');
		
//		문자값 표현 - char(2Byte)
		char c1 = 'A'; // 저장은 정해진 정수 값으로, 출력은 약속된 문자로.
		char c2 = 65;
		char c3 = 'a' - 32; // 위 원리로 인해 문자값에 대한 연산도 가능
		
		System.out.println("c1 = " + c1);
		System.out.println("c2 = " + c2);
		System.out.println("c3 = " + c3);
		
		char c4 = 45000;
		System.out.println("c4 = " + c4);
		System.out.println("\n================================\n");
		
		
		
//		● 논리형(BooleanType) 리터럴 : false(0), true(1)
//		ㄴ Java의 논리형 리터럴은 기본적으로 1Byte(Boolean)로 표현
		System.out.println("<< 논리형(BooleanType) >>");
		System.out.println("논리형(1Byte) = " + false);
		System.out.println("논리형(1Byte) = " + true);
//		관계 연산자(비교 연산자)를 이용한 연산식의 결과값으로 논리형 리터럴 제공
		System.out.println("논리형(1Byte) = " + (20<10));
		System.out.println("논리형(1Byte) = " + (20>10));
		
//		논리값을 표현하기 위한 자료형 boolean(1Byte)
		boolean d1 = false;
		boolean d2 = true;
		
		System.out.println("d1 = " + d1);
		System.out.println("d2 = " + d2);
		System.out.println("\n================================\n");
		
		
		
//		● 문자열(StringType) 리터럴 : " " 안에 0개 이상의 문자들로 표현
//		ㄴ 문자열은 **원시형(기본형)이 아닌 참조형**으로 String 클래스로 작동
		System.out.println("<< 문자열(StringType) >>");
		System.out.println("문자열 = " + "홍길동");
		System.out.println("유관순 열사가 \"대한독립 만세\"를 외쳤습니다.");
		
		String name = "임꺽정";
		System.out.println("이름 = " + name);

	}

}