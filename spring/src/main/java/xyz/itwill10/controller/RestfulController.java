package xyz.itwill10.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import xyz.itwill10.dto.Member;

//REST(Representational State Transfer) : 자원(Resource)의 표현(Representation)에 의한
//상태(State)를 전달(Transfer)하는 것
//ㄴ 페이지 요청에 대한 처리결과를 클라이언트에게 XML이나 JSON 형식의 텍스트 데이터로 응답
//Restful API : REST 기능을 사용하여 두 컴퓨터의 시스템이 안전하게 값을 주고 받기 위한 프로그램
//ㄴ 스마트 기기의 프로그램(App) 정보를 전달받아 저장하거나 검색결과를 제공하여 출력하기 위해 사용

//@RestController : 
//@RestController
@Controller
public class RestfulController {
	@RequestMapping(value="/rest", method=RequestMethod.GET)
	public String rest() {
		return "rest/input";
	}
	
	
	//RequestParam Annotation을 사용하여 하나의 전달값을 하나의 매개변수에 저장받아 사용
	/*
	@RequestMapping(value="/rest", method=RequestMethod.POST)
	public String rest(@RequestParam String id, @RequestParam String name, Model model) {
		model.addAttribute("id", id);
		model.addAttribute("name", name);
		//반환되는 문자열(ViewName)을 이용하여 ViewResolver 객체가 View로 완성하여 응답 처리
		return "rest/output";
	} */
	
	//@ResponseBody : 요청 처리 메소드의 반환값(문자열)을 ResponseMessage의 Body에 저장하여
	//클라이언트에게 직접 텍스트 데이터로 응답되도록 설정하는 Annotation
	//ㄴ 반환되는 문자열을 ViewResolver 객체로 View로 변환하여 응답하지않고 ResponseMessage의 Body에 저장하여
	//Front Controller가 직접 응답 처리
	//ㄴ Java 객체는 ResponseMessage의 Body에 저장 불가능
	//@RequestBody : RequestMessage의 Body에 저장되어 모든 전달값을 문자열로 제공받기 위한 Annotation
	//ㄴ POST, PUT, PATCH, DELETE 등의 요청방식에 의해 RequestMessage의 Body에 저장되어 전달된 모든 값은
	//문자열로 제공받아 사용 가능 - GET 방식은 RequestMessage의 Body가 비어있으므로 @RequestBody 사용 불가
	//ㄴ RequestMessage의 Body에 저장되어 전달된 JSON 형식(application/json)의 값은 매개변수에 Java 객체로
	//제공받아 사용 가능 - 전달값은 객체 필드에 저장
	@RequestMapping(value="/rest", method=RequestMethod.POST)
	@ResponseBody
	public String rest(@RequestBody String input) {
		return "input";
	}
	
	//@ResponseBody Annotation을 사용하여 요청 처리 메소드의 반환값(Member 객체)을 Response Message의 Body에
	//저장하여 회원정보를 텍스트 데이터의 회원정보를 클라이언트에게 전달하여 응답 처리
	//ㄴ jackson-databind 라이브러리에 의해 Member 객체가 JavaScript Object 객체로 변환되어 응답
	//문제점) Response Message의 Body에 Java 객체 저장 불가능 - 406 에러 발생
	//해결법) 반환되는 Java 객체를 텍스트 데이터(XML 또는 JSON 형식)의 문자열로 자동 변환되도록 설정하여 응답 처리 가능
	//ㄴ jackson-databind 라이브러리를 프로젝트에 build 처리하면 자동으로 Java 객체가 JSON 형식의 텍스트 데이터로
	//변환하여 반환 - maven : pom.xml
	@RequestMapping("/rest_member")
	@ResponseBody
	public Member restMember() {
		Member member=new Member();
		member.setId("abc123");
		member.setPasswd("123456");
		member.setName("홍길동");
		member.setEmail("abc@itwill.xyz");
		
		return member;
	}
	
	//★@ResponseBody Annotation을 사용하여 요청 처리 메소드의 반환값(List 객체)을 Response Message의 Body에
	//저장하여 텍스트 데이터의 회원목록을 클라이언트에게 전달하여 응답 처리
	//ㄴ jackson-databind 라이브러리에 의해 Member 객체가 JavaScript Array 객체로 변환되어 응답
	@RequestMapping("/rest_list")
	@ResponseBody
	public List<Member> restMemberList() {
		List<Member> memberList=new ArrayList<Member>();
		
		Member member1=new Member();
		member1.setId("abc123");
		member1.setPasswd("123456");
		member1.setName("홍길동");
		member1.setEmail("abc@itwill.xyz");
		memberList.add(member1);
		
		Member member2=new Member();
		member2.setId("xyz789");
		member2.setPasswd("789456");
		member2.setName("임꺽정");
		member2.setEmail("xyz@itwill.xyz");
		memberList.add(member2);
		
		//jackson-databind 라이브러리에 의해 List 객체가 JavaScript Array 객체로 변환되어 응답
		return memberList;
	}
	
	//
	@RequestMapping("/rest_map")
	@ResponseBody
	public Map<String, Object> restMap() {
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("id", "abc123");
		map.put("passwd", "123456");
		map.put("name", "홍길동");
		map.put("email" ,"abc@itwill.xyz");
		
		//jackson-databind 라이브러리에 의해 List 객체가 JavaScript Array 객체로 변환되어 응답
		return map;
	}
	
	@RequestMapping(value="/rest/map", method=RequestMethod.GET)
	public String restInput() {
		return "rest/input";
	}
	
	//모든 전달값이 Map 객체의 엔트리에 저장되어 매개변수로 제공받아 사용 가능
	//ㄴ 모든 전달값을 Map 객체로 제공받기 위해 반드시 @RequestParam Annotation 사용
	@RequestMapping(value="/rest/map", method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> restOutput(@RequestParam Map<String, Object> map) {
		return map;
	}
}