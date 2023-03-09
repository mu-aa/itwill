package xyz.itwill05.lombok;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class MemberDAOImpl implements MemberDAO {
	public MemberDAOImpl() {
		System.out.println("### MemberDAOImpl 클래스의 기본 생성자 호출 ###");
	}

	@Override
	public int insertMember(Member member) {
		System.out.println("*** MemberDAOImpl 클래스 insertStudent(Member member) 메소드 호출 ***");
		return 0;
	}

	@Override
	public int updateMember(Member member) {
		System.out.println("*** MemberDAOImpl 클래스 updateMember(Member member) 메소드 호출 ***");
		return 0;
	}

	@Override
	public int deleteMember(String id) {
		System.out.println("*** MemberDAOImpl 클래스 deleteMember(String id) 메소드 호출 ***");
		return 0;
	}

	@Override
	public Member selectMember(String id) {
		System.out.println("*** MemberDAOImpl 클래스 selectMember(String id) 메소드 호출 ***");
		return null;
	}

	@Override
	public List<Member> selectMemberList() {
		System.out.println("*** MemberDAOImpl 클래스 selectMemberList() 메소드 호출 ***");
		return null;
	}
}