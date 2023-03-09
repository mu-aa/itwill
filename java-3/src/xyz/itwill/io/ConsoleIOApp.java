package xyz.itwill.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;

//키보드로 이름과 태어난 연도를 입력받아 이름과 나이를 계산하여 출력
public class ConsoleIOApp {
	public static void main(String[] args) throws IOException {
		//Java에서 기본적으로 제공되는 키보드 입력스트림을 InputStreamReader 객체의
		//입력 스트림으로 확장하여 문자데이터를 입력받을 수 있도록 설정하고 BufferedReader(보조스트림) 객체의
		//입력 스트림으로 확장하여 대량의 문자데이터를 입력받을 수 있도록 설정
		//=> 입출력 관련 보조 클래스로 //스트림의 다단계 연결//을 이용하여 스트림 확장 가능
		//=> 키보드로 문자열을 입력받기 위한 기능을 제공받기 위한 입력스트림 생성(InputStreamReader는 한글을 1글자밖에 못 받음)
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		
		//Java에서 기본적으로 제공되는 모니터 출력스트림(System.out)은
		//PrintStream 객체로 생성되어 print() 또는 println() 메소드로 값을 문자열로 변환하여 출력 가능
		System.out.print("이름 입력 >> ");
		
		//BufferedReader.readLine() : 입력스트림에서 문자열을 얻어와 반환하는 메소드
		String name=in.readLine();
		
		System.out.print("태어난 연도 입력 >> ");
		//키보드로 입력받은 문자열을 정수값으로 변환하여 저장 NumberFormatException 발생 가능
		int birthday=Integer.parseInt(in.readLine()); 
		
		int age=Calendar.getInstance().get(Calendar.YEAR)-birthday+1;
		
		System.out.println("[결과]"+name+"님의 나이는 "+age+"살 입니다.");
		
	}
}
