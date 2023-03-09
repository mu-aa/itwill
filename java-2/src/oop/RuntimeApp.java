package oop;

public class RuntimeApp {
	public static void main(String[] args) {
		
		// Runtime : Java 프로그램을 실행하는 JVM 관련 정보를 저장하기 위한 클래스
		// ㄴJVM은 하나이기 때문에 객체 여러 개에 담을 필요가 없음  !=  Runtime runtime1=new Runtime();
		// ㄴ 생성자가 은닉화 되어있어 new 연산자로 객체 생성 불가능
		// ㄴ 프로그램에 객체를 하나만 제공 가능한 클래스 - 싱글톤 클래스(Singleton Class)
		
		Runtime my1=Runtime.getRuntime();
		Runtime my2=Runtime.getRuntime();
		// Runtime.getRuntime() : 런타임 객체를 반환하는 정적 메소드 - 클래스를 사용하여 호출
		// ㄴgetRuntime() 메소드를 여러 번 호출해도 같은 객체 하나만을 반환 
		
		System.out.println("runtime1 = "+my1);
		System.out.println("runtime2 = "+my2);
		System.out.println("\n======================================\n");

		//Runtime.totalMemory() : JVM이 사용 가능한 전체 메모리의 크기(Byte)를 반환하는 메소드
		//Runtime.freeMemory() : JVM이 사용 가능한 여유 메모리의 크기(Byte)를 반환하는 메소드
		
		// 싱글톤 클래스는 객체를 반환받아 참조변수에 저장하여 사용하지 않고 객체를 반환받아 직접 메소드로 호출하는 것을 권장
		
//		System.out.println("청소 전 JVM 사용 메모리 크기 = "+(my1.totalMemory()-my1.freeMemory())+"Byte");
		System.out.println("청소 전 JVM 사용 메모리 크기 = "+(Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory())+"Byte");
//		ㄴ 굳이 참조변수를 선언하지 않고 그냥 사용하는게 나음(어차피 값은 변하지 않고 하나이니까)
		
		//Runtime
//		Runtime.getRuntime().gc();  // 메모리를 청소하는 가비지 콜렉터(Garbage Collector)를 호출
		System.gc(); // 가비지 콜렉터(Garbage Collector) 실행하는 정적 메소드
		System.out.println("청소 후 JVM 사용 메모리 크기 = "+(Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory())+"Byte");
		System.out.println("\n======================================\n");
	}
}
