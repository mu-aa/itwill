package xyz.itwill.dto;


/*

이름      널?       유형             
------- -------- -------------- 
NO      NOT NULL NUMBER(10)      - 글번호 : 시퀀스의 자동 증가값
NAME             VARCHAR2(40)    - 작성자 : 사용자 입력값(로그인 한 사용자 ID)
REGDATE          DATE            - 작성일자 : 시스템의 현재 날짜(시간) 
TITLE            VARCHAR2(100)   - 제목 : 사용자 입력값
CONTENT          VARCHAR2(4000)  - 내용 : 사용자 입력값

*/
public class GuestDTO {
	private int no;
	private String name;
	private String regdate;
	private String title;
	private String content;
	
	public GuestDTO() {
		// TODO Auto-generated constructor stub
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}
