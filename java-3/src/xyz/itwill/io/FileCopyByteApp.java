package xyz.itwill.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

//원본파일에 저장된 값을 원시데이터로 읽어와 타겟파일에 전달하여 저장하는 프로그램 - 복사
//ㄴ 모든 형식의 파일을 복사하여 타겟파일로 저장 가능
public class FileCopyByteApp {
	public static void main(String[] args) throws IOException {
		//BufferedInputStream : InputStream 객체를 전달받아 대량의 원시데이터를 읽기 위한
//							    입력 스트림을 생성하기 위한 보조스트림 클래스
		//BufferedOutputStream : OutputStream 객체를 전달받아 대량의 원시데이터를 전달하기 위한
//		                         출력 스트림을 생성하기 위한 보조스트림 클래스
		//보조스트림 클래스 : 스트림을 전달받아 기능을 확장하기 위한 클래스
		//ㄴ Buffered(Input Output)Stream, Data(Input Output)Stream 등
		BufferedInputStream in=null;		
		BufferedOutputStream out=null;
		
		try {
			in=new BufferedInputStream(new FileInputStream("c:/data/obj.zip")); //스트림의 다단계 연결
			out=new BufferedOutputStream(new FileOutputStream("c:/data/obj_byte.zip"));
			int readByte;
			
			while(true) {
				readByte=in.read();//값
				if(readByte==-1) {break;}//모든 값을 불러올 때 까지
				out.write(readByte);
			}
			
			System.out.println("파일이 복사되었습니다.");
		} catch (FileNotFoundException e) {
			System.out.println("원본 파일을 찾을 수 없습니다.");
		} finally {
			in.close();
			out.close();
		}
	}
}
