package xyz.itwill.dto;

//MYREPLY 테이블과 MYUSER 테이블의 검색결과를 저장하기 위한 클래스
//ㄴ 1:1 관계의 join 검색 결과를 저장하기 위한 클래스
public class MyReplyUser {
	//MYREPLY 테이블의(댓글정보) 검색결과를 저장하기 위한 필드 - 검색행 1개
	/*
	private int replyNo;
	private String replyId;
	private String replyContent;
	private String replyDate;
	private int replyCommentNo;
	*/
	//값이 아닌 객체로 필드 생성
	private MyReply reply;
	
	//MYUSER 테이블(회원정보)의 검색결과를 저장하기 위한 필드 - 검색행 1개
	/*
	private String userId;
	private String userName;
	*/
	//값이 아닌 객체로 필드 생성
	private MyUser user;
	
	public MyReplyUser() {
		// TODO Auto-generated constructor stub
	}

	public MyReply getReply() {
		return reply;
	}

	public void setReply(MyReply reply) {
		this.reply = reply;
	}

	public MyUser getUser() {
		return user;
	}

	public void setUser(MyUser user) {
		this.user = user;
	}
}