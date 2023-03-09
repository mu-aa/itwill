package xyz.itwill10.dto;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

/*
이름      널?       유형            
------- -------- ------------- 
NUM     NOT NULL NUMBER        	- 글번호
WRITER           VARCHAR2(20)   - 작성자
SUBJECT          VARCHAR2(100)  - 제목
ORIGIN           VARCHAR2(100)  - 원본 파일명
UPLOAD           VARCHAR2(100)  - 업로드 파일명(서버 디렉토리에 저장되는 파일명)
*/

//DTO 클래스 : 전달값을 제공받아 사용하기 위한 Command 객체의 클래스
@Data
public class FileBoard {
	private int num;
	private String writer;
	private String subject;
	private String origin;
	private String upload;
	private MultipartFile file; //전달파일을 저장하기 위한 필드
}