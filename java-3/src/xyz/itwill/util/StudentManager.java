package xyz.itwill.util;

import java.util.ArrayList;
import java.util.List;

//학생 정보를 관리(저장 변경 삭제 검색 - CRUD)하는 기능을 제공하는 클래스  =>  BO 클래스(Business Class), Manager 클래스
public class StudentManager {
	//다수의 학생정보를 저장하기 위한 Collection(컬렉션) 필드 - 저장매체
	private List<Student> studentList=new ArrayList<Student>();
	
	//학번을 전달받아 컬렉션 필드에 저장된 요소의 학번과 비교하여 같은 요소의 첨자를 반환하는 메소드(중복 검사)
	private int getStudentIndex(int num) {
		int index=-1; // i가 0부터 시작하기 때문에 다른 값을 저장하기 위해 -1로 설정
		
		//컬렉션 필드에 저장된 모든 요소에 일괄처리 위한 반복문
		for(int i=0;i<studentList.size();i++) {
			if(studentList.get(i).getNum() ==num){  //컬렉션 필드에 저장된 요소의 학번과 매개변수로 전달받은 학번이 같은 경우
				index=i; //변수의 요소 인덱스 저장
				break;
			}
		}
		
		return index; //요소의 첨자 반환 - 컬렉션 필드에서 요소가 검색되지 않은 경우 -1이 반환
	}
	
	//학번을 전달받아 컬렉션 필드의 요소로 추가하고 처리 결과를 반환하는 메소드
	//ㄴ false 반환 : 요소 추가 실패    //true 반환 : 요소 추가 성공
	//ㄴ 전달받은 학생정보의 학번이 이미 컬렉션 필드에 저장된 요소의 학번과 중복된 경우 저장되지 않도록 작성
	public boolean addStudent(Student student){
		
		//컬렉션 필드에 이미 저장된 학번의 학생인 경우(중복일 경우)
		if(getStudentIndex(student.getNum()) != -1) {
			return false;           //false를 반환(저장 실패)
		}

		studentList.add(student); // List 객체에 요소(전달받은 매개변수)를 추가
		return true;
	}
	
	
	//학번을 전달받아 컬렉션 필드의 요소를 변경하고 처리 결과를 반환하는 메소드
	//ㄴ false 반환 : 요소 변경 실패    //true 반환 : 요소 변경 성공
	//ㄴ 전달받은 학생정보의 학번이 컬렉션 필드에 저장된 요소의 학번이 아닌 경우 변경 실패
	public boolean modifyStudent(Student student){
		int index=getStudentIndex(student.getNum());   //전달받은 매개변수의 학번을 getStudentIndex 메소드로 중복검사 후 결과 저장
		
		//컬렉션 필드에 없는 학생정보인 경우(getStudentIndex 메소드를 돌려본 결과가 index 필드에 저장돼있음)
		if(index==-1) {
			return false;
		}
		
		studentList.set(index, student);  //index 첨자 위치의 요소를 전달받은 매개변수로 변경
		return true;
	}
	
	
	//학번을 전달받아 컬렉션 필드의 요소를 삭제하고 처리 결과를 반환하는 메소드
	public boolean removeStudent (int num){
		int index=getStudentIndex(num);   //전달받은 매개변수의 학번을 getStudentIndex 메소드로 중복검사 후 결과 저장
		
		//컬렉션 필드에 없는 학생정보인 경우(getStudentIndex 메소드를 돌려본 결과가 index 필드에 저장돼있음)
		if(index==-1) {
			return false;
		}
		
		studentList.remove(index);  //List 객체의 첨자 위치의 요소를 삭제
		return true;
	}
	
	
	//학번을 전달받아 컬렉션 필드의 요소를 검색하여 학생 정보를 반환하는 메소드
	public Student getStudent(int num){
		int index=getStudentIndex(num);
		
		//컬렉션 필드에 없는 학생정보인 경우(getStudentIndex 메소드를 돌려본 결과가 index 필드에 저장돼있음)
		if(index==-1) {
			return null;
			}
		
		return studentList.get(index);  // List 객체에서 첨자위치의 요소를 반환하는 메소드 호출
		}
	
	
	//컬렉션 필드에 저장된 모든 학생정보를 반환하는 메소드
	public List<Student> getStudentList(){		
		return studentList;
	}
}
