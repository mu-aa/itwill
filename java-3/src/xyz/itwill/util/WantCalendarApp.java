package xyz.itwill.util;

import java.util.Calendar;
import java.util.InputMismatchException;
import java.util.Scanner;

//키보드로 [년]과 [월]을 입력받아 해당 년월에 대한 달력을 출력하는 프로그램
//->CurrentCalendarApp 참고 (calendar.set 사용해서 년 월 변경)

public class WantCalendarApp {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		
		try {
		System.out.print("[연도 입력] >> ");
		int year=scanner.nextInt();
		
		System.out.print("[월 입력] >> ");
		int month=scanner.nextInt()-1; //월은 0~11범위 이기때문에 입력받은 값에서 -1해야 정상적으로 실행
		
		Calendar calendar=Calendar.getInstance(); // getInstance() : 기본값
		
		//Calendar 객체에 저장된 날짜와 시간 중 [년도]를 입력받은 값, year로 변경
		//Calendar 객체에 저장된 날짜와 시간 중 [월]를 입력받은 값, month로 변경
		//Calendar 객체에 저장된 날짜와 시간 중 [일]을 [1일]로 변경
		calendar.set(Calendar.YEAR, year);
		calendar.set(Calendar.MONTH, month);
		calendar.set(Calendar.DATE, 1);
		
		//Calendar 객체에 저장된 날짜와 시간 중[요일]을 반환받아 저장 - 1~7 범위의 정수값 반환(최초 1회)
		int week=calendar.get(Calendar.DAY_OF_WEEK);
		
		//										   //월은 0~11범위이기 때문에 +1해야 정상적으로 출력
		System.out.println("          "+year+"년"+(month+1)+"월");
		System.out.println("===============================");
		System.out.println("  일  월  화  수  목  금  토");
		System.out.println("===============================");
		
		//[1일]에 대한 요일(요일에 따른 상수 1~7을 이용)전까지 공백 출력
		for(int i=1;i<week;i++) {
			System.out.print("    ");
		}
		
		//1일부터 [월]의 마지막 날짜까지 출력
		for(int i=1;i<=calendar.getActualMaximum(Calendar.DATE);i++) {
			
			//1의자리, 10의자리 자릿수 맞춤
			if(i<=9) {
				System.out.print("   "+i);
				} else {
				System.out.print("  "+i);
				}
			
			week++;
			
			if(week%7==1) { // 증가된 요일이 일요일(첫번째 줄은 줄바꿈 할 필요가 없어서 1은 해당X, 두번째 줄인 8부터기에 %7==1)인 경우
				System.out.println(); // 토요일까지 출력되고 줄바꿈
				}
			}
		} catch(InputMismatchException e){
			System.out.println("[ERROR]형식에 맞는 값을 입력하세요");
		} finally {			
			scanner.close();
		}
		
	}//main
}//class
