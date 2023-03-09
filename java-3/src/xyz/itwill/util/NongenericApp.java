package xyz.itwill.util;


//Object 클래스로 필드가 선언된 클래스로 객체를 생성하여 사용하는 프로그램
//ㄴ Object 클래스의 필드에 모든 클래스의 객체를 전달하여 저장 가능
//ㄴ Object 클래스의 필드에 저장된 객체를 반환받아 사용할 경우 반드시 명시적 객체 형변환 필요
//ㄴ 명시적 객체 형변환 중 ClassCastException 방지를 위해 instanceof 연산자 사용
public class NongenericApp {
	public static void main(String[] args) {
		
		NonGeneric nonGeneric1=new NonGeneric();
		
		//Integer 객체를 Object 클래스의 매개변수로 전달받아 Object 클래스의 필드값 변경
		nonGeneric1.setField(100); //오토박싱
		
		//★필드값은 Object 클래스 타입의 객체로 반환되므로
		//★반드시 명시적 객체 형변환을 해야 자식클래스 객체의 메소드 호출 가능
		//ㄴ 이 과정에서 ClassCastExcetion 주의
		Integer returnObject1=(Integer)nonGeneric1.getField();
		System.out.println("필드값 = "+returnObject1);
		System.out.println("\n======================================\n");
		
		
		NonGeneric nonGeneric2=new NonGeneric();
		
		//Double 객체를 Object 클래스의 매개변수로 전달받아 Object 클래스의 필드값으로 변경
		nonGeneric2.setField(12.34);//오토박싱

		//명시적 객체 형변환을 잘못할 경우 ClassCastException 발생
		// => instanceof 연산자를 사용하여 명시적 객체 형변환 전에 검증
		if(nonGeneric2.getField() instanceof Double) {
			//Integer returnObject2=(Integer)nonGeneric2.getField();
			Double returnObject2=(Double)nonGeneric2.getField();
			
			System.out.println("필드값 = "+returnObject2);//오토언박싱
		}
		System.out.println("\n======================================\n");
		
		
		NonGeneric nonGeneric3=new NonGeneric();
		
		//String 객체를 Object 클래스의 매개변수로 전달받아 Object 클래스의 필드값 변경
		nonGeneric3.setField("ABC");
		
		String returnObject3=(String)nonGeneric3.getField();
		System.out.println("필드값 = "+returnObject3);
		System.out.println("\n======================================\n");
		
		
		NonGeneric nonGeneric4=new NonGeneric();
		
		//Boolean 객체를 Object 클래스의 매개변수로 전달받아 Object 클래스의 필드값 변경
		nonGeneric4.setField(false);
		
		Boolean returnObject4=(Boolean)nonGeneric4.getField();
		System.out.println("필드값 = "+returnObject4);
		System.out.println("\n======================================\n");
		
	}
}
