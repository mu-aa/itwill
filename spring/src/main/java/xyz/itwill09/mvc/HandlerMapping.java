package xyz.itwill09.mvc;

import java.util.HashMap;
import java.util.Map;

//클라이언트의 요구사항과 요청 처리 클래스의 객체를 Map 객체의 Entry로 저장하여 제공하는 기능의 클래스
public class HandlerMapping {
	//Map 객체를 저장하기 위한 필드
	//ㄴ Entry의 제네릭으로 맵키는 요구사항을 저장하기 위한 String 클래스로 설정하고
	//맵값은 요청 처리 클래스의 객체를 저장하기 위한 Controller 인터페이스로 설정
	private Map<String, Controller> mappings;
	
	//생성자를 이용한 필드 초기화 - Map 객체 추가하여 Entry 추가
	public HandlerMapping() {
		mappings=new HashMap<String, Controller>();
		mappings.put("/list.itwill", new ListController());
		mappings.put("/view.itwill", new ViewController());
	}
	
	//클라이언트의 요구사항에 대한 요청 처리 클래스의 객체를 반환하는 메소드
	public Controller getController(String command) {
		return mappings.get(command);
	}
}