package xyz.itwill.io;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

//회원정보(Member 객체)를 파일에 전달하여 저장하는 프로그램
public class MemberSaveApp {
	public static void main(String[] args) throws IOException {
		ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream("c:/data/member.txt"));
		
		//ObjectOutputStream.writeObject(Object o) : 메소드 호출 시 NotSerializableException 발생
		//NotSerializableException : 객체 직렬화 처리하지 않은 클래스의 객체로 출력스트림으로 전달할 경우 발생
		//ㄴ 출력스트림으로 전달할 객체의 클래스를 객체 직렬화 처리하면 해결
		out.writeObject(new Member("muaa", "김민재", "010-9000-6092"));
		out.writeObject(new Member("abc", "홍길동", "010-1234-5678"));
		out.writeObject(new Member("xyz", "임꺽정", "010-5678-9012"));
		
		out.close();
		
		System.out.println("c:/data/object.txt 파일에 회원정보를 저장했습니다.");
	}
}
