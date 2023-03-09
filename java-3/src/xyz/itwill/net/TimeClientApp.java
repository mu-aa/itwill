package xyz.itwill.net;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;

//NTP Server에 접속하여 서버에서 보내온 날짜와 시간을 얻어와 출력하는 클라이언트 프로그램
public class TimeClientApp {
	public static void main(String[] args) throws ClassNotFoundException {
		try {
			//Socket : TCP 프로그램에서 다른 컴퓨터와 연결하기 위한 정보를 저장하는 클래스
			//new Socket(String host, int port) : 호스트(IP Address)와 포트를 전달하여 서버 컴퓨터에 접속한 Socket 객체를 생성하는 생성자
			//ㄴ UnknownHostException, IOException 발생(일반 예외)
			//ㄴ Socket 객체에는 연결된 컴퓨터에 정보를 보내거나 받을 수 있는 입,출력 스트림이 자동 생성되어 제공 
			Socket socket=new Socket("192.168.13.16", 2000);
			
			//Socket.getInputStream() : Socket 객체의 입력스트림(InputStream 객체)을 반환하는 메소드
			InputStream in=socket.getInputStream();
			//InputStream 객체를 전달받아 객체를 얻어올 수 있는 ObjectInputStream 객체로 입력스트림
			ObjectInputStream stream=new ObjectInputStream(in);
			//입력스트림에서 Date 객체를 얻어와 저장(형변환 필수)
			Date date=(Date)stream.readObject();
			
			System.out.println("서버에서 제공한 날짜와 시간 = "+new SimpleDateFormat("yyyy년 MM월 dd일 E요일 HH시 mm분 dd일").format(date));
			
			socket.close(); //Socket 객체 제거 메소드 - 연결 해제
		} catch (UnknownHostException e) {
			System.out.println("호스트를 찾을 수 없습니다.");
		} catch (IOException e) {
			System.out.println("Server Connect Error");
		}
		
		
	}
}
