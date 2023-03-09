package xyz.itwill.net;

import java.net.InetAddress;
import java.net.UnknownHostException;

//네트워크(Network) : 두 대 이상의 컴퓨터에서 값을 송수신하기 위한 기능
//인터넷(Internet) : 네트워크 기능을 제공하기 위한 가상의 공간 - 네트워크 관련 약속
//프로토콜(Protocol) : 인터넷을 사용하기 위한 통신 관련 규약
//프로토콜 구조 : 네트워크 계층> 인터넷 계층(IP)> 전송 계층(TCP, UDP)> 응용 계층(FTP HTTP SMTP 등)
//네트워크 계층 - 네트워크 관련 장치 : 이더넷(Ethernet) 카드, 라우터(Router), 스위치허브(Switch Hub) 등
//ㄴ 이더넷(Ethernet) : 호스트에서 네트워크를 사용하기 위한 통신 장비
//ㄴ 라우터(Router) : 네트워크 그룹과 네트워크 그룹을 연결하기 위한 통신 장비
//ㄴ 스위치허브(Switch Hub) :  호스트와 호스트 및 호스트와 네트워크 그룹을 연결하기 위한 통신 장비

//IP(Internet Protocol) : 인터넷을 사용하기 위한 네트워크 주소(IP 주소)에 대한 통신 규약
//TCP(Transmission Control Protocol) : 연결형 프로토콜(연결설정 필요)로 신뢰할 수 있는
//									   데이터 전송에 대한 통신 규약 - 전송 제어 프로토콜 >> 소켓통신(1:1 연결)
//UDP(User Datagram Protocol) : 비연결형 프로토콜(연결설정 불필요)로 신뢰할 수 없는
//							    데이터 전송에 대한 통신 규약 - 사용자 데이터그램 프로토콜 >> 고속통신(1:N 연결)

//응용 계층 : 전송계층을 기반으로 생성된 다수의 프로토콜 또는 응용 프로그램

//호스트(Host) : 네트워크를 사용하기 위한 컴퓨터(프로그램)

//IP Address : 인터넷을 사용하기 위해 컴퓨터에 부여하는 네트워크 식별자
//ㄴ IPv4 : 32Bit를 이용하여 IP 주소 표현 : 10진수 0~255 범위의 정수값을 4개를 [ . ]으로 구분하여 표현 
//ㄴ IPv6 : 128Bit를 이용하여 IP 주소 표현 : 16진수 0000~FFFF 범위의 정수값 8개를 [ : ]으로 구분하여 표현
//ㄴ 공인 IP 주소와 사설 IP 주소(10.0.0.0 ~ 255.255.255,   172.16.0.0 ~ 172.31.255.255,   192.168.0.0 ~ 192.168.255.255)로 구분

//NetMask 주소 : 네트워크 그룹(라우터 없이 데이터를 주고받을 수 있는 그룹 == SubNet)을 표현하기 위한 주소
//ㄴ C Class(255.255.255.0) - 256대,  B Class(255.255.0.0) - 256^2대,  A Class(255.0.0.0) - 256^3대 등
//ex) C Class) 192.168.0.1,  255.255.255.0  ==>> 192.168.0.0 ~ 192.168.0.255

//Gateway Address : 라우터에 부여된 IP 주소 - 다른 네트워크로 들어가는 입구 역할

//DNS(Domain Name System) Server : 도메인을 IP 주소로 변환해주는 기능을 제공하는 컴퓨터

//도메인(Domain) : 인터넷을 사용하기 위해 네트워크 그룹 또는 호스트에게 부여하는 문자화된 네트워크 식별자
//ㄴ 도메인 그룹에 등록되어야 호스트 사용 가능 - 도메인 호스트

//포트번호(Port Number) : 네트워크를 이용하여 데이터를 전송하기 위한 고유의 통신 경로
//ㄴ 네트워크는 반드시 0~65535 범위의 포트 중 하나를 선택하여 데이터 전송
//ㄴ 0~1023 : Well-Known Port ★(80 : HTTP,  443 : HTTPS,  25 : SMTP,  110 : POP3)★ - 시스템에서 사용하기 위해 약속 되어진 포트
//ㄴ 1024~49151 : 네트워크 프로그램(응용 프로그램) 작성 시 사용 가능한 포트
//ㄴ 49152~65535 : 일시적으로 사용하는 임시포트(Private Port)

//패킷(Package) : 네트워크에서 데이터를 전송하기 위한 단위 - Java에서는 byte 배열로 표현 가능

//방화벽(Firewall) : 네트워크를 이용한 접속 및 데이터 전송을 차단 또는 허용하는 프로그램

public class InetAddressApp {
	public static void main(String[] args) throws UnknownHostException {
		//InetAddress : 네트워크 정보(IP Address와 HostName)를 저장하기 위한 클래스 
		//InetAddress.getLocalHost() : 로컬 컴퓨터의 네트워크 정보가 저장된 InetAddress 객체를 반환하는 메소드
		//ㄴ UnknownHostException 발생(일반예외) : 네트워크 컴퓨터 이름(HostName)의 컴퓨터를 검색할 수 없는 경우 발생
		//로컬 컴퓨터의 이더넷에는 기본적으로 [127.0.0.1]의 IP Address와 [localhost]라는 HostName이 설정
		//                                     루프백 IP                 기본 이름값
		
		InetAddress myComputer=InetAddress.getLocalHost();
		
		System.out.println("myComputer = "+myComputer); //toString() 생략 가능
		//InetAddress.getHostName() : InetAddress 객체에 저장된 네트워크 정보에서 HostName을 문자열로 반환하는 메소드 
		System.out.println("myComputer = "+myComputer.getHostName());
		//InetAddress.getHostAddress() : InetAddress 객체에 저장된 네트워크 정보에서 IP Address를 문자열로 반환하는 메소드
		System.out.println("myComputer = "+myComputer.getHostAddress());
		System.out.println("=====================================================================");
		
		
		//InetAddress.getByName(String host) : 전달받은 컴퓨터 이름에 대한 네트워크 정보가 저장된 InetAddress 객체를 반환하는 메소드
		InetAddress itwill=InetAddress.getByName("www.itwill.xyz");
		System.out.println("[www.itwill.xyz]의 IP Address = "+itwill.getHostAddress());
		System.out.println("=====================================================================");
		
		
		//InetAddress.getAllByName(String host) : 전달받은 컴퓨터 이름에 대한 모든 네트워크 정보가 저장된 InetAddress 객체를 반환하는 메소드
		InetAddress[] naver=InetAddress.getAllByName("www.naver.com");

		for(InetAddress temp:naver) {
			System.out.println("[www.naver.com]의 IP Address = "+temp.getHostAddress());
		}
		System.out.println("=====================================================================");
	}
}
