package xyz.itwill.util;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

//
public class StudenSetApp {
	public static void main(String[] args) {
		Set<Student> studentSet=new HashSet<Student>();
		
		studentSet.add(new Student("홍길동", 1000));
		studentSet.add(new Student("임꺽정", 2000));
		studentSet.add(new Student("전우치", 3000));
	
		//Set 객체에 동일한 값이 저장된 Student 객체가 요소로 저장 가능
		//ㄴ Student 객체에 저장된 값은 같지만 객체는 다르므로 요소로 저장 가능
		//hashCode() 메소드와 equals() 메소드를 오버라이드 선언하여 동일한 값이 저장된 객체를 Set 객체의 요소로 저장하지 않도록 설정 가능
		//ㄴ> 매개변수로 전달받은 객체를 
		//    1. hashCode()메소드로 기존 요소의 HashCode(메모리 주소)와 비교, 같은 경우 
		//    2. equals() 메소드로 기존에 있던 필드값(실제 데이터)들과 비교, 같으면 Set 객체에 저장되지 않도록 동작
		//studentSet.add(new Student("홍길동", 1000));  학번이 같은 학생정보 저장 불가능
		studentSet.add(new Student("홍길동", 4000)); // 현재 학번만 비교 진행(이름은 시간 없어서 안함)
		
		Iterator<Student> iterator=studentSet.iterator();
		
		while(iterator.hasNext()) {
			//객체를 반환받아 출력할 경우 Student.toString() 메소드 자동 호출
			System.out.println(iterator.next());
		}
		
	}
}
