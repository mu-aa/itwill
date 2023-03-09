package xyz.itwill.io;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

//파일에 저장된 회원정보를 읽어 출력하는 프로그램
public class MemberLoadApp {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		ObjectInputStream in=new ObjectInputStream(new FileInputStream("c:/data/member.txt"));
		
		System.out.println("<<회원 목록>>");
		
		while(true) {
			try {
				//ObjectInputStream.readObject() : 메소드 호출 시 파일 커서가 EOF 위치에 있을 경우 EOFException 발생
				Member member=(Member)in.readObject();
				System.out.println(member); //toString() 메소드 자동 호출
			} catch(EOFException e) {
				break;
				}
		}
		
		in.close();
		
	}
}
