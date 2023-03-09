package xyz.itwill.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentMapApp {
	public static void main(String[] args) {
		List<Student> studentListOne=new ArrayList<Student>();
		studentListOne.add(new Student("홍길동", 1000));
		studentListOne.add(new Student("임꺽정", 2000));
		studentListOne.add(new Student("전우치", 3000));
		studentListOne.add(new Student("일지매", 4000));
		studentListOne.add(new Student("장길산", 5000));
		
		List<Student> studentListTwo=new ArrayList<Student>();
		studentListTwo.add(new Student("유재석", 6000));
		studentListTwo.add(new Student("강호동", 7000));
		studentListTwo.add(new Student("신동엽", 8000));
		studentListTwo.add(new Student("김용만", 9000));	
		
		//두 List 객체를 한 번에 저장
		Map<Integer, List<Student>> studentMap=new HashMap<Integer, List<Student>>();
		studentMap.put(1, studentListOne);
		studentMap.put(2, studentListTwo);
		
		//일괄처리
		for(Integer temp:studentMap.keySet()) {
			System.out.println(temp+"반의 학생 정보 >> ");
			List<Student> studentList=studentMap.get(temp);
			
			for(Student student:studentList) {
				System.out.println(student);
			}
			System.out.println("\n===================================================\n");
		}
		
		
		
	}
}
