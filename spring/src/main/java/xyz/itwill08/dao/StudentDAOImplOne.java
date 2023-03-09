package xyz.itwill08.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import lombok.Setter;

//Spring DAO 기능을 이용하여 DAO 클래스 작성 - spring-jdbc 라이브러리를 프로젝트에 build
//ㄴ JdbcTemplate 객체의 템플릿 메소드를 호출하여 DAO 클래스의 메소드 작성

//JdbcTemplate 객체를 제공받아 사용하는 방법
//1. DI(Dependency Injection)를 이용하여 JdbcTemplate 객체를 제공받아 필드에 저장하여 사용
//2. JdbcTempleSupport 클래스를 상속받아 JdbcTemplate 객체를 Getter 메소드를 호출하여 사용
@Setter
public class StudentDAOImplOne implements StudentDAO {
	//JdbcTemplate 객체를 저장하기 위한 필드
	//ㄴ Spring Bean Configuration File에서 클래스를 Spring Bean으로 등록할 때 jdbcTemplate
	//클래스의 Spring Bean을 제공받아 의존관계 구현 - Setter 메소드를 이용한 의존성 주입 
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public int insertStudent(Student student) {
		String sql="insert into student values(?, ?, ?, ?, ?)";
		//JdbcTemplate.update(String sql, Object ... args) : SQL 명령(INSERT, UPDATE, DELETE)을
		//DBMS 서버에 전달하여 실행하는 메소드 - 조작행의 갯수 반환  
		//ㄴ 매개변수에는 DBMS 서버에 전달할 SQL 명령과 SQL 명령의 InParameter(?)에 대신
		//표현될 값을 차례대로 나열하여 제공
		//ㄴ SQL 명려의 InParameter 갯수만큼 반드시 args 매개변수에 값을 전달
		return jdbcTemplate.update(sql, student.getNo(), student.getName()
				, student.getPhone(), student.getAddress(), student.getBirthday());
	}

	@Override
	public int updateStudent(Student student) {
		String sql="update student set name=?, phone=?, address=?, birthday=? where no=?";
		return jdbcTemplate.update(sql, student.getNo(), student.getName()
				, student.getPhone(), student.getAddress(), student.getBirthday());
	}

	@Override
	public int deleteStudent(int no) {
		return jdbcTemplate.update("delete from student where no=?", no);
	}

	@Override
	public Student selectStudent(int no) {
		try {
			String sql="select * from student where no=?";
			//JdbcTemplate.queryForObject(String sql, RowMapper<T> rowMapper, Object ... args)
			//ㄴ SQL 명령(SELECT)을 DBMS 서버에 전달하여 실행하는 메소드
			//ㄴ 단일행의 검색결과를 하나의 Java 객체로 반환받기 위해 사용
			//ㄴ 매개변수에는 DBMS 서버에 전달한 SQL 명령과 검색행을 Java 객체로 변환하기 위한 매핑정보 제공
			//저장한 RowMapper 객체와 SQL 명령의 InParameter 대신 표현될 값을 차례대로 나열하여 제공
			//RowMapper 객체 : 검색행의 컬럼값을 Java 객체의 필드값으로 저장하여 반환하기 위한 정보를 제공하는 객체
			//ㄴ RowMapper 인터페이스를 상속받은 익명의 내부 클래스(Annonymous Inner Class)로 객체 생성
			//ㄴ RowMapper 인터페이스의 제네릭에는 RowMapper 객체가 매핑하여 반환할 Java 객체의 자료형(클래스)을 설정
			//ㄴ RowMapper 인터페이스의 mapRow 추상 메소드를 반드시 Overried 선언
			//ㄴ mapRow 메소드 : 검색행의 컬럼값을 객체 필드에 매핑되도록 설정 - 매개변수로 검색결과를 제공받아 사용 가능
			return jdbcTemplate.queryForObject(sql, new RowMapper<Student>() {
				@Override
				public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
					Student student=new Student();
					student.setNo(rs.getInt("no"));
					student.setName(rs.getString("name"));
					student.setPhone(rs.getString("phone"));
					student.setAddress(rs.getString("address"));
					student.setBirthday(rs.getString("birthday"));
					return student;
				}
			}, no);
		} catch (EmptyResultDataAccessException e) {
			//EmptyResultDataAccessException : queryForObject() 메소드에 의해 검색된 행이 없는 경우 예외발생
			return null;
		}
	}

	@Override
	public List<Student> selectStudentList() {
		String sql="select * from student order by no";
		//JdbcTemplate.query(String sql, RowMapper<T> rowMapper, Object ... args)
		//ㄴ SQL 명령(SELECT)을 DBMS 서버에 전달하여 실행하는 메소드
		//ㄴ 다수행의 검색결과를 List 객체로 반환받기 위해 사용 - 하나의 검색행은 List 객체의 요소로 추가
		//ㄴ 매개변수에는 DBMS 서버에 전달한 SQL 명령과 검색행을 Java 객체로 변환하기 위한 매핑정보를 
		//저장한 RowMapper 객체와 SQL 명령의 InParameter 대신 표현될 값을 차례로 나열하여 제공
		return jdbcTemplate.query(sql, new RowMapper<Student>() {
			@Override
			public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
				Student student=new Student();
				student.setNo(rs.getInt("no"));
				student.setName(rs.getString("name"));
				student.setPhone(rs.getString("phone"));
				student.setAddress(rs.getString("address"));
				student.setBirthday(rs.getString("birthday"));
				return student;
			}
		});
	}
}