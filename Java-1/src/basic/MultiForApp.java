package basic;

public class MultiForApp {
	public static void main(String[] args) {
		
		int cnt=0; // 이동 방법의 개수
		
		for(int i=1;i<=3;i++) {  // A나라       ----- 섬
			for(int j=1;j<=4;j++) {  //B나라     ----- 섬
				cnt++;
				System.out.print("i ="+i+"\tj= "+j);
				System.out.println("\tcnt = "+cnt);
			}
		}
		System.out.println("\n=============================\n");
		

		for(int i=1;i<=4;i++) {   // 행(Row) - 세로
			for(int j=1;j<=7;j++) {  //열(Column) - 가로
				System.out.print("★");
			}
			System.out.println();
		}
		System.out.println("\n=============================\n");
		
		
		for(int i=1;i<=9;i++) { // 구구단
			for(int j=2;j<=9;j++) {
				System.out.print(j+"*"+i+"="+(i*j)+"\t");				
			}
			System.out.println();
		}
		System.out.println("\n=============================\n");
		
		for(int i=1;i<=5;i++) {  //피라미드
			for(int j=1;j<=i;j++) {		
				System.out.print("★");
			}
			System.out.println();
		}
		System.out.println("\n=============================\n");
		
		
		for(int i=5;i>=1;i--) {  //역피라미드
			for(int j=1;j<=i;j++) {		
				System.out.print("★");
			}
			System.out.println();
		}
		System.out.println("\n=============================\n");
		
		
		for(int i=5;i>=1;i--) {  //각자 다른 별 for문 두 개
			for(int j=1;j<=(i-1);j++) {
				System.out.print("☆");
			}
			for(int j=5;j>=i;j--) {
			System.out.print("★");
			}
			System.out.println();
		}
		System.out.println("\n=============================\n");
		
		
		for(int i=1;i<=5;i++) {  //각자 다른 별 if문
			for(int j=1;j<=5;j++) {
				if(i+j>=6) {  // 6이상 좌표(1,5)(2,4 2,5)(3,3 3,4 3,5)(4,2 4,3 4,4 4,5)(5,1 5,2 5,3 5,4 5,5)라고 생각하면 편함
					System.out.print("★");
				} else {
					System.out.print("☆");					
				}
			}
			System.out.println();
		}
		System.out.println("\n=============================\n");
	}
}
