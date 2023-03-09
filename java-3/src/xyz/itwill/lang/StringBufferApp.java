package xyz.itwill.lang;


//StringBuffer 클래스 : 문자열을 저장하기 위한 클래스
//ㄴ String = 객체에 저장된 문자열을 직접 처리하지 않고 //문자열 자체를 처리하는 메소드 제공//(원본 영향x)
//ㄴ StringBuffer = 객체에 저장된 문자열을 //직접 처리하는 메소드 제공//(원본 영향o)
//ㄴ String 클래스보다 StringBuffer 클래스의 메소드가 문자열 처리 속도 우수   . . .  처리 속도) String < StringBuffer < StringBuilder
public class StringBufferApp {
	public static void main(String[] args) {
		//StringBuffer 클래스는 new 연산자로 생성자를 호출하여 객체 생성(" " 기호로 객체 생성 불가능)
		StringBuffer sb=new StringBuffer("ABC");
		
		System.out.println("sb.toString() = "+sb.toString());
		System.out.println("sb = "+sb); //참조변수 호출 시 toString() 생략 가능
		
		//StringBuffer 객체에 저장된 문자열을 String 객체로 생성하여 참조변수에 저장(toString() 생략 불가능)
		String str=sb.toString(); // StringBuffer -> String 변환
		System.out.println("str = "+str);
		System.out.println("\n=======================================================\n");

		
		//★StringBuffer.append(Object obj) : StringBuffer 객체에 저장된 문자열에다 매개변수에 저장된 값을 추가하는 메소드
		//ㄴ String 객체에 저장된 문자열에 += 연산자를 사용한 효과와 동일
		sb.append("DEF");
		str+="DEF"; // append와 같은 개념(비권장)
		System.out.println("sb = "+sb);
		System.out.println("str = "+str);
		System.out.println("\n=======================================================\n");
		
		
		//☆StringBuffer.insert(int offset, Object obj) : StringBuffer 객체에 저장된 문자열에다
		//                                              매개변수에 저장된 문자열을 원하는 위치에 삽입하는 메소드
		sb.insert(4, "-");
		System.out.println("sb = "+sb);
		System.out.println("\n=======================================================\n");
		
		
		//StringBuffer.deleteCharAt(int index) : StringBuffer 객체에 저장된 문자열에서
		//										 매개변수에 저장된 위치의 문자 하나를 제거하는 메소드
		sb.deleteCharAt(2);
		System.out.println("sb = "+sb);
		System.out.println("\n=======================================================\n");

		
		//☆StringBuffer.delete(int beginIndex, int endIndex) : StringBuffer 객체에 저장된 문자열에서 매개변수에 저장된
		//													  시작위치부터 종료위치까지의 문자열을 제거하는 메소드
		sb.delete(4, 6);
		System.out.println("sb = "+sb);
		System.out.println("\n=======================================================\n");
		
		
		//StringBuffer.reverse() : StringBuffer 객체에 저장된 문자열을 역순으로 나열되도록 재저장하는 메소드
		sb.reverse();
		System.out.println("sb = "+sb);
		System.out.println("\n=======================================================\n");
	}
}
