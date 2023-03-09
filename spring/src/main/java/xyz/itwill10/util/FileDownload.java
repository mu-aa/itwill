package xyz.itwill10.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.view.AbstractView;

//파일 다운로드 기능을 제공하기 위한 클래스 - BeanNameViewResolver 객체에 의해 실행되는 클래스
//ㄴ Spring Bean Configuration File(servlet-context.xml)에 Spring Bean으로 등록
//BeanNameViewResolver 객체에 의해 실행되는 클래스는 반드시 AbstractView 클래스를 상속받아 작성
//ㄴ renderMergedOutputModel() 메소드를 Override 선언하여 응답에 필요한 명령 작성
public class FileDownload extends AbstractView {
	//클라이언트에게 응답될 파일 형식(MimeType)을 변경 - 파일 다운로드 기능
	public FileDownload() {
		//AbstractView.setContentType(String mimeType) : 응답 파일 형식을 변경하는 메소드
		setContentType("application/download; utf-8");
	}
	
	
	//BeanNameViewResolver 객체에 의해 자동 호출되는 메소드
	//ㄴ Map 자료형의 매개변수에는 요청 처리 메소드에서 제공된 속성값이 Entry로 저장된 Map 객체 제공
	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		//요청 처리 메소드에서 제공된 속성값(파일 관련 정보)을 객체로 반환받아 저장
		String uploadDir=(String)model.get("uploadDir");
		String uploadFilename=(String)model.get("uploadFilename");
		String originalFilename=(String)model.get("originalFilename");
		
		//서버 디렉토리에 저장된 다운로드 파일에 대한 파일 객체 생성
		File downloadFile=new File(uploadDir, uploadFilename);
		
		//클라이언트에게 파일을 전달하기 위해 Response Message의 Header 변경
		response.setContentType(getContentType()); //파일 형식(download)
		response.setContentLengthLong((int)downloadFile.length()); 
		
		//다운로드 처리되어 클라이언트에 저장될 파일명을 Response Message의 Header에 저장하여 전달
		//ㄴ 파일명에 대한 한글 문제로 인해 부호화 처리하여 전달
		originalFilename=URLEncoder.encode(originalFilename, "utf-8");
		response.setHeader("Content-Disposition", "attachement;filename=\""+originalFilename+"\";");
		
		
		//Response Message의 Body에 파일을 전달하여 저장하기 위한 출력스트림을 반환받아 저장
		OutputStream out=response.getOutputStream();
		
		//서버 디렉토리에 저장된 다운로드 파일을 읽기 위한 입력스트림을 생성하여 저장
		InputStream in=new FileInputStream(downloadFile);
		
		//FileCopyUtils.copy(InputStream in, OutputStream out) : 입력스트림으로 원시데이터를 읽어
		//출력스트림으로 전달하는 메소드 - 파일 복사
		FileCopyUtils.copy(in, out);
		
		in.close();
	}
}