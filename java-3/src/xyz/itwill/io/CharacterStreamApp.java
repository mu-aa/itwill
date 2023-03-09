package xyz.itwill.io;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

//문자데이터 기반 스트림(Character Stream) : 원시데이터를 가공처리한 문자데이터를 전달하기 위한 스트림
//ㄴ 원시데이터를 가공 처리하여 문자데이터로 변환 : 인코딩 - 문자형태(캐릭터셋- CharSet)        . . . 완성형 < 조합형
//ㄴ 값을 2Byte 단위로 입력 또는 출력하기 위한 스트림(유니코드 활용)
//ㄴ Reader 클래스와 Writer 클래스를 최상위클래스로 하는 자식클래스를 이용하여 생성

//키보드로 문자데이터를 입력받아 모니터에 전달하여 출력하는 프로그램
//ㄴ EOF(End Of File : 입력 종료 - Ctrl+Z) 신호를 입력하면 프로그램 종료
public class CharacterStreamApp {
	public static void main(String[] args) throws IOException {
		System.out.println("키보드를 눌러 값을 입력해 주세요 [프로그램 종료 : Ctrl+Z]");
		
		//InputStreamReader : InputStream 객체를 전달받아 문자데이터를 입력받기 위한 입력스트림(Reader 객체)을 생성하기 위한 클래스
		InputStreamReader in=new InputStreamReader(System.in);
		
		//OutputStreamReader : OutputStream 객체를 전달받아 문자데이터를 입력받기 위한 출력스트림(Writer 객체)을 생성하기 위한 클래스
		//OutputStreamWriter out=new OutputStreamWriter(System.out);
		
		//PrintWriter : OutStream 객체를 전달받아 문자데이터를 전달하기 위한 스트림(Writer)
		//ㄴ OutputStreamWriter 클래스보다 많은 메소드를 제공(자식클래스여서 부모클래스도 사용 가능하기 때문에)하는 클래스
		PrintWriter out=new PrintWriter(System.out);
		
		int readByte;
		
		while(true) {
			//★Reader.read() : 입력스트림에 존재하는 값을 //2Byte씩// 읽어 반환하는 메소드
			readByte=in.read();
			
			if(readByte==-1) { break; }
			
			//Writer.read() : 출력스트림에게 값(2Byte)을 전달하는 메소드
			//ㄴ 문자 데이터는 일정 크기만큼 출력 버퍼에 저장하고 한 번에 출력스트림으로 전송
			out.write(readByte);
			
			//Writer.flush() : 출력 버퍼에 저장된 문자 데이터를 출력스트림으로 모두 전달하는 메소드 => 입력받으면 바로 전달
			out.flush();
		}
		
		System.out.println("[메세지]프로그램을 종료합니다.");
		
		
		
	}
}
