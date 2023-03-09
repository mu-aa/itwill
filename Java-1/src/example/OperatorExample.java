package example;

public class OperatorExample {
	public static void main(String[] args) {
		//245678초를 일시분초 형식으로 변환하여 출력하세요.
		
		int time=245678, oneDay=86400, oneHour=3600, oneMin=60;
		int day=time/oneDay, 
			hour=(time%oneDay)/oneHour,
			min=((time%oneDay)%oneHour)/oneMin, 
			sec=((time%oneDay)%oneHour)%oneMin ;
		
		System.out.print(day+"일 ");
		System.out.print(hour+"시 ");
		System.out.print(min+"분 ");
		System.out.println(sec+"초");
		System.out.println("===============================================");
		
		
		
		//한대의 가격이 1억 5천원만인 비행기를 20대 구매할 경우 지불해야될 금액을 계산하여 출력하세요. 
		//단, 15대 이상 구매할 경우 1대당 25%의 할인율을 적용하여 계산하세요.

		long plane=150_000_000;
		int buy=20;
		double discount=0.75;
		System.out.print(buy>=15 ? ((plane*discount)*buy) : plane*buy);
		System.out.println("원");
		System.out.println("===============================================");
	}
}