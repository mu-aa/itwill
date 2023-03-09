package enumerate;

public class CompassApp {
public static void main(String[] args) {
	//상수필드값 출력 - 상수필드명을 제공받아 출력
	System.out.println("동 = "+Compass.EAST);
	System.out.println("서 = "+Compass.WEST);
	System.out.println("남 = "+Compass.SOUTH);
	System.out.println("북 = "+Compass.NORTH);
	System.out.println("\n==========================================\n");

	
	//상수필드값 출력 - 대표필드값을 반환받아 출력
	System.out.println("동 = "+Compass.EAST.getValue());
	System.out.println("서 = "+Compass.WEST.getValue());
	System.out.println("남 = "+Compass.SOUTH.getValue());
	System.out.println("북 = "+Compass.NORTH.getValue());
	System.out.println("\n==========================================\n");


	//EnumType.values() : 열거형에 선언된 모든 상수필드를 배열로 변환하여 반환하는 메소드
	//EnumType.ordinal() : 상수필드를 구분하기 위한 첨자(Index)를 반환하는 메소드
	for(Compass temp:Compass.values()) {
		System.out.println(temp+"="+temp.getValue()+" >> "+temp.ordinal());
	}
	System.out.println("\n==========================================\n");
	}
}
