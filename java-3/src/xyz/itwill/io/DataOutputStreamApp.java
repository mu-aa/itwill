package xyz.itwill.io;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

//
public class DataOutputStreamApp {
	public static void main(String[] args) throws IOException {
		//DataOutputStream : OutputStream 객체를 전달받아 원하는 자료형의 값을 원시데이터로
		//                  전달하기 위한 기능을 제공하는 출력스트림을 생성하기 위한 클래스
		DataOutputStream out=new DataOutputStream(new FileOutputStream("c:/data/data.txt"));
		
		//DataOutputStream.writeInt(int v) : 정수값을 출력스트림으로 전달하는 메소드 
		out.writeInt(100);
		//DataOutputStream.writeBoolean(boolean b) : 논리값을 출력스트림으로 전달하는 메소드 
		out.writeBoolean(true);
		//DataOutputStream.writeUTF(String s) : 문자열을 출력스트림으로 전달하는 메소드 
		out.writeUTF("홍길동");
		out.close();
		
		System.out.println("c:/data/data.txt 파일에 여러 자료형의 값들을 저장 하였습니다.");
	}
}
