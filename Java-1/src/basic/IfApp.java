package basic;
/*

 제어문(Control Statement) : 프로그램의 흐름을 바꾸어 주는 구문
 ㄴ 선택문(if, switch), 반복문(for, while), 기타(break, continue, return)
 
 ●if : 조건식에 의해 명령을 선택 실행
 ㄴ 형식 : if(조건식) {명령; ...} else {명령; ...}
   ㄴ 조건식의 결과가 참(true)인 경우 블럭 안의 명령들을 실행
   ㄴ 거짓(false)일 경우 else 블럭 안의 명령들을 실행
   ㄴ else if 조건식이 여러 개인 경우 명령을 구분하여 실행
    
*/
public class IfApp {
	public static void main(String[] args) {
		
		int su=90; //변수값이 50 이상인 경우에만 화면에 출력
		
		if(su>=50) {
			System.out.println("su = "+su);
		}
		System.out.println("\n===========================\n");
		
		
		int score=90; //변수값이 60 이상인 경우 합격, 아닐 경우 불합격 메세지 출력
		
		if(score>=60) {
			System.out.println("합격");
		} else {
			System.out.println("불합격");
		}
		System.out.println("\n===========================\n");
		
		
		int num=9; //변수값을 홀수 또는 짝수로 구분하여 출력
		
		if(num%2==0) {
			System.out.println(num+" >> 짝수");
		} else {
			System.out.println(num+" >> 홀수");
		}
		System.out.println("\n===========================\n");
		
		
		char mun ='O'; //변수에 저장된 문자값을 영문자와 비영문자로 구분하여 출력
		
		if(mun>='A' && mun<='Z' || mun>='a' && mun<='z') {
			System.out.println("영문자 "+mun);
		} else {
			System.out.println("비영문자 "+mun);
		}
		System.out.println("\n===========================\n");
		
		
		boolean sw=false; //조건식 대신 boolean 변수값을 이용하여 명령 선택 실행 가능
						  //부정 소거법이 효과적임
		if(!sw) {	
			System.out.println(sw+":거짓");
		} else {
			System.out.println(sw+":참");
		}
		System.out.println("\n===========================\n");
		
		
		int myScore=85;	//변수값이 0~100 범위인지 아닌지 구분하여 출력
		
		if(myScore>=0 && myScore<=100) {
//			변수값으로 등급을 구분하여 출력
//			100~90:A, 89~80:B, 79~70:C, 69~60:D, 59~0:F
			
			String grade="";
			
			if(myScore>=90) {
				grade="A";
			} else if(myScore>=80) {
				grade="B";
			} else if(myScore>=70) {
				grade="C";
			} else if(myScore>=60) {
				grade="D";
			} else {
				grade="F";
			}
			System.out.println("내 점수 : "+myScore);
			System.out.println("내 등급 : "+grade);
			
		} else {
			System.out.println("ERROR");
		}
		System.out.println("\n===========================\n");
	}
}
