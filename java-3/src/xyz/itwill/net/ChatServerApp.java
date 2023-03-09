package xyz.itwill.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

//채팅 서버 프로그램 - 다중 스레드 프로그램 : 클라이언트에서 보내온 메세지를 전달받아 접속된 모든 클라이언트에게 전달하는 기능 제공
//ㄴ 클라이언트와 연결된 서버 소켓은 새로운 스레드를 생성하여 독립적으로 입,출력 명령을 처리
public class ChatServerApp {
	//접속된 모든 클라이언트의 소켓정보를 저장하기 위한 콜렉션 필드
	private List<SocketThread> clientList=null;
	
	public ChatServerApp() {
		ServerSocket chatServer=null;
		
		try {
			chatServer=new ServerSocket(5000);
			System.out.println("Chatting Server Running . . . ");
			
			clientList=new ArrayList<SocketThread>();
			
			while(true) {
				try {
					//클라이언트가 접속하면 클라이언트와 연결된 Socket 객체를 반환받아 저장
					Socket client=chatServer.accept();
					
					System.out.println("[로그]"+client.getInetAddress().getHostAddress()+" 접속");
					
					//Thread 클래스를 상속받은 자식클래스로 객체 생성 - Thread 객체 생성
					SocketThread socketThread=new SocketThread(client);
					
					//콜렉션 필드에 저장된 List 객체에 요소(SocketThread 객체)를 추가하여 저장
					clientList.add(socketThread);
					
					//Thread 객체로 새로운 스레드를 생성하여 run() 메소드 명령 실행
					socketThread.start(); 
					
				} catch(IOException e) {
					System.out.println("Client Connect Error");
				}
			}
		} catch(IOException e) {
			System.out.println("Server Error");
		}
	}

	//클라이언트와 연결된 소켓을 이용하여 입출력 기능을 제공하기 위한 클래스
	//ㄴ 독립적인 입,출력 기능을 제공하기 위해 새로운 스레드를 생성 
	public class SocketThread extends Thread{
		//클라이언트의 소켓과 연결된 서버 Socket 객체를 저장하기 위한 필드
		private Socket socket;
		
		//클라이언트의 메세지를 보내기,읽기 위한 입,출력 스트림을 저장하기 위한 필드
		private BufferedReader in;
		private PrintWriter out;
		
		public SocketThread(Socket socket) { //생성자
			this.socket=socket;
		}
		
		//새로운 스레드가 실행할 명령 작성
		//ㄴ 클라이언트의 메세지를 전달받아 모든 접속 클라이언트에게 전달하는 명령 실행
		@Override
		public void run() {
			String aliasName=""; //클라이언트의 대화명을 저장하기 위한 변수
			
			try {
				//클라이언트와 연결된 소켓의 입력스트림을 반환받아
				//대량의 문자데이터를 읽을 수 있는 입력스트림으로 확장
				in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
				
				//클라이언트와 연결된 소켓의 출력스트림을 반환받아
				//모든 형식의 값을 문자열로 전달할 수 있는 출력스트림으로 확장
				//PrintWriter(OutputStream out, boolean autoFlush) : 오토플러시 여부
				out=new PrintWriter(socket.getOutputStream(), true);
				
				//클라이언트가 설정한 대화명을 변수에 저장
				//ㄴ 클라이언트가 대화명을 설정할 때 까지 스레드 일시 중지
				aliasName=in.readLine();
				
				//현재 접속된 모든 클라이언트에게 입장 메세지 전달
				sendMessage("["+aliasName+"]님이 입장했습니다.");
				
				//클라이언트에서 보내온 메세지를 전달받아 현재 접속된 모든 클라이언트에게 전달
				//ㄴ 클라이언트가 접속을 종료하기 전까지 반복 처리
				//ㄴ 클라이언트가 접속을 종료하면 클라이언트와 연결된 소켓의 입,출력스트림이 제거되어 IOException 발생
				while(true) {
					sendMessage("["+aliasName+"]"+in.readLine());
				}
			} catch(IOException e) {
				//클라이언트가 접속을 종료한 경우 실행될 명령 작성
				//ㄴ 콜렉션 필드에 저장된 List 객체에서 접속 종료된 클라이언트의 소켓정보(SocketThread)를 삭제
				//ㄴ 현재 접속중인 모든 클라이언트에게 퇴장 메세지 전달
				clientList.remove(this); //this 키워드로 현재 사용중인 SocketThread 객체 표현
				sendMessage("["+aliasName+"]님이 퇴장했습니다.");
				System.out.println(socket.getInetAddress().getHostAddress()+"의 컴퓨터가 접속을 종료했습니다.");
			}
		}
	}
	
	//현재 서버에 접속된 모든 클라이언트에게 메세지를 전달하는 메소드
	public void sendMessage(String message) {
		//List 객체에 저장된 요소(SocketThread 객체)를 하나씩 제공받아 반복 처리
		for(SocketThread temp:clientList) {
			//SocketThread 객체의 출력스트림을 이용하여 클라이언트에게 메세지 전달
			temp.out.println(message); //println==printWriter로 사용
		}
	}
	
	public static void main(String[] args) {
		new ChatServerApp();
	}
	
}
