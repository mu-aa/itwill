package realization;

//학생 관리 클래스가 반드시 상속받아야 하는 인터페이스
//ㄴ 학생 관리 클래스의 메소드 작성 규칙 제공(작업 지시서)
public interface Jdbc {
	
	void insert();
	void update();
	void delete();
	void select();
	
}
