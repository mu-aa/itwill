package xyz.itwill.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class DayCalculateAnother {
	
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
		Date birthday=null;
		
		System.out.print("생년월일 입력[ex.2000-01-01] >> ");
		try {
			//키보드로 입력받은 문자열을 Date 객체로 변화하여 저장
			// => 키보드로 입력받은 문자열이 SimpleDateFormat 객체에 저장된 패턴정보와 맞지 않을
			//경우 ParseException 발생 - 일반 예외이므로 반드시 예외처리해야 에러 미발생
			birthday=dateFormat.parse(scanner.nextLine());
		} catch (ParseException e) {
			System.out.println("[에러]생년월일을 형식에 맞게 입력해 주세요.");
			System.exit(0);
		} finally {
			scanner.close();
		}
		
		//살아온 날짜를 계산하여 출력
		long day=(System.currentTimeMillis()-birthday.getTime())/(1000*60*60*24);
		
		System.out.println("[결과]태어난지 "+day+"일이 지났습니다.");
	}
	
}
