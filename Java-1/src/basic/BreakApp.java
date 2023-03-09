package basic;
/*
 
 
 break : switch 또는 반복문을 강제 종료하기 위해 사용하는 제어문
 
 
*/
public class BreakApp {
	public static void main(String[] args) {
		
		for(int i=1;i<=5;i++) {
			if(i==3) {
				break;
			}
			System.out.print(i+"\t");
		}
		System.out.println();
		System.out.println("\n=================================\n");

		
		for(int i=1;i<=5;i++) {
			for(int j=1;j<=5;j++) {
				if(j==3) break; // j==3일 경우 강제종료
				System.out.println("i= "+i+"\tj= "+j);
			}
			System.out.println();
		}
		System.out.println("\n=================================\n");
		
		
//		반복문에서 반복문을 구분하기 위한 식별자(라벨명) 선언 가능
//		ㄴ 형식) 라벨명:반복문

		loop:
			for(int i=1;i<=5;i++) {
				for(int j=1;j<=5;j++) {
					if(j==3) {
						break loop;
					} //break 라벨명 = 라벨명으로 묶인 반복문 종료
					System.out.println("i= "+i+"\tj= "+j);
					}
				System.out.println();
				}
		System.out.println("\n=================================\n");	
	}
}
