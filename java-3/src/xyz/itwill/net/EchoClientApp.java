package xyz.itwill.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

//키보드로 메세지를 입력받아 접속 서버에 전달하는 클라이언트 프로그램
public class EchoClientApp {
	public static void main(String[] args) throws IOException {
		//키보드로 대량의 문자열을 입력받을 수 있도록 Sytem.in 입력스트림 확장
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("전달 메세지 입력 >> ");
		String message=in.readLine();
		
		try {
			Socket socket=new Socket("192.168.13.16", 3000); //Socket 객체 생성 - 서버 접속
			/*
			//socket의 출력스트림을 반환받아 대량의 문자데이터를 전달할 수 있는 BufferedWriter로 확장
			BufferedWriter out=new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			
			out.write(message); //출력스트림을 이용하여 서버에 문자열(메세지) 전달
			//ㄴ 출력스트림으로 바로 보내지 않고 출력 버퍼에 대기(일정크기가 되어야 출력스트림으로 전달)
			out.flush(); //출력 버퍼에 존재하는 문자데이터를 출력스트림으로 전달
			*/
			
			PrintWriter out=new PrintWriter(socket.getOutputStream());
			//PrinterWriter.println(Object o) : 모든 형식의 값을 문자열로 처리하여 출력스트림으로 전달
			out.println(message);
			out.flush();
			
			socket.close();
		} catch (UnknownHostException e) {
			System.out.println("Unknown Host");
		} catch (IOException e) {
			System.out.println("Server Network Error");
		}
	}
}
