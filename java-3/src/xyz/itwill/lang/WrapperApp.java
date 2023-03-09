package xyz.itwill.lang;

//Wrapper 클래스 : 원시 데이터 타입의 자료형(Primitive Type)을 클래스로 표현한 자료형
//ㄴ Byte, Short, Integer, Long, Float, Double, Character, Boolean
public class WrapperApp {
	public static void main(String[] args) {
		/*
		 * int num1=100, num2=200, num3=num1+num2;
		 * 
		 * System.out.println("합계 = "+num3);
		 */

		
		/*
		Integer num1=new Integer(100);    정수값을 저장하고 정수값 관련 기능을 메소드로 제공하기 위한 클래스
		Integer num2=Integer.valueOf(100);    Integer.valueOf() : 정수값을 전달받아 정수값이 저장된 Integer 객체를 생성하여 반환하는 메소드
		Integer num3=num1.intValue()+num2.intValue();   Integer.intValue() : Integer 객체에 저장된 정수값을 정수형(int) 값으로 반환하는 메소드
		
		System.out.println(num3.intValue());
		*/
		
		
		//★Wrapper 클래스는 오토박싱, 오토언박싱 기능으로 객체 생성 및 사용 가능
		//ㄴ 오토박싱(Auto Boxing) : 원시데이터 타입의 값을 자동으로 Wrapper 클래스의 객체로 변환하는 기능
		//ㄴ 오토언박싱(Auto Unboxing) : Wrapper 클래스의 객체를 자동으로 원시데이터 타입의 값으로 변환하는 기능
		Integer num1=100, num2=200; // 정수값(100,200)이 Integer 객체로 변환되어 참조변수에 저장 -> 오토박싱
		Integer	num3=num1+num2; // 연산 시 Integer 객체에 저장된 정보가 정수값(100,200)으로 변환되어 연산 처리 -> 오토언박싱
		System.out.println(num3);
		System.out.println("\n================================================\n");
		
		
		//Integer.valueOf(String s, int radix)
		//ㄴ 매개변수에 전달된 값으로 원하는 진수의 문자열을 정수값으로 변환하여 반환하는 메소드
		Integer num=Integer.valueOf("ABC", 16); // "ABC"를 16진수로   == int num=0XABC;
		System.out.println(num);
		System.out.println("\n================================================\n");
		
		
		Integer su=50;
		System.out.println("su(10진수)"+su);
		//Integer.toBinaryString(int i) : 매개변수에 저장된 정수값을 2진수 형식의 문자열로 변환하여 반환
		System.out.println("su(2진수)"+Integer.toBinaryString(su));
		//Integer.toOctalString(int i) : 매개변수에 저장된 정수값을 8진수 형식의 문자열로 변환하여 반환
		System.out.println("su(8진수)"+Integer.toOctalString(su));
		//Integer.toHexString(int i) : 매개변수에 저장된 정수값을 16진수 형식의 문자열로 변환하여 반환
		System.out.println("su(16진수)"+Integer.toHexString(su));
		System.out.println("\n================================================\n");
		
		
		String str1="100", str2="200";
		System.out.println(str1+str2);
		//★Integer.parse자료형(String str) : 문자열을 매개변수로 전달받아 해당하는 자료형 값으로 변환하여 반환
		//ㄴ 실행 시 매개변수로 전달받은 문자열이 정수값으로 변환되지 못할 경우 NumberFormatException 발생 
		System.out.println(Integer.parseInt(str1)+Integer.parseInt(str2));
		System.out.println("\n================================================\n");
	}
}
