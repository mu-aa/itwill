package xyz.itwill.dbcp;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

//Properties 파일 : 프로그램 실행에 필요한 값을 제공하기 위한 텍스트 파일 - 확장자 : ~.properties
//ㄴ 프로그램을 변경하지 않고 Properties 파일을 변경하여 프로그램의 실행 결과 변경 가능
//ㄴ 프로그램의 유지보수 효율성 증가
//ㄴ Properties 파일로 제공되는 값은 문자열만 가능
//ㄴ Properties 파일에서는 영문자, 숫자, 일부 특수문자를 제외한 나머지 문자는 유니코드로 변환되어 처리

//user.properties 파일에 저장된 값을 얻어와 출력하는 프로그램
public class PropertiesApp {
	public static void main(String[] args) throws IOException {
		//Properties 파일을 읽기 위한 파일 입력스트림 생성
		//ㄴ Properties 파일의 경로를 제공받아 FileInputStream 클래스로 객체 생성
		//FileInputStream in=new FileInputStream("src/xyz/itwill/dbcp/user.properties");
		//ㄴ 프로그램 배포 시 파일 경로 문제 발생 가능
		
		//클래스명.class : Class 파일을 이용해 Class 객체(Clazz)를 표현하는 방법
		//Class.getClassLoader() : 클래스를 읽어 메모리에 저장하는 ClassLoader 객체를 반환하는 메소드
		//ClassLoader.getResourceAsStream(String name) : 리소스 파일에 대한 입력스트림을 생성하여 반환하는 메소드
		InputStream in=PropertiesApp.class.getClassLoader().getResourceAsStream("xyz/itwill/dbcp/user.properties");
		//ㄴ 프로그램 배포 시 파일 경로 문제X
		
		//Java.util 패키지의 Properties 클래스로 객체 생성
		//ㄴ Properties 객체 : Properties 파일의 내용을 전달받아 저장하기 위한 객체
		//ㄴ Map 인터페이스를 상속받은 자료구조 클래스 - 다수의 엔트리(Entry - Key와 Value) 저장
		Properties properties=new Properties();
		
		//Properties.load(InputStream in) : 입력스트림을 사용하여 Properties 파일의
		//모든 이름(name)과 값(value)을 제공받아 Properties 객체의 엔트리로 저장하는 메소드
		properties.load(in);
		
		//Properties.get(String key) : Properties 객체에 저장된 엔트리에서 맵 키(MapKey)를
		//전달받아 맵 값(MapValue)을 반환하는 메소드
		//ㄴ Object 객체를 반환하므로 명시적 객체 형변환 후 사용 가능
		String id=(String)properties.get("id");
		String password=(String)properties.get("password");
		String name=(String)properties.get("name");
		
		System.out.println("아이디 = "+id);
		System.out.println("비밀번호 = "+password);
		System.out.println("이름 = "+name);
	}
}
