package xyz.itwill.net;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

//접속된 클라이언트에게 서버 컴퓨터의 현재 날짜와 시간을 전달하는 서버 프로그램
//ㄴ NTP(Network Time Protocol) Server : 날짜와 시간을 제공하는 서버 컴퓨터
public class TimeServerApp {
	public static void main(String[] args) {
		
		ServerSocket ntpServer=null;
		
		try {
			//ServerSocket 객체 - 포트를 활성화 시켜 클라이언트가 접속할 수 있는 환경 제공
			ntpServer=new ServerSocket(2000); //2000 포트 열기
			
			System.out.println("	NTP Server Running . . .");
			
			//서버 프로그램에 다수의 클라이언트 접속 허용을 위해 무한루프
			while(true) {
				//ServerSocket.accept() : 클라이언트 접속 대기하는 메소드
				//ㄴ 클라이언트가 접속되기 전까지 스레드 일시 중지
				//ㄴ 클라이언트 접속 시 클라이언트 소켓과 연결될 서버 소켓(Socket 객체) 생성하여 반환하고 스레드 실행
				Socket socket=ntpServer.accept();
				/*
				//Socket.getOutputStream() : Socket 객체의 출력스트림(OutputStream 객체)을 반환하는 메소드
				OutputStream out=socket.getOutputStream();
				
				//OutputStream 객체를 전달받아 객체 전달이 가능한 ObjectOutputStream 객체로 출력
				ObjectOutputStream stream=new ObjectOutputStream(out);
							
				Date now=new Date(); //시스템의 현재 날짜와 시간이 저장된 Date 객체 생성
				stream.writeObject(now); //출력 스트림을 이용하여 클라이언트에게 Date 객체 전달
				*/			
				//위의 코드들 한 줄로 정리
				new ObjectOutputStream(socket.getOutputStream()).writeObject(new Date());
							
				//로그 처리 - 기록
				//Socket.getInetAddress() : 소켓으로 연결된 외부 컴퓨터의 네트워크 정보(InetAddress 객체)를 반환하는 메소드
				//Socket.getInetAddress().getHostAddress() : 소켓으로 연결된 외부 컴퓨터의 정보 중 IP Address를 반환
				System.out.println("\n> 클라이언트["+socket.getInetAddress().getHostAddress()+"]에게 날짜와 시간을 전달하였습니다.");
				
				socket.close(); //Socket 객체 제거 메소드 - 연결 해제
			}
		} catch (IOException e) {
			System.out.println("SERVER NETWORK ERROR");
		}
		
	}
}
