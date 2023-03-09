package xyz.itwill.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

//키보드로 생년월일을 입력받아 오늘까지 살아온 날짜(일)를 계산
//ㄴ 생년월일 입력[ex.2000-01-01] >> 2022-10-05
//ㄴ [결과]태어난지 1일이 지났습니다.
//ㄴ 형식에 맞지 않는 생년월일을 입력한 경우 에러메세지 출력 후 프로그램 종료 ->try catch  parceException 예외처리
//   SimpleDateFormat, Scanner, Date 사용
public class DayCalculateApp {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		
		//입력받기
		System.out.print("생년월일 입력[ex.2000-01-01] >> ");
		String input=scanner.nextLine();
		
		//날짜 패턴정보 저장
		SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
		
		try {
			//날짜 패턴정보를 바탕으로 String을 Date로 변환
			Date wantDate=dateFormat.parse(input);
			
			//오늘 날짜 입력받기
			long nowTime=System.currentTimeMillis();
			
			//Date로 변환한 input long타입 정수형인 타임스탬프 형식으로 변환(연산을 위해)
			long wantTime=wantDate.getTime();
			
			//출력
			System.out.println("[결과]태어난지 "+((nowTime-wantTime)/1000)/86400+"일이 지났습니다.");
			
		} catch (ParseException e) {
			System.out.println("[에러]형식에 맞지 않는 날짜와 시간입니다.");
		}
		
		scanner.close();
		
	}//main
}//class
