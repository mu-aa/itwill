package example;

public class LottoReview {
	public static void main(String[] args) {
		
		//1~45 범위의 난수를 6개 제공받아 출력하는 프로그램
		// => 6개 난수는 서로 중복되지 않도록 작성하며 오름차순 정렬하여 출력
		//정렬(Sort) : 값을 순서대로 나열하는 기능 - 오름차순 정렬(AscendingSort), 내림차순 정렬(DescendingSort)
		
		//1~45 난수6개
		int[] lotto=new int[6];
		boolean dupe=false;
	
			for(int i=0;i<lotto.length;i++) {
				lotto[i]=(int)((Math.random()*45)+1); //난수 입력
				
				for(int j=0;j<i;j++) {
					
					if(lotto[i]==lotto[j]) {  //중복 검사
						System.out.println("dupe");
						dupe=true;
						break;
					}
					if(!dupe) {
						break;
					}
				}
				
			}
		
		
		
		for(int i=0;i<lotto.length-1;i++) {  // 오름차순 정렬 알고리즘
			for(int j=i+1;j<lotto.length;j++) {
				if(lotto[i]>lotto[j]) {
					int temp=lotto[i];
					lotto[i]=lotto[j];
					lotto[j]=temp;
				}
			}
		}
		
		System.out.print("Lotto. "); // 출력
		for(int i=0;i<lotto.length;i++) {
			System.out.print(lotto[i]+" ");
		}
		
		
		
		
		
	}//
}//
