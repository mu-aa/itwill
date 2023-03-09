package xyz.itwill.app;

import xyz.itwill.subject.JavaSubject;
import xyz.itwill.subject.OracleSubject;
//import xyz.uniwill.subject.OracleSubject;  이미 import 처리된 자료형과 같은 이름의 자료형은 import 불가능
// import : 다른 패키지의 클래스를 현재 클래스에서 명확하게 표현하기 위해 사용하는 키워드
// 형식) import 패키지명.자료형;   -->   package 명령 하단에 작성
// 이클립스에서는 다른 패키지의 자료형을 자동 완성할 경우(Ctrl Space) 자동 import 처리
//import 정리 단축키 : Ctrl Shift O   -->  불필요한 자료형의 import를 제거하거나, 필요한 자료형의 import 설정을 추가

//패키지(package) : 같은 목적의 자료형(참조형)을 명확히 구분하여 그룹화 하기 위해 사용
//ㄴ Java 자료형(참조형) : 클래스(Class), 인터페이스(Interface), 열거형(Enum)
//ㄴ Java 자료형을 보다 쉽게 관리하기 위해 패키지를 이용
//ㄴ 패키지의 이름은 도메인을 역방향으로 나열하고 그룹명을 지정하여 작성하는 것을 권장(ex. itwill.xyz -> xyz.itwill.그룹명)
//ㄴ 도메인(Domain) : 인터넷에서 개인 또는 그룹이 사용하기 위한 네트워크 식별자(www.naver.com 中 도메인 : naver.com)

//패키지에 작성된 소스파일은 첫번째 줄에 반드시 패키지 설정
//형식) package 패키지명;
//ㄴ 소스파일에 작성된 Java 자료형(참조형)이 어떤 패키지에 선언되어 있는지 명확하게 표현

public class SubjectApp {
	public static void main(String[] args) {
		//같은 패키지의 클래스는 패키지 표현없이 클래스만 사용하여 접근 가능
		//다른 패키지의 클래스는 패키지 표현을 해야만 클래스 접근 가능 - 패키지명.클래스명
		//xyz.itwill.subject.OracleSubject subject1=new xyz.itwill.subject.OracleSubject();
		
		//다른 패키지의 클래스를 import 처리한 경우 패키지 표현 없이 클래스만 사용하여 접근 가능
		OracleSubject subject=new OracleSubject();
		subject.display();
		
		//같은 이름의 클래스가 존재할 경우 패키지를 확인(Ctrl Space)하여 클래스를 사용
		JavaSubject subjectIT=new JavaSubject();
		subjectIT.display();
		
		//같은 이름의 클래스가 이미 존재할 경우 import가 불가해서 전부 적어야 함
		xyz.uniwill.subject.JavaSubject subjectUni=new xyz.uniwill.subject.JavaSubject();
		subjectUni.display();
	}
}
