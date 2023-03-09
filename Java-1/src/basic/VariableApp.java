/* 
 
 Literal : 프로그램에서 사용하기 위해 표현되는 값
 변수(Variable) : 리터럴을 저장하기 위해 메모리(주기억장치)에 부여된 이름

 변수 선언
   형식) 자료형 변수명;
   ㄴ 자료형(DataType) : 변수에 저장될 값에 대한 데이터 타입
   ㄴㄴ 자료형 형태 : 원시형(기본형, PrimitiveType) or 참조형(ReferenceType)

 식별자 작성 규칙
  ㄴ 영문자, 숫자, 특수문자(_ 또는 $)만 사용 가능
  ㄴ 숫자로 시작 불가능, 영문자는 대 소문자 구분
  ㄴ 기존에 사용된 단어(키워드, 식별자)는 사용 불가능
  
 ★Java 식별자 표기법
  ㄴ 파스칼 표기법(PascalCase) : 조합된 단어의 첫 문자를 대문자로 표현(클래스명, 인터페이스명 등)  ex)HelloWorld
  ㄴ ＊카멜 표기법(CamelCase) : 첫번째 단어를 제외한 나머지 단어의 첫문자를 대문자로 표현(변수명, 메소드명 등)  ex)helloWorld
  ㄴ 스네이크 표기법(SnakeCase) : 조합된 단어를 _로 구분(상수, Java에서 상수는 대문자로 작성)  ex)HELLO_WORLD
 
*/

package basic;

public class VariableApp {
	public static void main(String[] args) {
		
		int su;
		su = 100;
		
		System.out.print("초기값 = ");
		System.out.println(su);
		
		su = 200;
		
		System.out.print("변경값 = ");
		System.out.println(su);
		
		System.out.println("============================");
		
		int num = 100;
//						    string  + int
		System.out.println("num = " + num);
		System.out.println("============================");
		
//							문자열   +      정수     +   문자열		
		System.out.println("올해는 " + 2 + 0 + 2 + 2 + "년입니다.");
		System.out.println("============================");
		
//						    정수 + 정수  +          문자열
		System.out.println(2 + 0 + 2 + 2 +"년은 호랑이띠의 해입니다."); // 서순에 의해 정수끼리 합쳐짐
		System.out.println("" + 2 + 0 + 2 + 2 + "년은 호랑이띠의 해입니다."); // NullString("") 을 넣어서 해결
		System.out.println("============================");
		
		int num1 = 100, num2 = 200;
		
		System.out.println("연산결과 = " + num1 + num2); // 문자열 서순
		System.out.println("연산결과 = " + (num1 + num2)); // 묶어서 해결
		System.out.println("연산결과 = " + num1 * num2); // 우선연산자(*)부터 실행		
		System.out.println("============================");
		
		int kor = 88, eng = 90, tot = kor + eng;
		
		System.out.println("점수 합계 = " + tot);
		System.out.println("============================");
		
		//int a;  변수 초기화 안하면 사용 불가
		//int a = 10.0;   변수 자료형 오류
		
	}

}
