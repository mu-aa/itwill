package xyz.itwill10.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.RequiredArgsConstructor;
import xyz.itwill10.dto.Student;
import xyz.itwill10.service.StudentService;

//SpringMvc Framework를 사용하여 웹프로그램을 작성하는 방법
//ㄴ 테이블 -> DTO Class -> DAO Class(Mybatis) -> Service Class -> Controller Class
// -> 단위 프로그램(모듈) 테스트  -> HTML 문서를 JSP로 변환 -> 브라우저를 이용한 통합 테스트

//Controller 클래스 : 클라이언트 요청을 처리하기 위한 기능의 객체를 생성하기 위한 클래스
//Controller 클래스는 Front Controller(DispatcherServlet 객체)의 객체로 제공받아 사용되도록
//반드시 Spring Bean으로 등록
//ㄴ Controller 클래스는 @Controller Annotation을 사용하여 Spring Bean으로 등록되도록 처리
//ㄴ @Controller Annotation을 사용하면 클라이언트 요청에 의해 호출될 요청 처리 메소드 작성
//ㄴ @Controller Annotation을 Spring Container가 처리하기 위해서는 반드시 클래스를 작성한 패키지를
//Spring Bean Configuration File(servlet-context.xml)의 component-scan Element로 검색되도록 설정

@Controller
//@RequestMapping Annotation을 클래스에 선언하면 Controller 클래스의 모든 요청 처리 메소드의
//요청 URL 주소 앞부분에 공통적으로 포함될 URL 주소 제공
@RequestMapping("/student")
@RequiredArgsConstructor
public class StudentController {
	//Controller 클래스의 요청 처리 메소드에서 사용될 Service 객체를 저장하기 위한 필드 선언
	//ㄴ @Autowired Annotation을 사용한 생성자로 필드에 Injection 처리
	private final StudentService studentService;
	
	//학생정보를 입력받기 위한 JSP 문서 관련 ViewName을 반환하는 요청 처리 메소드
	//@RequestMapping(value="/student/add", method=RequestMethod.GET)
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public String add() {
		return "student/student_add";
	}
	
	//학생정보를 전달받아 STUDENT 테이블에 삽입하고 회원목록 출력페이지를 요청할 수 있는 URL
	//주소를 클라이언트에게 전달하는 요청 처리 메소드 - Redirect
	//@RequestMapping(value="/student/add", method=RequestMethod.POST)
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String add(@ModelAttribute Student student, Model model) {
		try {
			//STUDENT 테이블에 학생정보 삽입 시 PK 제약조건에 의해 예외 발생 가능
			//ㄴ ExceptionHandler로 예외 처리(지금은 임시로 try/catch 사용)
			studentService.addStudent(student);
		} catch (Exception e) {
			model.addAttribute("message", "이미 사용중인 학번입니다.");
			return "student/student_add";
		}
		return "redirect:/student/display"; //Redirect 이동
	}
	
	//STUDENT 테이블에 저장된 모든 학생정보를 검색하여 속성값으로 저장하고 학생목록을 출력하는
	//ViewName을 반환하는 요청 처리 메소드
	//@RequestMapping("/student/display")
	@RequestMapping("/display")
	public String display(Model model) {
		model.addAttribute("studentList", studentService.getStudentList());
		return "student/student_display";
	}
}