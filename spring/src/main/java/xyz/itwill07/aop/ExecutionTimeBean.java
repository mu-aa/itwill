package xyz.itwill07.aop;

//핵심관심모듈
public class ExecutionTimeBean {
	public void one() {
		//System.currentTimeMillis() : 시스템의 현재 날짜와 시간(TimeStamp)을 반환하는 메소드
		//타임스탬프 : 날짜와 시간을 정수값으로 변환한 값 - 날짜와 시간에 대한 연산 목적
		//long startTime=System.currentTimeMillis();
		
		long count=0;
		
		for(long i=1; i<=10000000000L; i++) {
			count++;
		}
		
		System.out.println("count = "+count);
		
		//long endTime=System.currentTimeMillis();
		//System.out.println("ExecutionTimeBean 클래스의 one() 메소드 실행 시간 = "
		//		+(endTime-startTime)+"ms");
	}
	
	public void two() {
		//long startTime=System.currentTimeMillis();
		
		long count=0;
		
		for(long i=1; i<=20000000000L; i++) {
			count++;
		}
		
		System.out.println("count = "+count);
		
		//long endTime=System.currentTimeMillis();
		//System.out.println("ExecutionTimeBean 클래스의 two() 메소드 실행 시간 = "
		//		+(endTime-startTime)+"ms");
	}
}