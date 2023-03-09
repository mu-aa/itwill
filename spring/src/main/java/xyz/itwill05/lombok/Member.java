package xyz.itwill05.lombok;

import lombok.Data;

//클래스의 생성자나 메소드를 자동으로 만들어주는 Lombok 라이브러리를 사용하는 방법
//1. Lombok 라이브러리 프로젝트에 Build - Maven 사용 : pom.xml
//2. 이클립스를 종료하고 콘솔을 관리자 권한으로 실행한 후 Lombok 라이브러리가 저장된
//로컬 저장소(Local Repository)의 폴더(/.m2)로 이동
//3. 콘솔에서 Jar 프로그램을 실행하여 Lombok 라이브러리를 이클립스에서 사용할 수 있도록 설정
//ㄴ java -jar lombok-1.18.26.jar
//ㄴ 탐색기에서 로컬 저장소의 라이브러리 폴더로 이동하여 Jar 파일을 더블클릭하여 실행 가능
//4. Jar 프로그램을 실행하여 제공된 창에서 Lombok을 사용할 이클립스를 선택하여 Lombok 설치
//ㄴ 이클립스를 찾을 수 없는 경우 이클립스가 설치된 디렉토리를 수동으로 선택하여 설치 가능
//5. Lombok이 설치된 이클립스 폴더로 이동하여 eclipse.ini 파일변경
//ㄴ javaagent 속성의 lombok 경로를 상대경로로 변경(-javaagent:lombok.jar)
//6. 이클립스를 실행하여 Lombok 라이브러리가 제공하는 Annotation 사용
//ㄴ @Setter, @Getter, @ToString, @Data, @AllArgsConstructor, @RequiredArgsConstructor 등

//회원정보를 저장하기 위한 클래스 - VO 클래스 : 값을 저장하기 위한 목적의 객체를 생성하기 위한 클래스
//@Setter : 필드의 Setter 메소드를 자동 생성하여 제공하는 어노테이션 
//@Getter : 필드의 Getter 메소드를 자동 생성하여 제공하는 어노테이션 
//@ToString : 클래스의 필드값을 반환하는 toString 메소드를 자동 생성하여 제공하는 어노테이션 
//@Data : Setter, Getter, toString 메소드 등을 자동 생성하는 어노테이션
@Data
public class Member {
	private String id;
	private String name;
	private String email;
}