package xyz.itwill05.lombok;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MemberApp {
	public static void main(String[] args) {
		System.out.println("================== Spring Container 초기화 전 ==================");
		ApplicationContext context=new ClassPathXmlApplicationContext("05-5_lombok.xml");
		System.out.println("================== Spring Container 초기화 후 ==================");
		Member member=context.getBean("member",Member.class);
		//참조변수를 출력할 경우 Member.toString() 메소드를 호출하여 반환값 출력
		System.out.println("member = "+member);
		System.out.println("================================================================");
		MemberService service=context.getBean("memberServiceImpl", MemberService.class);
		
		service.addMember(member);
		service.modifyMember(member);
		service.removeMember("abc123");
		service.getMember("abc123");
		service.getMemberList();
		System.out.println("================================================================");
		((ClassPathXmlApplicationContext)context).close();			
	}
}