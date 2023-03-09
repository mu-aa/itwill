package xyz.itwill.util;

//학생정보(학번 이름)를 저장하기 위한 클래스 - VO클래스
//ㄴ 객체의 컬럼값을 비교하는 기능을 제공받기 위해 Comparable 인터페이스를 상속
public class Student implements Comparable<Student>{
	private String name;
	private int num;
	
	public Student() {
		// TODO Auto-generated constructor stub
	}
	
	public Student(String name, int num) {
		super();
		this.name = name;
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}
	
	
	@Override
	public int hashCode() {
		return num;
	}

	@Override		//VO 클래스에 저장된 필드값을 반환받아 확인하기 위해 오버라이드 선언
	public String toString() {
		return "[학번]"+num+"  이름 = "+name;
	}
	
	@Override		//VO 클래스에 저장된 필드값을 비교하여 결과를 반환하기 위해 오버라이드 선언
	public boolean equals(Object obj) {
		if(obj instanceof Student) {
			//매개변수로 전달받은 객체를 명시적 객체 형변환하여 참조변수에 저장
			Student student=(Student)obj;
			//메소드의 객체(this)와 매개변수로 전달받은 객체(obj)의 필드값을 비교해 true 또는 false 반환
			//ㄴ 학번을 비교하여 같은 경우 [true] 반환
			if(num==student.num) return true;
		}
		//비교 불가능하거나 학번이 다른경우 [false] 반환
		return false;
	}

	//객체의 컬럼값을 매개변수로 전달받은 객체의 컬럼값과 비교하여 결과 반환하는 메소드
	//ㄴ 객체의 컬럼값이 큰 경우 양수 반환, 매개변수의 객체 컬럼값이 경우 음수 반환, 같은경우 0 반환하도록 작성
	//ㄴ 오름차순 또는 내림차순 정렬을 위한 비교값 설정
	@Override
	public int compareTo(Student o) {
		//num필드값과 전달받은 매개변수를 빼서 양수 음수 0을 판단
//		return num-o.num; //학번을 비교하여 오름차순 정렬 
		return o.num-num; //학번을 비교하여 내림차순 정렬 
//		return name.compareTo(o.name); //이름을 비교하여 오름차순 정렬
//		return o.name.compareTo(name); //이름을 비교하여 내림차순 정렬
	}

}
