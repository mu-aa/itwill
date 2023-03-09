package xyz.itwill.service;

import java.sql.SQLException;
import java.util.List;

import xyz.itwill.dao.UserinfoModelTwoDAO;
import xyz.itwill.dto.UserinfoDTO;
import xyz.itwill.exception.AuthFailException;
import xyz.itwill.exception.ExistsUserinfoException;
import xyz.itwill.exception.UserinfoNotFoundException;

//Service 클래스 : Model 클래스의 요청 처리 메소드에서 DB 관련 처리 기능을 제공하기
//위한 클래스 - 단위 프로그램(모듈 프로그램) : 컴퍼넌트(Component)
//ㄴ 다수의 DAO 클래스의 메소드를 호출하여 필요한 기능을 제공하기 위한 메소드 작성 - 모듈화
//ㄴ DB 관련 기능 구현 시 발생되는 모든 문제에 대한 인위적 예외 발생
public class UserinfoService {
	private static UserinfoService _service;
	
	private UserinfoService() {
		// TODO Auto-generated constructor stub
	}
	
	static {
		_service=new UserinfoService();
	}
	
	public static UserinfoService getService() {
		return _service;
	}
	
	//회원정보를 전달받아 USERINFO 테이블에 삽입하는 메소드
	//ㄴ 전달받은 회원정보의 아이디가 USERINFO 테이블에 저장된 기존 회원정보의 아이디와
	//중복될 경우 인위적 예외 발생
	public void addUserinfo(UserinfoDTO userinfo) throws SQLException, ExistsUserinfoException {
		if(UserinfoModelTwoDAO.getDAO().selectUserinfo(userinfo.getUserid())!=null) {
			throw new ExistsUserinfoException("이미 사용중인 아이디입니다."); //인위적 예외 발생
		}
		
		UserinfoModelTwoDAO.getDAO().insertUserinfo(userinfo);
	}
	
	//회원정보를 전달받아 USERINFO 테이블에 저장된 회원정보를 변경하는 메소드
	//ㄴ 전달받은 회원정보가 USERINFO 테이블에 없는 경우 인위적 예외 발생
	public void modifyUserinfo(UserinfoDTO userinfo) throws SQLException, UserinfoNotFoundException {
		if(UserinfoModelTwoDAO.getDAO().selectUserinfo(userinfo.getUserid())==null) {
			throw new UserinfoNotFoundException("회원정보가 존재하지 않습니다.");
		}
		
		UserinfoModelTwoDAO.getDAO().updateUserinfo(userinfo);
	}
	
	//아이디를 전달받아 USERINFO 테이블에 저장된 해당 아이디의 회원정보를 삭제하는 메소드
	//ㄴ 전달받은 아이디의 회원정보가 USERINFO 테이블에 없는 경우 인위적 예외 발생
	public void removeUserinfo(String userid) throws SQLException, UserinfoNotFoundException {
		if(UserinfoModelTwoDAO.getDAO().selectUserinfo(userid)==null) {
			throw new UserinfoNotFoundException("회원정보가 존재하지 않습니다.");
		}
		
		UserinfoModelTwoDAO.getDAO().deleteUserinfo(userid);
	}
	
	
	//아이디를 전달받아 USERINFO 테이블에 저장된 해당 아이디의 회원정보를 검색하는 메소드
	//ㄴ 전달받은 아이디의 회원정보가 USERINFO 테이블에 없는 경우 인위적 예외 발생
	public UserinfoDTO getUserinfo(String userid) throws SQLException, UserinfoNotFoundException {
		if(UserinfoModelTwoDAO.getDAO().selectUserinfo(userid)==null) {
			throw new UserinfoNotFoundException("회원정보가 존재하지 않습니다.");
		}
		
		return UserinfoModelTwoDAO.getDAO().selectUserinfo(userid);
	}
	
	//USERINFO 테이블에 저장된 모든 회원정보를 검색하여 반환하는 메소드
	public List<UserinfoDTO> getUserinfoList() throws SQLException {
		return UserinfoModelTwoDAO.getDAO().selectUserinfoList();
	}
	
	//아이디와 비밀번호를 전달받아 인증 처리하는 메소드
	//ㄴ 인증 실패 시 인위적 예외 발생 - 예외가 발생되지 않은 경우 인증 성공
	public void auth(String userid, String password) throws SQLException, AuthFailException {
		UserinfoDTO userinfo=UserinfoModelTwoDAO.getDAO().selectUserinfo(userid);
		if(userinfo==null) { //아이디 인증 실패
			throw new AuthFailException("입력된 아이디가 존재하지 않습니다.");
		}
		
		if(!userinfo.getPassword().equals(password)) { //비밀번호 인증 실패
			throw new AuthFailException("입력된 아이디 또는 비밀번호가 일치하지 않습니다.");
		}
	}
}