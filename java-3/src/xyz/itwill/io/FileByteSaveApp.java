package xyz.itwill.io;

import java.io.FileOutputStream;
import java.io.IOException;

//키보드 입력값을 원시데이터로 제공받아 파일에 전달하여 저장하는 프로그램
//EOF 입력 시 프로그램 종료
public class FileByteSaveApp {
	public static void main(String[] args) throws IOException {
		System.out.println("키보드를 눌러 값을 입력해 주세요 [프로그램 종료 : Ctrl+Z]");
		
		//FileOutputStream : 파일에 원시데이터를 전달하기 위한 출력 스트림을 생성하기 위한 클래스
		//FileOutputStream(Stringf filepath) : 파일경로를 전달받아 파일 출력스트림을 생성하는 생성자
		//ㄴ 전달받은 파일경로에 파일이 없는 경우 FileNotFoundException 발생 - 일반예외
		//ㄴ 전달받은 파일경로에 파일이 없는 경우 파일을 자동으로 생성하여 출력스트림 반환 - 예외처리 불필요
		//ㄴ 전달받은 파일경로에 파일이 있는 경우 기존 파일내용 대신 새로운 값이 팡리에 저장됨
		//FileOutputStream(String name, boolean append)
		//ㄴ 파일경로와 추가유무에 대한 논리값을 전달받아 파일 출력 스트림을 생성하는 생성자
		//ㄴ false : 파일 덮어씌우기(default),  true : 파일 이어쓰기
		FileOutputStream out=new FileOutputStream("c:/data/byte.txt",true);
		
		int readByte;
		
		while(true) {
			readByte=System.in.read(); //키보드 입력스트림에서 원시데이터를 반환받아 저장
			if(readByte==-1) {break;}
			out.write(readByte); //파일 출력스트림으로 원시데이터를 전달하여 저장 - Save
		}
		
		//FileOutputStream.close() : 파일 출력스트림을 제거하는 메소드
		//ㄴ 파일에는 입력스트림 또는 출력스트림을 1개씩만 생성 가능
		//ㄴ 파일 처리를 위한 입력스트림 또는 출력스트림은 사용 후 반드시 제거
		out.close(); //★다 사용한 제원에 대한 종료 선언 필수
		System.out.println("c:/data/byte.txt 파일에 키보드 입력값이 저장 되었습니다.");
	}
}
