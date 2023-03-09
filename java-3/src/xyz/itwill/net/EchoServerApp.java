package xyz.itwill.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

//클라이언트에서 보내온 메세지를 얻어와 출력하는 서버 프로그램
public class EchoServerApp {
	public static void main(String[] args) {
		ServerSocket echoServer=null;
		
		try {	
			echoServer=new ServerSocket(3000);
			System.out.println("	Echo Server Running . . . ");
			
			while(true) {
				Socket socket=echoServer.accept();
				
				//Socket 객체의 입력스트림을 반환받아 대량의 문자데이터를 읽을 수 있는 입력스트림으로 확장
				BufferedReader in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
				
				//입력스트림을 이용하여 클라이언트가 보내온 메세지를 읽어와 출력
				//ㄴ 클라이언트가 메세지를 보낼 때 까지 스레드 일시 중지
				System.out.println("["+socket.getInetAddress().getHostAddress()+"] : "+in.readLine());
				
				socket.close();
			}
		} catch(IOException e) {
			System.out.println("Server Network Error");
		}
	}
}
