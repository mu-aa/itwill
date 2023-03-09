package xyz.itwill.lang;


//String 클래스 : 문자열을 표현하기 위한 클래스
//ㄴ 문자열을 저장하기 위한 객체 생성
//ㄴ String 객체에 저장된 문자열에 대한 다양한 기능을 메소드로 제공
//ㄴ String 객체는 문자열을 //내부적으로 byte 배열로 처리//하여 배열 요소에 문자를 하나씩 저장
public class StringApp {
	public static void main(String[] args) {
		//문자열은 " " 기호를(new연산자 대신) 사용하여 String 객체로 표현 가능
		//ㄴ " " 기호를 사용하여 String 객체를 생성할 경우 메모리의 정적 영역(메소드 영역)에 객체 생성
		//ㄴ 정적영역(메소드영역)에는 동일한 문자열이 저장된 String 객체는 하나만 생성
		String str1="ABC"; // String 객체를 생성하여 참조변수에 저장
		
		//String.toString() : String 객체에 저장된 문자열을 반환하는 메소드
		
		System.out.println("str1.toString() = "+str1.toString());
		
		//참조변수를 출력할 경우 toString() 메소드는 생략 가능
		System.out.println("str1 = "+str1);
		System.out.println("\n=========================================\n");
		
		
		// " " 기호를 사용하여 String 객체를 표현한 경우
		//동일한 문자열이 저장된 String 객체가 존재하면 기존 String 객체를 제공받아 사용(객체 재사용)
		String str2="ABC";
		
		//참조변수를 == 연산자(비교연산자)로 비교할 경우 참조변수에 저장된 객체의 메모리 주소(해시코드)를 비교함
		//ㄴ String 객체의 //문자열을 비교하는 것이 아니라// String 객체의 메모리 주소(해시코드)를 비교하는 것임
		if(str1==str2) {
			System.out.println("str1과 str2의 변수에 저장된 String 객체의 해시코드가 일치");
		} else {
			System.out.println("str1과 str2의 변수에 저장된 String 객체의 해시코드가 불일치");
		}
		System.out.println("\n=========================================\n");
		
		
		String str3=new String("ABC");
		
		//new 연산자로 생성자를 호출하여 String 객체를 생성한 경우 메모리의 Heap 영역에 객체가 생성됨
		if(str1==str3) {
			System.out.println("str1과 str3의 변수에 저장된 String 객체의 해시코드가 일치");
		} else {
			System.out.println("str1과 str3의 변수에 저장된 String 객체의 해시코드가 불일치");
		}
		System.out.println("\n=========================================\n");
		
		
		//★String.equals(String str) : String 객체에 저장된 문자열과 매개변수로 전달받은 문자열을
		//                            비교하여 참 거짓을 반환하는 메소드(대소문자 구분)
		if(str1.equals(str3)) {
			System.out.println("str1과 str2의 변수에 저장된 String 객체의 문자열이 일치");
		} else {
			System.out.println("str1과 str2의 변수에 저장된 String 객체의 문자열이 불일치");
		}
		System.out.println("\n=========================================\n");
		
		
		String str4="abc";
		if(str1.equals(str4)) {
			System.out.println("str1과 str4의 변수에 저장된 String 객체의 문자열이 일치");
		} else {
			System.out.println("str1과 str4의 변수에 저장된 String 객체의 문자열이 불일치");
		}
		System.out.println("\n=========================================\n");
		
		
		//String.equalsIgnoreCase(String str) : String 객체에 저장된 문자열과 매개변수로 전달받은 문자열을
		//                                      대소문자 구분 없이 비교하여 참 거짓을 반환
		if(str1.equalsIgnoreCase(str4)) {
			System.out.println("str1과 str4의 변수에 저장된 String 객체의 문자열이 일치");
		} else {
			System.out.println("str1과 str4의 변수에 저장된 String 객체의 문자열이 불일치");
		}
		System.out.println("\n=========================================\n");
		
		
		//String.compareTo(String str) : String 객체에 저장된 문자열과 매개변수로 전달받은 문자열을 비교하여
		//String 객체의 문자열이 큰 경우 양수를 반환, 매개변수의 문자열이 클 경우 음수를 반환, 같을 경우 0을 반환하는 메소드
		if(str1.compareTo(str4)>0) {
			System.out.println("str1에 저장된 String 객체의 문자열이 str4에 저장된 String 객체의 문자열보다 큽니다");
		} else if(str1.compareTo(str4)<0){
			System.out.println("str1에 저장된 String 객체의 문자열이 str4에 저장된 String 객체의 문자열보다 작습니다");
		} else {
			System.out.println("str1에 저장된 String 객체의 문자열이 str4에 저장된 String 객체의 문자열과 같습니다");
		}
		System.out.println("\n=========================================\n");
		
		
		//String.getBytes() : String 객체에 저장된 //문자열을 byte 배열로 변환하여 반환//하는 메소드
		//ㄴ byte 배열의 요소에는 문자열의 문자 코드값(정수값)이 차례대로 저장
		byte[] array=str1.getBytes();
		
		for(byte ch:array) {
			//byte 배열 요소값을 문자로 형 변환하여 출력
//			System.out.println((char)ch);  문자열로 출력
			System.out.println(ch);     // 문자 코드값으로 출력
		}
		System.out.println("\n=========================================\n");
		
		
		String str5="ABCDEFG";
		//String.length() : String 객체에 저장된 문자열의 문자 갯수를 반환하는 메소드
		
		System.out.println("문자열의 문자 갯수 = "+str5.length());
		System.out.println("\n=========================================\n");
		
		
		//String.charAt(int index) : String 객체에 저장된 문자열에서 //첨자(Index) 위치의 문자를 반환//하는 메소드
		System.out.println("다섯번째 위치의 문자 = "+str5.charAt(4));
		System.out.println("\n=========================================\n");
		
		//★String.indexOf(String str)
		//ㄴ String 객체에 저장된 문자열에서 매개변수로 저장된 //문자열(문자)을 검색하여 시작위치값(첨자)을 반환//하는 메소드
		//ㄴ 매개변수의 문자열을 찾을 수 없을 경우 -1 반환
		System.out.println("A 문자의 저장 위치(인덱스) = str1["+str5.indexOf("A")+"]");
		System.out.println("C 문자의 저장 위치(인덱스) = str1["+str5.indexOf("C")+"]");
		System.out.println("E 문자의 저장 위치(인덱스) = str1["+str5.indexOf("E")+"]");
		System.out.println("\n=========================================\n");
		
		
		String str6="Java Programming";
		
		System.out.println("str6 = "+str6);
		//★String.toUpperCase() : String 객체에 저장된 문자열을 모두 대문자로 변환하여 반환(원본은 변하지 않음)
		System.out.println("str6 = "+str6.toUpperCase());
		//★String.toLowerCase() : String 객체에 저장된 문자열을 모두 소문자로 변환하여 반환(원본은 변하지 않음)
		System.out.println("str6 = "+str6.toLowerCase());
		System.out.println("\n=========================================\n");
		
		
		String str7="		홍	길	동		";
		System.out.println(str7);
		//★String.trim() : String 객체에 저장된 문자열의 //앞, 뒤(문자 사이는 해당x)에 존재하는 모든 공백을 제거//한 후 반환
		System.out.println(str7.trim());
		System.out.println("\n=========================================\n");
		
		
		String str8="	임	꺽	정	";
		System.out.println(str8);
		//String.replace(String regEx, String replacement)
		//ㄴ String 객체에 저장된 문자열에서 검색 문자열(정규표현식)을 찾아 치환 문자열로 변경하여 반환
		System.out.println(str8.replace("	", "").replace("꺽", "걱"));
		System.out.println("\n=========================================\n");

		
		String str9="010-9000-6092";
		System.out.println("전화번호 : "+str9);
		
		//☆String.split(String regEX)
		//ㄴ String 객체에 저장된 문자열에서 매개변수에 저장된 문자열(정규표헌식)로 구분 분리하여 문자열 배열로 반환하는 메소드 -> 구분문자 필요
		//ㄴ 정규표현식에서 사용되는 메타문자를 일반문자로 처리하기 위해 \\를 사용하여 회피문자로 처리하여 표현(\\, \t \" \\* 등)
		String[] numArray=str9.split("-");
		System.out.println("처음 전화번호 : "+numArray[0]);
		System.out.println("중간 전화번호 : "+numArray[1]);
		System.out.println("끝 전화번호 : "+numArray[2]);
		System.out.println("\n=========================================\n");
		
		
		//★String substring(int beginIndex, int endIndex)
		//ㄴ String 객체에 저장된 문자열에서 시작첨자(문자포함)부터 종료첨자(문자미포함)까지의 문자열을 분리하여 반환
		System.out.println("처음 전화번호 : "+str9.substring(0, 3));
		System.out.println("중간 전화번호 : "+str9.substring(4, 8));
		System.out.println("끝 전화번호 : "+str9.substring(9)); // 매개변수에 시작첨자만 전달한 경우 문자열의 마지막까지 반환
		System.out.println("\n=========================================\n");
		
		
		//String.valueOf(Object obj) : 매개변수로 전달된 값을 문자열(String 객체)로 변환하여 반환
		//ㄴ " "+값 또는 값+" " 형식으로 값을 문자열로 결합하여 변환 가능
		String numString=100+""; // == String numString=String.valueOf(100)+"";
		
		System.out.println(numString);
		System.out.println("\n=========================================\n");
	}//main
}//class
