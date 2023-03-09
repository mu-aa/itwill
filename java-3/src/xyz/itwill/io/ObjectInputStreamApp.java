package xyz.itwill.io;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Date;
import java.util.List;

public class ObjectInputStreamApp {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws ClassNotFoundException, IOException {
		//ObjectInputStream : InputStream 객체를 전달받아 원시데이터를 원하는 자료형의 객체로
 		//                    읽기 위한 기능의 입력스트림을 생성하는 클래스(보조스트림)
		ObjectInputStream in=new ObjectInputStream(new FileInputStream("c:/data/object.txt"));
		
		//ObjectInputStream.readObject() : 입력스트림의 원시데이터를 객체로 읽어 반환받아 메소드 호출
		//ㄴ Object 객체 타입으로 변환 - 명시적 객체 형변환 후 사용 가능
		String str=(String)in.readObject();
		Date date=(Date)in.readObject();
		List<String> list=(List<String>)in.readObject();
		
		//클래스의 toString() 메소드가 자동 호출되어 객체에 저장된 값이 문자열로 반환되어 출력
		System.out.println("str = "+str);
		System.out.println("date = "+date);
		System.out.println("list = "+list);
		
		in.close();
	}
}
