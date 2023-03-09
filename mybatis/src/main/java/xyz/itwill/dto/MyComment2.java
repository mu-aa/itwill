package xyz.itwill.dto;

//테이블의 컬럼명과 다른 이름의 필드를 선언하여 클래스 작성 - 수동 mapping
public class MyComment2 {
	private int no;
	private String id;
	private String content;
	private String date;
	
	public MyComment2() {
		// TODO Auto-generated constructor stub
	}
	
	public MyComment2(int no, String id) {
		super();
		this.no = no;
		this.id = id;
	}

	public MyComment2(int no, String id, String content, String date) {
		super();
		this.no = no;
		this.id = id;
		this.content = content;
		this.date = date;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
}