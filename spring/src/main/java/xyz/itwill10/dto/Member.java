package xyz.itwill10.dto;

import lombok.Data;

//회원정보를 저장하기 위한 클래스 - VO 클래스 : 값을 저장할 목적의 객체를 생성하기 위한 클래스
//ㄴ DAO 클래스의 메소드에서 사용될 경우 DTO 클래스의 기능 제공
//ㄴ ★전달값을 제공받아 저장하기 위해서는 반드시 전달값의 이름과 필드의 이름이 같도록 작성
@Data
public class Member {
	private String id;
	private String passwd;
	private String name;
	private String email;
}