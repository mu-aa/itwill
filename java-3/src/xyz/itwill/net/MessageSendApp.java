package xyz.itwill.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

//UDP 프로그램 : DatagramSocket 클래스와 DatagramPacket 클래스를 이용하여 작성
//ㄴ 정보를 전달하는 컴퓨터와 정보를 얻어오는 컴퓨터로 구분하여 처리 - 서버, 클라이언트 X

//키보드로 메세지를 입력받아 다른 컴퓨터에게 전달하는 UDP 기반의 네트워크 프로그램
public class MessageSendApp {
	public static void main(String[] args) throws IOException {
		//키보드로 대량의 문자열을 입력받을 수 있도록 Sytem.in 입력스트림 확장
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
				
		System.out.print("전달 메세지 입력 >> ");
		String message=in.readLine();
		
		//DatagramSocket 클래스 : 다른 컴퓨터에 연결하기 위한 정보를 저장한 클래스
		DatagramSocket socket=new DatagramSocket();
		
		//연결될 컴퓨터의 네트워크 정보를 저장한 InetAddress 객체 생성
		InetAddress address=InetAddress.getByName("192.168.13.16");
		
		//String.getBytes() : String 객체에 저장된 문자열을 byte 배열(원시데이터 모임)로 변환하는 메소드
		byte[] data=message.getBytes(); //전달값을 원시데이터로 변환
		
		//DatagramPacket : 연결 컴퓨터에게 보낼 패킷정보를 저장하기 위한 클래스
		//DatagramPacket(byte[] buf, int length, InetAddress address, int port)
		//ㄴ buf : 전달값(원시데이터),  length : 패킷크기,  address : 연결 컴퓨터의 네트워크 정보,  port : 연결 컴퓨터의 포트
		DatagramPacket packet=new DatagramPacket(data, data.length, address, 4000); //패킷 생성
		
		//DatagramSocket.send(DatagramPacket packet) : 패킷을 전달하는 메소드
		socket.send(packet); //패킷 보내기
		socket.close();
		
		System.out.println("상대방에게 메세지를 보냈습니다.");
	}
}
