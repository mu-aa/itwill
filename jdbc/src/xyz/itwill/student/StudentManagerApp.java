package xyz.itwill.student;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.regex.Pattern;

//학생정보 관리 프로그램
//ㄴ 메뉴 선택에 따른 학생정보 삽입, 변경, 삭제, 검색 기능(-> DAO 클래스) 제공
//ㄴ 입출력은 프로그램에서 구현하고 데이터는 DAO 클래스의 메소드를 호출하여 처리 => DAO 디자인 패턴을 이용한 프로그램
public class StudentManagerApp {
	//키보드 입력스트림을 저장하기 위한 필드
	private BufferedReader in;
	
	public StudentManagerApp() {
		//키보드로 문자열을 입력받기위한 입력스트림
		in=new BufferedReader(new InputStreamReader(System.in));
		
		String[] menu= {"1. 학생정보 삽입", "2. 학생정보 변경", "3. 학생정보 삭제",
				"4. 학생이름 검색", "5. 학생목록 출력", "6. 프로그램 종료"};
		
		System.out.println("<<학생 관리 프로그램>>");
		
		while(true) {
			//메뉴 출력
			for(String item:menu) {
				System.out.println(item);
			}
			
			//메뉴 선택
			int choice;
			try {
				System.out.print("선택[1~6] >> ");
				choice=Integer.parseInt(in.readLine()); //NumberFormatException 발생 가능
				if(choice<1 || choice>6) { //범위 밖의 입력값일 경우
					throw new Exception(); //인위적 예외 발생 
				}
			} catch(Exception e) {
				System.out.println("[에러]메뉴를 잘못 선택했습니다.\n");
				continue;
			}
			System.out.println();
			
			if(choice==6) break;
			
			switch (choice) {
				case 1: addStudent(); break;
				case 2: modifyStudent(); break;
				case 3: removeStudent(); break;
				case 4: searchNameStudent(); break;
				case 5: displayAllStudent(); break;
			}
			System.out.println();
		}
		
		System.out.println("[메세지]프로그램을 종료합니다.");
	}
	
	//1. 학생정보 삽입 메소드
	//키보드로 학생정보를 입력받아 STUDENT 테이블에 삽입하고 처리결과 출력
	public void addStudent() {
		System.out.println("### 학생정보 삽입 ###");
		try {
			//키보드로 학생정보 입력받아 저장
			//ㄴ 입력값 검증 실패 시 재입력
			
			int no;
			while(true) { //학번 입력값 검증 반복문
				System.out.print("학번 입력 >> ");
				String noTemp=in.readLine();
				
				if(noTemp==null || noTemp.equals("")) {
					System.out.println("[error]학번을 반드시 입력해주세요.");
					continue;
				}
				//학번에 대한 입력패턴 저장(정규표현식)
				String noReg="^[1-9][0-9]{3}$";
				
				if(!Pattern.matches(noReg, noTemp)) {
					System.out.println("[error]학번을 형식에 맞게 입력해주세요.\n 형식) 0이 아닌 숫자로 시작하는 4자리 정수값");
					continue;
				}
				
				no=Integer.parseInt(noTemp); //문자열을 정수값으로 변환하여 저장
				
				//STUDENT 테이블에 저장된 기존 학생정보의 학번과 중복된 경우 재입력되도록 작성
				//학번을 전달받아 STUDENT 테이블에 저장된 해당 학번의 학생정보를 검색하여 처리
				//ㄴ StudentDAOImpl 클래스의 selectNoStudent(int no) 메소드 호출
				StudentDTO student=StudentDAOImpl.getDAO().selectNoStudent(no);
				if(student!=null) { //학번이 중복된 경우
					System.out.println("[입력오류]이미 사용중인 학번입니다. 다시 입력해주세요.");
					continue;
				}
				break;
			}
			
			String name;
			while(true) { //이름 입력값 검증 반복문
				System.out.print("이름 입력 >> ");
				name=in.readLine();
				
				if(name==null || name.equals("")) {
					System.out.println("[error]이름을 반드시 입력해주세요.");
					continue;
				}
				
				String nameReg="^[가-힣]{2,10}$";
				if(!Pattern.matches(nameReg, name)) {
					System.out.println("[error]이름은 2~10 범위의 한글로만 입력해주세요.");
					continue;
				}
				break;
			}
			
			String phone;
			while(true) { //전화번호 입력값 검증 반복문
				System.out.print("전화번호 입력 >> ");
				phone=in.readLine();
				
				if(phone==null || phone.equals("")) {
					System.out.println("[error]전화번호를 반드시 입력해주세요.");
					continue;
				}
				
				String phoneReg="(01[016789])-\\d{3,4}-\\d{4}";
				if(!Pattern.matches(phoneReg, phone)) {
					System.out.println("[error]전화번호를 형식에 맞게 입력해주세요.");
					continue;
				}
				break;
			}
			
			String address;
			while(true) { //주소 입력값 검증 반복문
				System.out.print("주소 입력 >> ");
				address=in.readLine();
				
				if(address==null || address.equals("")) {
					System.out.println("[error]전화번호를 반드시 입력해주세요.");
					continue;
				}
				break;
			}
			
			String birthday;
			while(true) { //생년월일 입력값 검증 반복문
				System.out.print("생년월일 입력 >> ");
				birthday=in.readLine();
				
				if(birthday==null || birthday.equals("")) {
					System.out.println("[error]생년월일을 반드시 입력해주세요.");
					continue;
				}
				
				String birthdayReg="(19|20)\\d{2}-(0[1|9]|1[0-2])-(0[1-9])|[12][0-9]|3[01]";
				if(!Pattern.matches(birthdayReg, birthday)) {
					System.out.println("[error]생년월일을 형식에 맞게 입력해주세요.");
					continue;
				}
				break;
			}
			
			//입력받은 학생 정보를 이용하여 StudentDTO 객체를 생성하여 필드값 변경
			//ㄴ DAO 클래스의 메소드를 호출하기 위해 필요한 값을 객체로 변환하여 전달
			StudentDTO student=new StudentDTO();
			student.setNo(no);
			student.setName(name);
			student.setPhone(phone);
			student.setAddress(address);
			student.setBirthday(birthday);
			
			//입력받은 학생 정보를 이용하여 STUDENT 테이블에 삽입
			//ㄴ StudentDAOImpl 클래스의 insertStudent() 메소드 호출
			//Singleton Class는 객체를 반환받아 메소드를 직접 호출해 사용
			int rows=StudentDAOImpl.getDAO().insertStudent(student);
			
			System.out.println("[처리결과]"+rows+"명의 학생정보를 삽입했습니다.");
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	//2. 학생정보 변경 메소드
	//키보드로 학번을 입력받아 STUDENT 테이블에 저장된 해당 학번의 학생정보를 검색하여 출력
	//ㄴ 키보드로 변경할 학생정보를 입력받아 STUDENT 테이블에 저장된 학생정보를 변경하고 처리결과를 반환받아 출력
	public void modifyStudent() {
		System.out.println("### 학생정보 변경 ###");
		
		try {
			//키보드로 학번을 입력받아 저장 - 입력값 검증
			int no;
			while(true) { //학번 입력값 검증 반복문
				System.out.print("학번 입력 >> ");
				String noTemp=in.readLine();
				
				if(noTemp==null || noTemp.equals("")) {
					System.out.println("[error]학번을 반드시 입력해주세요.");
					continue;
				}
				
				//학번에 대한 입력패턴 저장(정규표현식)
				String noReg="^[1-9][0-9]{3}$";
				
				if(!Pattern.matches(noReg, noTemp)) {
					System.out.println("[error]학번을 형식에 맞게 입력해주세요.\n [형식]0이 아닌 숫자로 시작하는 4자리 정수값");
					continue;
				}
				
				no=Integer.parseInt(noTemp);
				
				break;
			}
			
			//입력된 학번으로 STUDENT 테이블에 저장된 해당 학번의 학생정보를 검색하여 반환받아 저장
			StudentDTO student=StudentDAOImpl.getDAO().selectNoStudent(no);
			
			if(student==null) {
				System.out.println("[error]검색된 학생정보가 없습니다.");
				return;
			}
			
			//검색된 학생정보 출력
			System.out.println("\n============================================================");
			System.out.println("학번\t이름\t  전화번호\t    주소\t 생년월일");
			System.out.println("============================================================");
			
			System.out.println(student.getNo()+"\t"+student.getName()+"\t"+student.getPhone()+"\t"+student.getAddress()+"\t"+student.getBirthday());
			System.out.println("============================================================\n");
			
			//키보드로 변경값(이름, 전화번호, 주소, 생년월일)을 입력받아 저장 - 변경값 검증
			System.out.println("[메세지]변경값 입력(변경하지 않을경우 엔터 입력) >> ");
			
			String name;
			while(true) {
				System.out.print("이름 입력 >> ");
				name=in.readLine();
				
				String nameReg="^[가-힣]{2,10}$";
				
				if(name!=null && !name.equals("") && !Pattern.matches(nameReg, name)) {
					System.out.println("[error]이름은 2~10 범위의 한글만 입력해주세요.");
					continue;
				}
				break;	
			}
				String phone;
				while(true) {
					System.out.print("전화번호 입력 >> ");
					phone=in.readLine();
					
					String phoneReg="(01[016789])-\\d{3,4}-\\d{4}";
					if(phone==null && phone.equals("") && !Pattern.matches(phoneReg, phone)) {
						System.out.println("[error]전화번호를 형식에 맞게 입력해주세요.");
						continue;
					}
					break;
				}
				
				String address;
				System.out.print("주소 입력 >> ");
				address=in.readLine();
				
				String birthday;
				while(true) {
					System.out.print("생년월일 입력 >> ");
					birthday=in.readLine();
					
					String birthdayReg="(19|20)\\d{2}-(0[1|9]|1[0-2])-(0[1-9])|[12][0-9]|3[01]";
					if(birthday==null && birthday.equals("") && !Pattern.matches(birthdayReg, birthday)) {
						System.out.println("[error]생년월일을 형식에 맞게 입력해주세요.");
						continue;
					}
					
					break;
				}
				
				//변경값을 이용하여 검색된 StudentDTO 겍체의 필드값 변경
				if(name!=null && !name.equals("")) student.setName(name);
				if(phone!=null && !phone.equals("")) student.setPhone(phone);
				if(address!=null && !address.equals("")) student.setAddress(address);
				if(birthday!=null && !birthday.equals("")) student.setBirthday(birthday);
				
				//입력받은 학생정보를 이용하여 STUDENT 테이블에 저장된 학생정보를 변경하고 처리결과를 반환받아 저장
				int rows=StudentDAOImpl.getDAO().updateStudent(student);
				
				System.out.println("[처리결과]"+rows+"명의 학생정보를 변경했습니다.");
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	//3. 학생정보 삭제 메소드
	//키보드로 학번을 입력받아 STUDENT 테이블에 저장된 해당 학번의 학생정보를 삭제하고 처리결과를 반환받아 출력
	public void removeStudent() {
		System.out.println("### 학생정보 삭제 ###");
		
		try {
			//키보드로 학번을 입력받아 저장 - 입력값 검증
			int no;
			while(true) { //학번 입력값 검증 반복문
				System.out.print("학번 입력 >> ");
				String noTemp=in.readLine();
				
				if(noTemp==null || noTemp.equals("")) {
					System.out.println("[error]학번을 반드시 입력해주세요.");
					continue;
				}
				
				//학번에 대한 입력패턴 저장(정규표현식)
				String noReg="^[1-9][0-9]{3}$";
				
				if(!Pattern.matches(noReg, noTemp)) {
					System.out.println("[error]학번을 형식에 맞게 입력해주세요.\n [형식]0이 아닌 숫자로 시작하는 4자리 정수값");
					continue;
				}
				
				no=Integer.parseInt(noTemp);
				
				break;
			}
			
			//입력된 학번을 이용하여 STUDENT 테이블에 저장된 해당 학번의 학생정보를 삭제하고 처리결과를 반환받아 저장
			int rows=StudentDAOImpl.getDAO().deleteStudent(no);
			
			if(rows>0) { //삭제행이 있는 경우
				System.out.println("[처리결과]"+rows+"명의 학생정보를 삭제했습니다.");
			} else { //삭제행이 없는 경우(입력된 학번의 학생정보가 없는 경우)
				System.out.println("[error]해당 학번의 학생정보가 없습니다.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//4. 학생이름 검색 메소드
	//키보드로 이름을 입력받아 STUDENT테이블에 저장된 해당 이름의 학생목록을 검색하고 처리결과를 반환받아 출력
	public void searchNameStudent() {
		System.out.println("### 학생정보 검색 ###");
		
		try {
			//키보드로 학번을 입력받아 저장 - 입력값 검증
			String name;
			while(true) { //이름 입력값 검증 반복문
				System.out.print("이름 입력 >> ");
				name=in.readLine();
				
				if(name==null || name.equals("")) {
					System.out.println("[error]이름을 반드시 입력해주세요.");
					continue;
				}
				
				String nameReg="^[가-힣]{2,10}$";
				if(!Pattern.matches(nameReg, name)) {
					System.out.println("[error]이름은 2~10 범위의 한글로만 입력해주세요.");
					continue;
				}
				break;
			}
			
			//입력된 이름을 이용하여 STUDENT 테이블에 저장된 해당 이름의 학생정보를 검색하고 검색결과를 반환받아 저장
			List<StudentDTO> studentList=StudentDAOImpl.getDAO().selectNameStudentList(name);
			
			if(studentList.size()==0) { //List 객체에 저장된 요소가 없는 경우
				System.out.println("[error]검색된 학생정보가 없습니다.");
				return;
			}
			
			System.out.println("\n============================================================");
			System.out.println("학번\t이름\t  전화번호\t    주소\t 생년월일");
			System.out.println("============================================================");
			
			for(StudentDTO student:studentList) {
				System.out.println(student.getNo()+"\t"+student.getName()+"\t"+student.getPhone()+"\t"+student.getAddress()+"\t"+student.getBirthday());				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//5. 학생목록 출력 메소드
	//ㄴ STUDENT 테이블에 저장된 모든 학생정보를 검색하여 결과를 반환받아 출력
	public void displayAllStudent() {
		System.out.println("### 학생목록 출력 ###");
		
		//STUDENT 테이블에 저장된 모든 학생정보를 검색하여 저장
		//ㄴ StudentDAOImpl 클래스의 selectAllStudentList() 메소드 호출
		List<StudentDTO> studentList=StudentDAOImpl.getDAO().selectAllStudentList();
		
		//List 객체에 요소가 있을경우 false, 없을 경우 true를 반환
		if(studentList.isEmpty()) {
			System.out.println("[처리결과]저장된 학생정보가 없습니다.");
			return;
		}

		System.out.println("\n============================================================");
		System.out.println("학번\t이름\t  전화번호\t    주소\t 생년월일");
		System.out.println("============================================================");
		
		//List 객체의 요소를 제공받아 처리하는 반복문
		for(StudentDTO student:studentList) {
			System.out.println(student.getNo()+"\t"+student.getName()+"\t"+student.getPhone()+"\t"+student.getAddress()+"\t"+student.getBirthday());
		}
		System.out.println("============================================================\n");
		
	}
	
	public static void main(String[] args) {
		new StudentManagerApp();
	}
}
