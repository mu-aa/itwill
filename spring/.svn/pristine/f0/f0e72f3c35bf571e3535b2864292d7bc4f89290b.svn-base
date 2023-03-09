package xyz.itwill08.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

//JdbcDaoSupport 클래스를 상속받아 DAO 클래스 작성
//ㄴ JdbcDaoSupport 클래스 : getJdbcTemplate() 객체를 포함하고 있는 클래스
public class StudentDAOImplTwo extends JdbcDaoSupport implements StudentDAO {
	@Override
	public int insertStudent(Student student) {
		String sql="insert into student values(?, ?, ?, ?, ?)";
		//
		return getJdbcTemplate().update(sql, student.getNo(), student.getName()
				, student.getPhone(), student.getAddress(), student.getBirthday());
	}

	@Override
	public int updateStudent(Student student) {
		String sql="update student set name=?, phone=?, address=?, birthday=? where no=?";
		return getJdbcTemplate().update(sql, student.getName(), student.getPhone()
				, student.getAddress(), student.getBirthday(), student.getNo());
	}

	@Override
	public int deleteStudent(int no) {
		return getJdbcTemplate().update("delete from student where no=?", no);
	}

	@Override
	public Student selectStudent(int no) {
		try {
			String sql="select * from student where no=?";
			//RowMapper 인터페이스를 상속받은 자식 클래스를 객체로 생성하여 매개변수에 전달
			//ㄴ 중복된 코드를 최소화하여 유지보수 효율성 증가
			return getJdbcTemplate().queryForObject(sql, new StudentRowMapper(), no);
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	@Override
	public List<Student> selectStudentList() {
		String sql="select * from student order by no";
		return getJdbcTemplate().query(sql, new StudentRowMapper());
	}
	
	//RowMapper 인터페이스를 상속받은 자식 클래스 - 내부 클래스(Inner Class - Nested Class)
	//ㄴ 검색행의 컬럼값을 객체 필드에 저장하는 매핑정보를 제공하여 객체를 반환하는 메소드
	public class StudentRowMapper implements RowMapper<Student> {
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
	}
}