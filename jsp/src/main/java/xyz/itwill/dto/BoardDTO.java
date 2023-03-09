package xyz.itwill.dto;

/*
 이름        널?       유형             
--------- -------- -------------- 
NUM       NOT NULL NUMBER(4)      	- 글 번호
ID                 VARCHAR2(20)   	- 작성자(아이디)
SUBJECT            VARCHAR2(500)  	- 제목
REG_DATE           DATE           	- 작성날짜
READCOUNT          NUMBER(4)      	- 조회수
REF                NUMBER(4)      	- 게시글 그룹번호		   	  ┐
RE_STEP            NUMBER(4)      	- 게시글 그룹 내부의 글 순서  │ 다중답변형 게시판의 필수컬럼
RE_LEVEL           NUMBER(4)      	- 게시글의 깊이(답글의 깊이)  ┘
CONTENT            VARCHAR2(4000) 	- 내용
IP                 VARCHAR2(20)   	- 작성자 IP
STATUS             NUMBER(1)      	- 상태 : 0(삭제글-삭제처리), 1(일반글), 2(비밀글)
 */

public class BoardDTO {
	private int num;
	private String id;
	private String writer; //작성자(이름) - MEMBER 테이블을 JOIN해 가져온 name 컬럼값을 저장하기 위한 필드
	private String subject;
	private String regDate;
	private int readCount;
	private int ref;
	private int reStep;
	private int reLevel;
	private String content;
	private String ip;
	private int status;
	
	public BoardDTO() {
		// TODO Auto-generated constructor stub
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	public int getReadCount() {
		return readCount;
	}

	public void setReadCount(int readCount) {
		this.readCount = readCount;
	}

	public int getRef() {
		return ref;
	}

	public void setRef(int ref) {
		this.ref = ref;
	}

	public int getReStep() {
		return reStep;
	}

	public void setReStep(int reStep) {
		this.reStep = reStep;
	}

	public int getReLevel() {
		return reLevel;
	}

	public void setReLevel(int reLevel) {
		this.reLevel = reLevel;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
}
