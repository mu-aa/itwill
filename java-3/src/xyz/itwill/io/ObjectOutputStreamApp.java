package xyz.itwill.io;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.Date;

//
public class ObjectOutputStreamApp {
	public static void main(String[] args) throws IOException {
		//ObjectOutputStream : OutputStream 객체를 전달받아 원하는 자료형의 객체를 원시데이터로
 		//                    전달하기 위한 기능의 출력스트림을 생성하는 클래스(보조스트림)
		ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream("c:/data/object.txt"));
		
		//ObjectOutputStream.writeObject(Object o) : 출력스트림으로 객체를 전달하기 위한 메소드
		out.writeObject("홍길동");
		out.writeObject(new Date());
		out.writeObject(Arrays.asList("임꺽정","전우치","일지매"));
		
		out.close();
		
		System.out.println("c:/data/object.txt 파일에 여러 개의 객체가 저장되었습니다.");
		
	}
}