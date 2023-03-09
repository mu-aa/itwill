package xyz.itwill.student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//DAO(Data Access Object) 클래스 : 저장매체에 행단위 정보(Record)를 삽입, 변경, 삭제, 검색하는 기능을 제공하기 위한 클래스
//ㄴ 저장매체 : 정보를 행단위로 저장하기 위한 하드웨어 또는 소프트웨어 - DBMS
//ㄴ 인터페이스를 상속 받아 작성하는 것을 권장 - 메소드의 작성 규칙 제공 : 유지보수의 효율성, 가독성 증가
//ㄴ Singleton 디자인 패턴을 적용하여 작성하는 것을 권장(프로그램에 하나의 객체만 제공하기 위해)

//STUDENT 테이블에 행(학생정보)을 삽입, 변경, 삭제, 검색하기 위한 메소드를 제공하는 클래스
//ㄴ 하나의 메소드는 매개변수로 객체(값)를 전달받아 하나의 SQL 명령만을 전달하여 실행하고 실행 결과를 Java 객체(값)로 반환
public class StudentDAOImpl extends JdbcDAO implements StudentDAO{
	private static StudentDAOImpl _dao;
	
	//기본 생성자를 private 접근 지정자로 설정해(은닉화) 외부에서 객체 생성을 방지
	private StudentDAOImpl() {
		// TODO Auto-generated constructor stub
	}
	
	static {
		_dao=new StudentDAOImpl();
	}
	
	//StudentDAOImpl 객체를 반환하는 정적 메소드
	public static StudentDAOImpl getDAO() {
		return _dao;
	}

	//학생정보를 전달받아 STUDENT 테이블에 삽입하고 삽입행의 갯수를 반환하는 메소드
	@Override  
	public int insertStudent(StudentDTO student) {
		Connection con=null;
		PreparedStatement pstmt=null;
		int rows=0; //처리결과를 저장하기 위한 변수
		
		try {
			con=getConnection(); //JdbcDAO 클래스(상속받은 부모클래스)의 getConnection() 메소드 호출
			
			String sql="insert into student values(?, ?, ?, ?, ?)";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, student.getNo());
			pstmt.setString(2, student.getName());
			pstmt.setString(3, student.getPhone());
			pstmt.setString(4, student.getAddress());
			pstmt.setString(5, student.getBirthday());
			
			rows=pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("[error]insertStudent() 메소드의 SQL 오류 = "+e.getMessage());
		} finally {
			close(con, pstmt);
		}
		return rows;
	}

	//학생정보를 전달받아 STUDENT 테이블에 저장된 학생정보를 변경하고 변경행의 갯수를 반환하는 메소드
	@Override
	public int updateStudent(StudentDTO student) {
		Connection con=null;
		PreparedStatement pstmt=null;
		int rows=0;
		try {
			con=getConnection();
			
			String sql="update student set name=?, phone=?, address=?, birthday=? where no=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, student.getName());
			pstmt.setString(2, student.getPhone());
			pstmt.setString(3, student.getAddress());
			pstmt.setString(4, student.getBirthday());
			pstmt.setInt(5, student.getNo());
			
			rows=pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("[error]updateStudent() 메소드의 SQL 오류 = "+e.getMessage());
		} finally {
			close(con, pstmt);
		}
		return rows;
	}

	//학번을 전달받아 STUDENT 테이블에 저장된 학생정보를 삭제하고 삭제행의 갯수를 반환하는 메소드
	@Override
	public int deleteStudent(int no) {
		Connection con=null;
		PreparedStatement pstmt=null;
		int rows=0;
		
		try {
			con=getConnection(); //JdbcDAO 클래스(상속받은 부모클래스)의 getConnection() 메소드 호출
			
			String sql="delete from student where no=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, no);
			
			rows=pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("[error]insertStudent() 메소드의 SQL 오류 = "+e.getMessage());
		} finally {
			close(con, pstmt);
		}
		return rows;
	}

	//학번을 전달받아 STUDENT 테이블에 저장된 해당 학번의 학생정보를 검색하여 반환하는 메소드 
	//ㄴ 단일행을 검색하여 검색결과를 값 또는 DTO 객체로 반환
	@Override
	public StudentDTO selectNoStudent(int no) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		StudentDTO student=null; //처리결과를 저장하는 변수
		
		try {
			con=getConnection();
			
			String sql="select * from student where no=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, no);
			
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				//검색행의 컬럼값을 DTO 객체의 필드값으로 변환하여 저장 - 매핑처리
				student=new StudentDTO(); //StudentDTO 객체를 생성하여 저장
				student.setNo(rs.getInt("no")); //검색행의 컬럼값을 반환받아 DTO 객체의 필드값 변경(매핑처리)
				student.setName(rs.getString("name"));
				student.setPhone(rs.getString("phone"));
				student.setAddress(rs.getString("address"));
				student.setBirthday(rs.getString("birthday").substring(0, 10));
			}
			
		} catch (Exception e) {
			System.out.println("[error]selectNoStudent() 메소드의 SQL 오류 = "+e.getMessage());
		} finally {
			close(con, pstmt, rs);
		}
		//검색행이 없는 경우 null, 있는 경우 StudentDTO 객체 반환
		return student;
	}

	//이름을 전달받아 STUDENT 테이블에 저장된 해당 이름의 학생목록을 검색하여 반환하는 메소드
	@Override
	public List<StudentDTO> selectNameStudentList(String name) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<StudentDTO> studentList=new ArrayList<StudentDTO>();
		
		try {
			con=getConnection();
			
			//where 조건식에서 매개변수로 전달된 값과 일치하는 행 검색
			//String sql="select * from student where name=? order by no";
			
			//where 조건식에서 매개변수로 전달된 값이 포함된 행 검색
			String sql="select * from student where name like '%'||?||'%' order by no";
			
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, name);
			
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				//처리행의 컬럼값을 DTO 객체의 필드값으로 변환하여 저장 - 매핑처리
				StudentDTO student=new StudentDTO();
				student=new StudentDTO(); //StudentDTO 객체를 생성하여 저장
				student.setNo(rs.getInt("no"));
				student.setName(rs.getString("name"));
				student.setPhone(rs.getString("phone"));
				student.setAddress(rs.getString("address"));
				student.setBirthday(rs.getString("birthday").substring(0, 10));
				
				//★List 객체의 요소(Element)로 StudentDTO 객체 추가
				studentList.add(student);
			}
			} catch (SQLException e) {
			System.out.println("[error]selectNameStudentList() 메소드의 SQL 오류 = "+e.getMessage());
			} finally {
				close(con, pstmt, rs);
		}
		return studentList;
	}

	//STUDENT 테이블에 저장된 모든 학생정보를 검색하여 반환하는 메소드
	//ㄴ 다중행의 검색결과는 List 객체로 반환
	@Override
	public List<StudentDTO> selectAllStudentList() {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<StudentDTO> studentList=new ArrayList<StudentDTO>();
		
		try {
			con=getConnection();
			
			String sql="select * from student order by no";
			pstmt=con.prepareStatement(sql);
			
			rs=pstmt.executeQuery();
			
			
			while(rs.next()) {
				//처리행의 컬럼값을 DTO 객체의 필드값으로 변환하여 저장 - 매핑처리
				StudentDTO student=new StudentDTO();
				student=new StudentDTO(); //StudentDTO 객체를 생성하여 저장
				student.setNo(rs.getInt("no")); //검색행의 컬럼값을 반환받아 DTO 객체의 필드값 변경
				student.setName(rs.getString("name"));
				student.setPhone(rs.getString("phone"));
				student.setAddress(rs.getString("address"));
				student.setBirthday(rs.getString("birthday").substring(0, 10));
				
				//List 객체의 요소(Element)로 StudentDTO 객체 추가
				studentList.add(student);
			}
			} catch (SQLException e) {
			System.out.println("[error]selectAllStudentList() 메소드의 SQL 오류 = "+e.getMessage());
			} finally {
				close(con, pstmt, rs);
		}
		return studentList;
	}
}