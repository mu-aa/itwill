package realization;

//인터페이스는 다른 인터페이스를 상속받아 작성 가능, 다중상속 가능(extends 인터페이스명, 인터페이스명, ...)
public interface BoatCar extends Boat, Car{
	void floating();
}
