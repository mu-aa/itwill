package xyz.itwill07.aop;

import java.util.List;

import lombok.Setter;

//핵심관심모듈
@Setter
public class StudentServiceImpl implements StudentService {
	private StudentDAO studentDAO;
	
	@Override
	public void addStudent(Student student) {
		System.out.println("*** StudentServiceImpl 클래스의 addStudent(Student student) 메소드 호출 ***");
		studentDAO.insertStudent(student);
	}

	@Override
	public Student getStudent(int num) {
		System.out.println("*** StudentServiceImpl 클래스의 getStudent(int num) 메소드 호출 ***");
		return studentDAO.selectStudent(num);
	}

	@Override
	public List<Student> getStudentList() {
		System.out.println("*** StudentServiceImpl 클래스의 getStudentList() 메소드 호출 ***");
		throw new RuntimeException(); //인위적 예외 발생
		//return studentDAO.selectStudentList();
	}
}