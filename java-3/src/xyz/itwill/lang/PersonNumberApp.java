package xyz.itwill.lang;

import java.util.Scanner;

//키보드로 주민번호를 입력받아 생년월일과 성별을 출력
//ㄴ 주민번호는 14자리이며 7번째 자리에 반드시 - 문자가 존재
//ㄴ 비정상적인 주민번호가 입력된 경우 에러 메세지 출력 후 재입력
//ex) 주민번호 입력 [ex.901225-1234567] >> 990718-1234567
//    [결과]생년월일 = 1999년 07월 18일, 성별 = 남자
public class PersonNumberApp {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		String num;
		
		//입력값 검증
		while(true) {
		System.out.print("주민번호 입력 [ex.901225-1234567] >> ");
		num=scanner.nextLine().replace(" ","");
		
		if(num.length()==14 && num.indexOf("-")==6) break;
		
		System.out.println("올바른 값을 입력하세요");
		}
		scanner.close();
		
		// 8번째 자리 문자 분리
		String sepration=num.substring(7, 8);
		String birthday="";
		
		//생년월일
		if(sepration.equals("1") || sepration.equals("2")) {
			birthday="19";
		} else if(sepration.equals("3") || sepration.equals("4")) {
			birthday="20";
		}
		birthday+=num.substring(0,2)+"년 ";
		birthday+=num.substring(2,4)+"월 ";
		birthday+=num.substring(4,6)+"일";
		System.out.print("생년월일 = "+birthday);
		
		//성별
		if(sepration.equals("1") || sepration.equals("3")) {
			System.out.println(", 성별 = 남자");
		} else if(sepration.equals("2") || sepration.equals("4")) {
			System.out.println(", 성별 = 여자");
		}
		
	}//main
}//class
