package xyz.itwill10.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.multipart.MultipartFile;

import lombok.RequiredArgsConstructor;
import xyz.itwill10.dto.FileBoard;
import xyz.itwill10.service.FileBoardService;

// ~ 파일 업로드 처리를 위한 환경설정 방법 ~
//●1. commons-fileupload 라이브러리를 프로젝트에 build - maven : pom.xml
//●2. Spring Bean Configuration File(servlet-context.xml)에 파일 업로드 기능을 제공하는 클래스를
//Spring Bean으로 등록
//●3. MultipartHttpServletRequest 객체를 사용하여 [multipart/form-data] 형태로 전달된 값 또는 파일 처리

@RequiredArgsConstructor
@Controller
public class FileController {
	//WebApplicationContext 객체(Spring Container)를 제공받아 필드에 의존성 주입
	private final WebApplicationContext context;	
	private final FileBoardService fileBoardService;
	
	@RequestMapping(value = "/upload", method = RequestMethod.GET)
	public String upload() {
		return "file/upload_form";
	}
	
	/*
	//요청 처리 메소드에 MultipartHttpServletRequest 인터페이스로 매개변수를 선언하면 Front
	//Controller에 의해 MultipartHttpServletRequest 객체를 제공받아 사용 가능
	//MultipartHttpServletRequest 객체 : [multipart/form-data] 형식으로 전달된 값 또는 파일을
	//처리하기 위한 객체
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public String upload(MultipartHttpServletRequest request) throws IOException {
	//MultipartHttpServletRequest.getParameter(String name) : [multipart/form-data] 
	//형식으로 전달된 값을 문자열(String 객체)로 반환하는 메소드
	String uploaderName=request.getParameter("uploaderName");
	
	//MultipartHttpServletRequest.getFile(String name) : [multipart/form-data] 형식으로 
	//전달된 파일을 MultipartFile 객체로 반환하는 메소드
	//MultipartFile 객체 : 사용자로부터 입력되어 전달된 파일정보를 저장하기 위한 객체
	MultipartFile uploadFile=request.getFile("uploadFile");

	//전달받은 파일에 대한 검증 작업
	//MultipartFile.isEmpty() : MultipartFile 객체에 파일정보가 없는 경우 [false]를 반환하고 
	//파일정보가 있는 경우 [true]를 반환하는 메소드
	if(uploadFile.isEmpty()) {
		return "file/upload_fail";
	}
	
	//MultipartFile.getContentType() :  MultipartFile 객체에 저장된 파일의 형식(MimeType)를 반환하는 메소드 
	System.out.println("파일 형식 = "+uploadFile.getContentType());
	//MultipartFile.getBytes() : MultipartFile 객체에 저장된 파일정보를 byte 배열로 반환하는 메소드
	System.out.println("파일 크기 = "+uploadFile.getBytes().length);

	//전달파일을 저장하기 위한 서버 디렉토리의 시스템 경로를 반환받아 저장
	String uploadDirectory=request.getServletContext().getRealPath("/resources/images/upload");
	System.out.println("uploadDirectory = "+uploadDirectory);
	
	//전달파일을 서버 디렉토리에 저장하기 위한 File 객체 생성
	//File 객체 : 시스템에 존재하는 파일정보를 저장하기 위한 객체
	//MultipartFile.getOriginalFilename() : 전달파일의 파일명을 반환하는 메소드
	File file=new File(uploadDirectory, uploadFile.getOriginalFilename());
	
	//MultipartFile.transferTo(File file) : MultipartFile 객체에 저장된 파일정보를
	//File 객체에 저장된 파일정보로 전달하여 저장하는 메소드 - 업로드 처리 메소드
	uploadFile.transferTo(file);
	
	request.setAttribute("uploaderName", uploaderName);
	request.setAttribute("uploadFilename", uploadFile.getOriginalFilename());
	
	return "file/upload_ok";
}
	 */
	
	//요청 처리 메소드에 매개변수를 작성하여 전달값과 전달파일을 제공받아 사용 가능
	//ㄴ 업로드 파일과 같은 이름의 파일이 서버 디렉토리에 존재할 경우 기존 파일 대신 업로드
	//파일이 저장 - 덮어쓰기(OverWrite)
	//ㄴ commons-fileupload 라이브러리에는 업로드 파일을 변경하는 기능의 클래스 미존재
	//ㄴ 업로드 파일과 같은 이름의 파일이 서버 디렉토리에 존재할 경우 업로드 파일명을 변경하는 명령 작성 필요
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public String upload(@RequestParam String uploaderName
			, @RequestParam MultipartFile uploadFile, Model model) throws IOException {
		if(uploadFile.isEmpty()) {
			return "file/upload_fail";
		}
	
		//전달파일을 저장하기 위한 서버 디렉토리의 시스템 경로를 반환받아 저장
		//ㄴ WebApplicationContext 객체(Spring Container)에게 ServletContext 객체를 제공받아 사용
		String uploadDirectory=context.getServletContext().getRealPath("/resources/images/upload");
		
		//사용자로부터 입력되어 전달된 원본 파일명을 반환받아 저장
		String originalFilename=uploadFile.getOriginalFilename();
		
		//서버 디렉토리에 저장하기 위한 파일정보가 저장된 File 객체 생성
		File file=new File(uploadDirectory, originalFilename);
		
		//서버 디렉토리에 저장될 파일명을 저장하기 위한 변수
		// => 초기값으로 사용자로부터 입력되어 전달된 원본 파일명을 저장
		String uploadFilename=originalFilename;
		
		//업로드 파일과 같은 이름의 파일이 서버 디렉토리에 존재할 경우 서버 디렉토리에 
		//저장될 파일명을 구분하기 위한 식별자를 저장하기 위한 변수
		int i=0;
		
		//File.exists() : File 객체에 저장된 파일이 시스템이 존재하지 않을 경우 [false]를
		//반환하고 존재할 경우 [true]를 반환하는 메소드
		while(file.exists()) {//업로드 파일과 같은 이름의 파일이 서버 디렉토리에 존재할 경우 반복 처리
			i++;
			
			//파일명과 확장자를 구분하기 위한 문자열(.)를 사용하여 위치값(Index)을 반환받아 저장
			int index=originalFilename.lastIndexOf(".");

			//원본 파일명을 이용하여 업로드 파일명 생성
			uploadFilename=originalFilename.substring(0, index)+"_"+i+originalFilename.substring(index);
			
			//서버 디렉토리에 저장될 파일명을 저장하기 위한 변수
			file=new File(uploadDirectory, uploadFilename);
		}
		
		uploadFile.transferTo(file);
		
		model.addAttribute("uploaderName", uploaderName);
		model.addAttribute("originalFilename", originalFilename);
		model.addAttribute("uploadFilename", uploadFilename);
		
		return "file/upload_ok";
	}
	
	@RequestMapping(value="/fileboard/write", method=RequestMethod.GET)
	public String fileBoardWrite() {
		return "file/board_write";
	}
	
	//모든 전달값과 전달파일을 매개변수를 작성하여 Command 객체로 제공받아 사용 가능
	@RequestMapping(value="/fileboard/write", method=RequestMethod.POST)
	public String fileBoardWrite(@ModelAttribute FileBoard fileBoard) throws IllegalStateException, IOException {
		if(fileBoard.getFile().isEmpty()) {
			return "file/board_write";
		}
		
		//전달파일이 저장될 서버 디렉토리의 시스템 경로를 반환받아 저장
		//ㄴ 다운로드 프로그램에서만 파일에 접근 가능하도록 /WEB-INF 폴더에 업로드 폴더 작성
		String uploadDir=context.getServletContext().getRealPath("WEB-INF/upload");
		
		//사용자로부터 입력받아 전달된 원본파일의 이름을 반환받아 저장
		String origin=fileBoard.getFile().getOriginalFilename();
		
		//서버 디렉토리에 저장된 업로드 파일명을 생성하여 저장
		//ㄴ 업로드 파일명은 서버 디렉토리에 존재하는 파일명과 중복되지 않도록 고유값 사용
		//ㄴ 업로드 파일명은 시스템의 현재 날짜와 시간에 대한 정수값(TimeStamp)을 사용하여 작성
		String upload=System.currentTimeMillis()+"";
		
		//Command 객체(FileBoard 객체)의 필드값 변경
		fileBoard.setOrigin(origin);
		fileBoard.setUpload(upload);
		
		//파일 업로드 처리
		fileBoard.getFile().transferTo(new File(uploadDir, upload));
		
		//FILEBOARD 테이블에 행 삽입
		fileBoardService.addFileBoard(fileBoard);
		
		return "redirect:/fileboard/list";
	}
	
	@RequestMapping("/fileboard/list")
	public String fileBoardList(Model model) {
		model.addAttribute("fileBoardList", fileBoardService.getFileBoardList());
		
		return "file/board_list";
	}
	
	//다운로드 : 서버 디렉토리에 존재하는 파일을 클라이언트에 전달하여 저장하는 기능
	//요청 처리 메소드에 의해 반환되는 문자열(ViewName)로 다운로드 프로그램을 실행하여
	//서버 디렉토리에 저장된 파일을 클라이언트에게 전달하여 응답 처리
	//ㄴ BeanNameViewResolver 객체를 사용하여 반환하는 문자열로 특정 프로그램 실행
	//ㄴ Spring Bean Configuration File(servlet-context.xml)에 BeanNameViewResolver 클래스를 등록
	//현재 사용중인 ViewResolver 객체는 반환되는 문자열을 이용하여 JSP 문서로 응답되도록 처리
	//ㄴ UrlBasedViewResolver(TilesView), InternalResourceViewResolver
	@RequestMapping("/fileboard/download/{num}")
	public String fileBoardDownload(@PathVariable int num, Model model) {
		FileBoard fileBoard=fileBoardService.getFileBoard(num);
		
		//Model 객체를 이용하여 실행될 프로그램(Spring Bean)에서 사용하기 위한 객체를 속성값으로 설정
		model.addAttribute("uploadDir", context.getServletContext().getRealPath("WEB-INF/upload"));
		model.addAttribute("uploadFilename", fileBoard.getUpload());
		model.addAttribute("originalFilename", fileBoard.getOrigin());
		
		//실행될 프로그램(Spring Bean)의 식별자(BeanName)를 반환
		//ㄴ 실행될 프로그램에 대한 클래스를 작성하여 Spring Bean Configuration File
		//(servlet-context.xml)에 Spring Bean으로 등록 
		return "fileDownload";
	}
	
	@RequestMapping("/fileboard/delete/{num}")
	public String fileBoardDelete(@PathVariable int num) {
		FileBoard fileBoard=fileBoardService.getFileBoard(num);
		String uploadDir=context.getServletContext().getRealPath("WEB-INF/upload");
		
		//서버 디렉토리에 저장된 업로드 파일 삭제 처리
		new File(uploadDir, fileBoard.getUpload()).delete();
		//테이블에서 삭제
		fileBoardService.removeFileBoard(num);
		
		return "redirect:/fileboard/list";
	}
}