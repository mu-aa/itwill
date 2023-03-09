package basic;


//자료형 변환(TypeCast) : 값의 자료형을 일시적으로 변환하여 사용하는 방법
// ㄴ 자동 형 변환(JVM), 강제 형 변환(사람)
//                  ㄴ가상 플랫폼(Virtual Machine) <--> 리얼 플랫폼(OS)


public class TypeCastApp {

	public static void main(String[] args) {
		
//		● 자동 형 변환 : 자료형이 다른 값을 연산하기 위해 JVM에 의해 자동으로 변환
//		표현 범위 크기 순) byte - short - char - int - long - float - double
		
		System.out.println("결과 = " + (3+1.5)); // 표현 범위가 더 큰 자료형으로 변환됨. int -> double
//													ㄴ int 보다 작은 자료형은 무조건 int로 자동 형 변환
		
		double su = 10; // 10 -> 10.0
		System.out.println("su = " + su);
		
//		int num = 10.0;  표현 범위가 더 작은 자료형으로 변환이 안돼서(데이터 손실이 나서) 에러
		
		System.out.println("결과 = "+(99/10)); // 정수 나누기 정수 = 정수(소수점 버림)
		System.out.println("결과 = "+(99./10)); // 99. 도 99.0으로 인식
		
		int kor = 95, eng = 90;
		int tot = kor + eng;
//		double ave = tot / 2;   정수 나누기 정수로 처리 돼 소수점 버려짐(나누기 할 때 주의)
		double ave = tot / 2.;
		
		System.out.println("총점 = " + tot);
		System.out.println("평균 = " + ave);
		
		byte su1 = 10, su2 = 20;
//		byte su3 = su1 + su2;  -> byte + byte = int    int 보다 작은 자료형은 무조건 int로 자동 형 변환
		int su3 = su1 + su2;
		
		System.out.println("su3 = " + su3);
		System.out.println("\n======================================\n");
		
		
		
		
//		● 강제 형 변환 : Cast 연산자를 사용하여 원하는 자료형의 값으로 일시적으로 변경하여 명령을 작성하는 방법
//		ㄴ 형식 : (자료형)값
		
		int num = (int)12.3; // int 12.3 = 12   // 응용 : 소수점 버리기
		System.out.println("num = " + num);
		
		int num1 = 95, num2 = 10;
//		double num3 = num1 / num2;  정수 나누기 정수로 소수점 버려진 결과가 double형으로 저장.
		double num3 = (double)num1 / num2;
		System.out.println("num3 = " + num3);
		
		int num4 = 100_000_000, num5 = 30; // 큰 수는 언더바(_)로 구분
//		int num6 = num4 * num5;  자료형의 표현 범위를 초과해서 쓰레기 값 출력
		long num6 = num4 * (long)num5; // ㄴ int->long 형 변환으로 해결
		System.out.println("num6 = " + num6);
		
		double number = 1.23456789;
		System.out.println("number = " + number);
		
//		소수점 2자리 위치까지만 출력
		System.out.println("number(내림) = " + (int)(number * 100) / 100.0);
		System.out.println("number(반올림) = " + (int)(number * 100 + 0.5) / 100.0);
		System.out.println("number(올림) = " + (int)(number * 100 + 0.9) / 100.0);
		System.out.println("\n======================================\n");
		
	}

}
