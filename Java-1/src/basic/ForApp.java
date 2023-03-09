package basic;
/*
 for : 반복 횟수가 정해져 있는 경우 사용되는 반복문(Loop Statement)
   ㄴ 형식) for(초기식;조건식;증감식) {명령; 명령; ...}
   ㄴ 초기식 : 변수에 초기값을 저장하는 연산식
   ㄴ 증감식 : 변수값을 증가 또는 감소시키는 연산식
   ㄴ 초기식 -> 조건식 -> 증감식 -> 조건식 -> 증감식(조건식이 거짓이 될 때 까지 반복)
 			    ㄴ조건식이 생략된 경우 무조건 참(true)        ㄴ조건식의 결과가 항상 참인 경우 무한반복
 
 프로그램 흐름 파악 기능 : 디버그(Debug Perspective)
   ㄴ breakpoint 설정 -> [F11] -> Debug Perspective 전환 -> [F6] 코드 한 줄씩 실행 -> 
      프로그램 강제종료(Ctrl+F2, Terminate) -> Java Perspective 전환 -> breakpoint 제거
 
 스레드(Thread) : 명령 실행의 최소 단위(코드 한 줄)
 
 while : 반복 횟수가 정해져 있지 않은 경우 사용
 
*/
public class ForApp {
	public static void main(String[] args) {
		
		System.out.println("Java Programming");
		System.out.println("Java Programming");
		System.out.println("Java Programming");
		System.out.println("Java Programming");
		System.out.println("Java Programming");
		System.out.println("\n============================\n");
		
		
		for(int i=1;i<=5;i++) {
			System.out.println("For Java Programming");	
		}
		System.out.println("\n============================\n");
		
		
		for(int i=5;i>=1;i--) {
			System.out.println("gnimmargorP avaJ");
		}
		System.out.println("\n============================\n");
		
		
		for(int i=2;i<=10;i+=2) {
			System.out.println("JJaavvaa PPrrooggrraammmmiinngg");
		}
		System.out.println("\n============================\n");
		
		
		for(int i=1;i<=5;i++) {
			System.out.print(i+"\t");
		}
		System.out.println("\n\n============================\n");
		
		
		for(int i=5;i>=1;i--) {
			System.out.print(i+"\t");
		}
		System.out.println("\n\n============================\n");
		
		
		for(int i=2;i<=10;i+=2) {
			System.out.print(i+"\t");
		}
		System.out.println("\n\n============================\n");
		

		for(int i=1;i<=10;i++) {
			if(i%2==0) {
				System.out.print(i+"\t");
			}
		}
		System.out.println("\n\n============================\n");
		
		
		int tot=0;
		
		for(int i=1;i<=100;i++) {
			tot+=i;
		}
		System.out.println("합계 : "+tot);
		System.out.println("\n============================\n");
		
		
		int begin=80, end=20, sum=0;
		
		 if(begin>=end) {		//치환 알고리즘(Swap Algorithm)
			System.out.println("치환 전 : "+begin+" "+end);
			int temp=begin;
			begin=end;
			end=temp;
			System.out.println("치환 후 : "+begin+" "+end);
		} if(begin<end) {
			for(int i=begin;i<=end;i++) {
				sum+=i;
			}
		} else { 
			System.out.println("ERROR"); System.exit(0); // 프로그램 강제종료 
		}
		System.out.println(begin+" ~ "+end+" 합계 : "+sum);
		System.out.println("\n============================\n");
		
		
		
		for(int i=1,j=5; i<=3; i++,j--) { //초기식, 증감식 여러개
			System.out.print("i="+i);
			System.out.println("\t"+"j="+j);
		}
		System.out.println("\n============================\n");

		
		{//~~지역변수 활용~~
			int i=1;
		
			for(;i<=4;i++) {
				System.out.print(i+"\t");
			}
			for(;i>=1;i--) {
				System.out.print(i+"\t");
			}
			System.out.println("\n\n============================\n");
		}//~~지역변수 활용~~
		
		for(;;) {	//조건식 생략 시 무조건 참, 무한루프)
			break;
		}
	}
}
