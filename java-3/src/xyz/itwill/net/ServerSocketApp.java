package xyz.itwill.net;

import java.io.IOException;
import java.net.ServerSocket;


//ServerSocket 클래스를 사용하여 사용 가능한 포트번호를 검색하는 프로그램
public class ServerSocketApp {
	public static void main(String[] args) {
		for(int i=2000;i<=9000;i+=1000) {
			try {
				//ServerSocket : 네트워크에서 서버 프로그램을 만들기 위해 사용하는 클래스
				//ㄴ ServerSocket(int port) : 포트번호를 전달받아 ServerSocket 객체를 생성하는 생성자
				//ㄴ ServerSocket 객체를 생성하여 클라이언트가 접속할 수 있는 환경 제공  ==>  포트를 열어놨다
				//ㄴ 전달받은 포트번호를 이미 다른 네트워크 프로그램에서 사용 중인 경우 IOException 발생(일반예외)
				ServerSocket serverSocket=new ServerSocket(i);
				System.out.println("포트번호 : "+i+"은(는) 사용 가능한 포트번호 입니다.");
				
				//serverSocket.close() : serverSocket 객체 제거하는 메소드
				//ㄴ 클라이언트가 접속할 수 있는 환경 소멸
				serverSocket.close();
			} catch(IOException e) {
				System.out.println("포트번호 : "+i+"은(는) 이미 사용중인 포트번호 입니다.");
			}
		}
	}
}
