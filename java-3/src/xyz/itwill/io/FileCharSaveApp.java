package xyz.itwill.io;

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

//키보드 입력값을 문자데이터로 제공받아 파일에 전달하여 저장하는 프로그램
//EOF 입력 시 프로그램 종료
public class FileCharSaveApp {
	public static void main(String[] args) throws IOException {
		InputStreamReader in=new InputStreamReader(System.in);
		
		//FileWriter : 파일에 문자데이터를 전달하기 위한 출력스트림을 생성하기 위한 클래스
		//FileWriter(Stringf filename) : 파일경로를 전달받아 파일 출력스트림을 생성하는 생성자
		//ㄴ 전달받은 파일경로에 파일이 없는 경우 FileNotFoundException 발생 - 일반예외
		//ㄴ 전달받은 파일경로에 파일이 없는 경우 파일을 자동으로 생성하여 출력스트림 반환 - 예외처리 불필요
		//ㄴ 전달받은 파일경로에 파일이 있는 경우 기존 파일내용 대신 새로운 값이 파일에 저장됨
		
		//FileWriter(String name, boolean append)
		//ㄴ 파일경로와 추가유무에 대한 논리값을 전달받아 파일 출력 스트림을 생성하는 생성자
		//ㄴ false : 파일 덮어씌우기(default),  true : 파일 이어쓰기
		FileWriter out=new FileWriter("c:/data/char.txt", true);
		
		System.out.println("키보드를 눌러 값을 입력해 주세요 [프로그램 종료 : Ctrl+Z]");
		
		int readByte;
		while(true) {
			//키보드 입력값을 문자데이터로 얻어와 저장
			readByte=in.read();
			if(readByte==-1) {break;}
			//문자데이터를 파일 출력스트림을 이용해 전달하여 저장 - Save
			out.write(readByte);
		}
		
		out.close();
		System.out.println("c:/data/char.txt 파일에 키보드 입력값이 저장 되었습니다.");
	}
}
