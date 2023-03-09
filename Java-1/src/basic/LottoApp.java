package basic;

//1~45 범위의 난수를 6개 제공받아 출력하는 프로그램
// => 6개 난수는 서로 중복되지 않도록 작성하며 오름차순 정렬하여 출력
//정렬(Sort) : 값을 순서대로 나열하는 기능 - 오름차순 정렬(AscendingSort), 내림차순 정렬(DescendingSort)
public class LottoApp {
	public static void main(String[] args) {
		
		//6개의 정수난수를 저장하기 위한 배열 선언
		int[] lotto=new int[6];
		
		for(int i=0;i<lotto.length;i++) {
			
			while(true) {
				lotto[i]=(int)(Math.random()*45)+1;
					
				// => false : 미중복, true : 중복
				boolean result=false;
				
				for(int j=0;j<i;j++) { // 기존 난수값을 j로 선언해서 arrayException을 피함
					if(lotto[i]==lotto[j]) {//lotto[i] : 새로운 난수값, lotto[j] : 기존 난수값
						result=true;
						break;
					}
				}
				if(!result) break;
			}
		}
		
		//배열의 모든 요소값 오름차순 출력
		//선택 정렬 알고리즘(Selection Sorting Algorithm)
		
		for(int i=0;i<lotto.length-1;i++) {  // 맨 뒤에건 바꿀 다음 요소가 없으니 length-1
			for(int j=i+1;j<lotto.length;j++) {  // j는 i 다음거 저장할거라 i+1(비교,바꾸기 대상), 배열 끝까지 length 해서 다른 숫자들도 비교
				
				if(lotto[i]>lotto[j]) {  // 비교
					
					int temp=lotto[i];
					lotto[i]=lotto[j];  // 순서 바꾸기
					lotto[j]=temp;
				}
			}
		}
		
		System.out.print("행운의 숫자 >> ");
		for(int number:lotto) {
			System.out.print(number+" ");
		}
		System.out.println();
		
	}
}