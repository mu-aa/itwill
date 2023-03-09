package enumerate;


//인터페이스(클래스)에 상수필드를 선언한 경우의 단점
//ㄴ 상수필드를 값을 대표하는 단어(식별자)로 사용하기 부적절
//ㄴ 상수필드가 선언된 인터페이스 또는 클래스가 아무런 의미 없이 접근 용도로만 사용
//ㄴ 위와 같은 단점을 해결하기 위해 Java에서 열거형(Enum)이라는 Java 자료형(참조형)을 제공

public class InterfaceApp {
	public static void main(String[] args) {
		//인터페이스에 선언된 상수필드값 출력
		System.out.println("삽입 = "+interfaceOne.INSERT);
		System.out.println("변경 = "+interfaceOne.UPDATE);
		System.out.println("삭제 = "+interfaceOne.DELETE);
		System.out.println("검색 = "+interfaceOne.SELECT);
		System.out.println("\n==========================================\n");
		
		
		System.out.println("삽입 = "+interfaceTwo.ADD);
		System.out.println("변경 = "+interfaceTwo.MODIFY);
		System.out.println("삭제 = "+interfaceTwo.REMOVE);
		System.out.println("검색 = "+interfaceTwo.SEARCH);
		System.out.println("\n==========================================\n");
		
		
		//상수 필드에 저장된 값과 동일한 자료형(원시형)의 변수를 생성하여 상수 저장 가능
		int choice=interfaceOne.INSERT, choiceTwo=interfaceTwo.ADD;
		
		System.out.println("선택 = "+choice);
		switch(choice) {
		case interfaceOne.INSERT: System.out.println("학생정보 삽입"); break;
		case interfaceOne.UPDATE: System.out.println("학생정보 변경"); break;
		case interfaceOne.DELETE: System.out.println("학생정보 삭제"); break;
		case interfaceOne.SELECT: System.out.println("학생정보 검색"); break;
		}
		
		System.out.println("선택 = "+choiceTwo);
		switch(choiceTwo) {
		case interfaceTwo.ADD: System.out.println("학생정보 삽입"); break;
		case interfaceTwo.MODIFY: System.out.println("학생정보 변경"); break;
		case interfaceTwo.REMOVE: System.out.println("학생정보 삭제"); break;
		case interfaceTwo.SEARCH: System.out.println("학생정보 검색"); break;
		}
		
	}
}
