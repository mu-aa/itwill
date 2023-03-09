package basic;

/* 
 while : 명령에 대한 반복 횟수가 불확실한 경우 사용
 ㄴ while(조건식) { 명령; 명령; ... }
 ㄴ 조건식의 결과가 참인 경우 블럭 안의 명령을 반복 실행, 거짓인 경우 종료
 ㄴ 조건식 생략 불가능
 ㄴ 조건식이 처음부터 거짓일 경우 블럭 안의 명령 미실행

 do { 명령; 명령; ... } while(조건식);
 ㄴ 조건식의 결과가 처음부터 거짓이어도 반드시 한 번은 실행
 
 i++와 ++i처럼 명령 실행 순서의 차이?
*/

public class WhileApp {
	public static void main(String[] args) {
		
		int i=1;
		
		while(i<=5) {  // 5번 출력
			System.out.println("Java Programming");
			i++;
		}
		System.out.println("\n================================\n");
		
		
		int j=1, tot=0;
		
		do {  //1~100 합계
			tot+=j;
			j++;
		} while(j<=100);
		System.out.println("합계 : "+tot);
		System.out.println("\n================================\n");
		
		
		int square=1,cnt=0;
		
		while(square<=500) { // 사각형 500개 이상 나올 때 까지 종이 접기
			cnt++;
			square*=2;
		}
		System.out.println("횟수 : "+cnt+"\t사각형 : "+square);
		System.out.println("\n================================\n");

		
		int x=0, sum=0;
		
		while(sum<300) {
			x++;
			sum+=x;
		}
		System.out.println("1~"+x+" 까지의 합계 : "+sum);
		System.out.println("\n================================\n");
	}
}
