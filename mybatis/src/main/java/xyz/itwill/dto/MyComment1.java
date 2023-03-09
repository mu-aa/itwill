package xyz.itwill.dto;

//MYCOMMENT 테이블 : 게시글을 저장하기 위한 테이블
//MYCOMMENT_SEQ : MYCOMMENT 테이블의 COMMENT_NO 컬럼에 저장될 자동 증가값을 제공하기 위한 시퀀스

/*
이름              널?       유형            
--------------- -------- ------------- 
COMMENT_NO      NOT NULL NUMBER       	- 게시글 번호
COMMENT_ID               VARCHAR2(50) 	- 게시글 작성자(아이디)
COMMENT_CONTENT          VARCHAR2(100) 	- 게시글 내용
COMMENT_DATE             DATE     		- 게시글 작성일
*/

//테이블의 컬럼명과 같은 이름의 필드를 선언하여 클래스 작성 - 자동 mapping
//XML 기반의 Mapper 파일에서 cache Element를 사용한 경우 SELECT 명령에 대한 검색결과로 제공될
//객체의 클래스는 반드시 객체 직렬화 클래스 선언
//ㄴ 객체 직렬화 클래스는 Serializable 인터페이스를 상속받아 작성
//ㄴ 객체 직렬화 클래스는 serialVersionUID (static final)필드 선언
public class MyComment1 {
	private int commentNo;
	private String commentId;
	private String commentContent;
	private String commentDate;
	
	public MyComment1() {
		// TODO Auto-generated constructor stub
	}

	public int getCommentNo() {
		return commentNo;
	}

	public void setCommentNo(int commentNo) {
		this.commentNo = commentNo;
	}

	public String getCommentId() {
		return commentId;
	}

	public void setCommentId(String commentId) {
		this.commentId = commentId;
	}

	public String getCommentContent() {
		return commentContent;
	}

	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}

	public String getCommentDate() {
		return commentDate;
	}

	public void setCommentDate(String commentDate) {
		this.commentDate = commentDate;
	}
}