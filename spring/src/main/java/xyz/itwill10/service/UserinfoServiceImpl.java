package xyz.itwill10.service;

import java.util.List;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import xyz.itwill10.dao.UserinfoDAO;
import xyz.itwill10.dto.Userinfo;
import xyz.itwill10.exception.ExistsUserinfoException;
import xyz.itwill10.exception.LoginAuthFailException;
import xyz.itwill10.exception.UserinfoNotFoundException;

//~ 암호화 처리 기능을 사용하기 위한 방법 ~
//●1. jdcrypt 라이브러리를 프로젝트에 build - maven : pom.xml
//●2. BCrypt.hashpw(String password, String salt) 메소드를 호출하여 비밀번호의 암호화 처리
//ㄴ 매개변수로 비밀번호와 salt를 전달받아 암호하 처리 - salt에 의해 비밀번호가 다르게 변환
//ㄴ BCrypt 클래스 : BlowFish 알고리즘 기반으로 설계된 단방향 암호화 기능을 제공하는 클래스
//ㄴ BCrypt.gensalt(int log_bounds) : salt의 길이(default:10)를 전달받아 salt를 생성하여 반환하는 메소드
//●3. BCrypt.checkpw(String plaintext, String hashed)로 암호화된 비밀번호를 비교하여 결과를 반환받아 처리
//ㄴ 매개변수로 일반 문자열과 암호화된 문자열을 전달받아 비교하여 같은 경우 [true], 다른 경우 [false] 반환

//Service 클래스의 메소드는 데이터 처리 시 발생되는 문제에 대한 인위적 예외 발생
//ㄴ 발생된 예외는 Controller 클래스에서 예외 처리되도록 전달
@Service
@RequiredArgsConstructor
public class UserinfoServiceImpl implements UserinfoService {
	private final UserinfoDAO userinfoDAO;

	@Transactional
	@Override
	public void addUserinfo(Userinfo userinfo) throws ExistsUserinfoException {
		//전달받은 회원정보의 아이디가 기존 회원정보의 아이디와 중복된 경우
		if(userinfoDAO.selectUserinfo(userinfo.getUserid())!=null) {
			//사용자 정의 예외 클래스로 인위적 예외 발생
			//ㄴ 예외를 명확하게 구분하여 예외 처리 시 필요값을 저장하여 전달
			throw new ExistsUserinfoException("이미 사용중인 아이디입니다.", userinfo);
		}
		
		//전달받은 회원정보의 비밀번호를 암호화 처리하여 필드값 저장
		//ㄴ 전달받은 회원정보의 비밀번호를 암호화 처리하여 필드값으로 변경하는 명령은
		//Controller 클래스의 요청 처리 메소드에서 작성 가능
		String hashedPassword=BCrypt.hashpw(userinfo.getPassword(), BCrypt.gensalt());
		userinfo.setPassword(hashedPassword);
		
		userinfoDAO.insertUserinfo(userinfo);
	}

	@Transactional
	@Override
	public void modifyUserinfo(Userinfo userinfo) throws UserinfoNotFoundException {
		//전달받은 회원정보의 아이디로 기존 회원정보를 검색하여 검색결과가 없는 경우
		if(userinfoDAO.selectUserinfo(userinfo.getUserid())==null) {
			throw new UserinfoNotFoundException("아이디의 회원정보가 존재하지 않습니다.");
		}
		
		//전달받은 회원정보의 비밀번호가 존재할 경우 - 비밀번호 변경
		if(userinfo.getPassword()!=null && userinfo.getPassword().equals("")) {
			String hashedPassword=BCrypt.hashpw(userinfo.getPassword(), BCrypt.gensalt());
			userinfo.setPassword(hashedPassword);
		}
		
		userinfoDAO.updateUserinfo(userinfo);
	}

	@Transactional
	@Override
	public void removeUserinfo(String userid) throws UserinfoNotFoundException {
		//전달받은 회원정보의 아이디로 기존 회원정보를 검색하여 검색결과가 없는 경우
		if(userinfoDAO.selectUserinfo(userid)==null) {
			throw new UserinfoNotFoundException("아이디의 회원정보가 존재하지 않습니다.");
		}
		
		userinfoDAO.deleteUserinfo(userid);
	}

	@Override
	public Userinfo getUserinfo(String userid) throws UserinfoNotFoundException {
		//전달받은 아이디로 기존 회원정보를 검색하여 검색결과를 반환받아 저장
		Userinfo userinfo=userinfoDAO.selectUserinfo(userid);
		//검색된 회원정보가 없는 경우
		if(userinfo==null) {
			throw new UserinfoNotFoundException("아이디의 회원정보가 존재하지 않습니다.");
		}	
		return userinfo;
	}
	
	@Override
	public List<Userinfo> getUserinfoList() {
		return userinfoDAO.selectUserinfoList();
	}
	
	//회원정보를 전달받아 인증 처리하기 위한 메소드 - 예외가 발생된 경우 인증 실패
	//ㄴ 예외가 발생되지 않은 경우 인증 성공으로 검색된 회원정보를 반환
	@Override
	public Userinfo loginAuth(Userinfo userinfo) throws LoginAuthFailException {
		//전달받은 회원정보의 아이디로 기존 회원정보를 검색하여 검색결과를 반환받아 저장
		Userinfo authUserinfo=userinfoDAO.selectUserinfo(userinfo.getUserid());
		
		//검색된 회원정보가 없는 경우 - 아이디 인증 실패
		if(authUserinfo==null) {
			throw new LoginAuthFailException("아이디의 회원정보가 존재하지 않습니다.", userinfo.getUserid());
		}
		
		//전달받은 비밀번호와 검색된 회원정보의 비밀번호를 비교하여 같지 않은 경우 - 비밀번호 인증 실패
		if(!BCrypt.checkpw(userinfo.getPassword(), authUserinfo.getPassword())) {
			throw new LoginAuthFailException("아이디가 없거나 비밀번호가 일치하지 않습니다.", userinfo.getUserid());
		}
		
		return authUserinfo;
	}
}