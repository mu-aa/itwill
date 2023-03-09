package xyz.itwill.io;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class FileCharLoadApp {
	public static void main(String[] args) throws IOException {
		FileReader in=null;
		
		try {
			//FileReader : 파일에 저장된 값을 문자데이터로(2Byte) 읽기 위한 입력스트림을 생성하기 위한 클래스
			//FileReader(String name) : 파일경로를 전달받아 파일 입력스트림을 생성하는 생성자
			//ㄴ 파일경로에 파일이 없는 경우 FileNotFoundException 발생 - 반드시 예외처리
			in=new FileReader("c:/data/char.txt");
			
			//문자데이터(2byte)를 전달하기 위한 모니터 출력스트림으로 확장하여 생성(System.out은 원시데이터(1byte)만 읽음)
			OutputStreamWriter out=new OutputStreamWriter(System.out);
			
			System.out.println("[메세지]c:/data/char.txt에 저장된 내용\n");
			int readByte;
			
			while(true) {
				//파일 입력스트림을 이용하여 파일값을 문자데이터로 반환받아 저장 - Load
				readByte=in.read();
				//파일의 마지막에는 무조건 EOF 존재 == 파일의 모든 값을 얻어온 경우 반복문 종료
				if(readByte==-1) {break;}
				//모니터 출력스트림에 문자데이터를 전달하여 출력
				out.write(readByte);
				out.flush();
			}
		} catch (FileNotFoundException e) {
			System.out.println("c:/data/char.txt 파일이 없습니다");
			e.printStackTrace();
		} finally {
			if(in!=null) in.close();
		}
	}
}
