package xyz.itwill07.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.util.StopWatch;

public class ExecutionTimeAdvice {
	//타겟메소드의 명령이 싱행되는 처리시간을 계산하여 출력하기 위한 메소드 - Around Advice Method
	public Object timeWatchLog(ProceedingJoinPoint joinPoint) throws Throwable {
		/*
		//타겟메소드의 명령 실행전에 동작될 명령 작성
		long startTime=System.currentTimeMillis();
		
		//타겟메소드 호출하여 명령 실행
		Object object=joinPoint.proceed();
	
		//타겟메소드의 명령 실행후에 동작될 명령 작성
		long endTime=System.currentTimeMillis();

		System.out.println(className+" 클래스의 "+methodName+" 메소드 실행 시간 = "+(endTime-startTime)+"ms");
		
		return object;
		*/
		
		//StopWatch 객체 : 시간을 측정하기 위한 기능을 제공하기 위한 객체
		StopWatch stopWatch=new StopWatch();
		
		//stopWatch.start() : 시간 측정을 시작하는 메소드
		stopWatch.start();

		//타겟메소드 호출하여 명령 실행
		Object object=joinPoint.proceed();

		//StopWatch.stop() : 시간 측정을 종료하는 메소드
		stopWatch.stop();
		
		String className=joinPoint.getTarget().getClass().getSimpleName();
		String methodName=joinPoint.getSignature().getName();
		
		
		//StopWatch.getTotalTimeMillis() : 측정된 시간을 ms 단위로 반환하는 메소드 
		System.out.println(className+" 클래스의 "+methodName+" 메소드 실행 시간 = "
				+stopWatch.getTotalTimeMillis()+"ms");
		
		return object;
	}
}