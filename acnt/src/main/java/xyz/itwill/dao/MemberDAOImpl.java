package xyz.itwill.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;
import xyz.itwill.dto.Member;
import xyz.itwill.mapper.MemberMapper;

@Repository
@RequiredArgsConstructor
public class MemberDAOImpl implements MemberDAO {
	private final SqlSession sqlSession;
	
	@Override
	public int insertMember(Member member) {
		return sqlSession.getMapper(MemberMapper.class).insertMember(member);
	}

	@Override
	public int updateMember(Member member) {
		return sqlSession.getMapper(MemberMapper.class).updateMember(member);
	}
	
	@Override//탈퇴관련
	public int zeroMember(String userid) {
		return sqlSession.getMapper(MemberMapper.class).zeroMember(userid);
	}
	
	@Override
	public int deleteMember(String userid) {
		return sqlSession.getMapper(MemberMapper.class).deleteMember(userid);
	}

	@Override
	public Member selectMember(String userid) {
		return sqlSession.getMapper(MemberMapper.class).selectMember(userid);
	}

	@Override
	public List<Member> selectMemberList() {
		return sqlSession.getMapper(MemberMapper.class).selectMemberList();
	}
}
