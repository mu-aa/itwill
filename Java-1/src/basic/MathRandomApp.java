package basic;

// 프로그램으로부터 난수값을 제공받아 출력하는 프로그램
// ㄴ난수값 : 불규칙적으로 발생되는 숫자값

public class MathRandomApp {
	public static void main(String[] args) {
		
		//Math 클래스 : 수학 관련 기능을 제공하는 클래스
		//Math.random() : 0.0보다 크거나 작고 1.0보다 작은 실수 난수값(double형)을 반환하는 메소드(0.0 <= x < 1.0)
		for(int i=1;i<=5;i++) {			
			System.out.println(i+"번째 실수 난수값 : "+Math.random());
		}
		System.out.println("\n===========================================\n");
		
		
		for(int i=1;i<=5;i++) { 												  
			System.out.println(i+"번째 정수 난수값 : "+(int)(Math.random()*100)); //난수값 : 0<=x<100  (0~99)
		}
		System.out.println("\n===========================================\n");
		
		
		for(int i=1;i<=5;i++) {														 //괄호 중요
			System.out.println(i+"번째 정수 난수값 : "+((int)(Math.random()*45)+1)); //난수값 : 1<=x<46  (1~45)
		}													//Math.random()*X)+Y)) =  Y ~ (X-1)+Y
		System.out.println("\n===========================================\n");
	}
}