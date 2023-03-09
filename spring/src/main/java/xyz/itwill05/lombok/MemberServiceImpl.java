package xyz.itwill05.lombok;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
//@AllArgsConstructor : 클래스에 작성된 모든 필드의 초기화를 위한 매개변수가 선언된 생성자를
//자동으로 만들어주는 어노테이션 - Lombok 라이브러리에서 제공되는 어노테이션
// => 생성자를 이용하여 모든 필드에 대한 의존성 주입
//@AllArgsConstructor

//@RequiredArgsConstructor : 클래스에 작성된 필드 중 final 키워드를 사용하여 선언된 필드의 
//초기화를 위한 매개변수가 선언된 생성자를 자동으로 만들어주는 어노테이션 - Lombok 라이브러리에서 제공되는 어노테이션
// => 생성자를 이용하여 원하는 필드에 대한 의존성 주입
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {
	//필드에 @Autowired 어노테이션을 선언하여 의존성 주입 - 필드 의존성 주입
	// => 필드에 대한 Setter 메소드가 없어도 필드에 의존성 주입 가능
	// => 가장 간단한 의존성 주입 방법이지만 순환 참조시 에러가 발생되지 않아 StackOverFlow 발생 가능
	//@Autowired
	//private MemberDAO memberDAO;
	
	//@RequiredArgsConstructor 어노테이션으로 의존성 주입을 하기 위한 필드에는 final 키워드를 사용하여 선언
	private final MemberDAO memberDAO;
	
	//필드의 Setter 메소드에 @Autowired 어노테이션을 선언하여 필드에 의존성 주입 - Setter 의존성 주입
	// => Setter 메소드의 접근지정자가 [public]인 경우 다른 클래스에서 Setter 메소드가 
	//호출되어 의존관계 변경 가능
	/*
	@Autowired
	public void setMemberDAO(MemberDAO memberDAO) {
		System.out.println("*** MemberServiceImpl 클래스의 setMemberDAO(MemberDAO memberDAO) 메소드 호출 ***");
		this.memberDAO = memberDAO;
	}
	*/
	
	/*
	public MemberServiceImpl() {
		System.out.println("### MemberServiceImpl 클래스의 기본 생성자 호출 ###");
	}
	*/

	//필드를 초기화 시키는 매개변수가 선언된 생성자에 @Autowired 어노테이션을 선언하여 
	//필드에 의존성 주입 - 생성자 의존성 주입
	// => Spring Framework에서는 순환 참조 반지를 위해 생성자 의존성 주입 권장
	// => 생성자를 이용하여 의존성 주입할 때 생성자가 하나만 선언된 경우 @Autowired 생략 가능
	//@Autowired
	/*
	public MemberServiceImpl(MemberDAO memberDAO) {
		super();
		this.memberDAO = memberDAO;
		System.out.println("### MemberServiceImpl 클래스의 매개변수가 선언된 생성자 호출 ###");
	}
	*/

	@Override
	public void addMember(Member member) {
		System.out.println("*** MemberServiceImpl 클래스의 addMember(Member member) 메소드 호출 ***");
		memberDAO.insertMember(member);
	}

	@Override
	public void modifyMember(Member member) {
		System.out.println("*** MemberServiceImpl 클래스의 modifyMember(Member member) 메소드 호출 ***");
		memberDAO.updateMember(member);
	}

	@Override
	public void removeMember(String id) {
		System.out.println("*** MemberServiceImpl 클래스의 removeMember(String id) 메소드 호출 ***");
		memberDAO.deleteMember(id);
	}

	@Override
	public Member getMember(String id) {
		System.out.println("*** MemberServiceImpl 클래스의 getMember(String id) 메소드 호출 ***");
		return memberDAO.selectMember(id);
	}

	@Override
	public List<Member> getMemberList() {
		System.out.println("*** MemberServiceImpl 클래스의 getMemberList() 메소드 호출 ***");
		return memberDAO.selectMemberList();
	}
}