package xyz.itwill.util;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

//1~45범위 난수 6개 제공받아 출력
//ㄴ 6개 난수는 서로 중복되지 않도록 작성, 오름차순 정렬 후 출력
public class LottoSetApp {
	public static void main(String[] args) {
		Set<Integer> lottoSet=new HashSet<Integer>();
		
		Random number=new Random();
		
		while(true) {
			//1~45범위 난수값 Set 객체에 저장(Set은 중복x)
			lottoSet.add(number.nextInt(45)+1);
			
			if(lottoSet.size()==6) break; //6개만 받기
		}
		
		//오름차순 정렬
		
		//Set.toArray(E[] a) : Set 객체를 배열로 변환하여 반환하는 메소드
		Integer[] lotto=lottoSet.toArray(new Integer[0]); //[0] 숫자는 의미 없음
		
		//Arrays.sort(Object[] o) : 매개변수로 배열을 전달받아 배열 요소를 오름차순 정렬
		Arrays.sort(lotto);
		
		//Arrays.toString(Object[] o) : 매개변수로 전달받은 배열 요소를 문자열로 변환하여 반환하는 메소드
		System.out.print("행운의 번호 : "+Arrays.toString(lotto));
	}
}
