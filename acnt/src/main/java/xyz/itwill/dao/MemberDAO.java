package xyz.itwill.dao;
//
import java.util.List;
import xyz.itwill.dto.Member;
//
public interface MemberDAO {
	int insertMember(Member member);
	int updateMember(Member member);
	int zeroMember(String userid);//탈퇴관련
	int deleteMember(String userid);
	Member selectMember(String userid);
	List<Member> selectMemberList();
}