package oop;

import java.util.Arrays;

//배열 요소값을 오름차순 정렬되도록 저장하고 출력하는 프로그램 작성
//절차지향 프로그래밍

public class ArraySortApp {
	public static void main(String[] args) {
		/*     절차지향적 프로그래밍
		 * 
		 * int[] array= {30,50,10,40,20};
		 * 
		 * System.out.print("정렬 전 >> ");
		 * 
		 * for(int num:array) { System.out.print(num+" "); }
		 * 
		 * System.out.println();
		 * 
		 * for(int i=0;i<array.length-1;i++) { for(int j=i+1;j<array.length;j++) {
		 * if(array[i]>array[j]) { int temp=array[i]; array[i]=array[j]; array[j]=temp;
		 * } } }
		 * 
		 * System.out.print("정렬 후 >> ");
		 * 
		 * for(int num:array) { System.out.print(num+" "); }
		 */
		
		
//		객체지향적 프로그래밍(OOP)  --  추상화, 캡슐화, 다형성, 상속성
//		현실 세계에 존재하는 대상을 모델링(설계)하여 클래스로 작성하고 클래스로 객체를 생성하여 객체의 요소(메소드 등)로 프로그램을 작성하는 방법
//		ㄴ 객체 모델링(Object Modeling) : 현실 세계의 대상을 //속성, 행위//로 구분해 설계
//		ㄴ 추상화(Abstraction) : 객체 모델링 한 대상을 클래스(필드(속성), 메소드(행위))로 선언
//		ㄴ 클래스 배포 가능(절차지향과의 가장 큰 차이) : 생산성, 유지보수 효율성 증가 
		
		int[] test= {30,50,10,40,20};
		
		//Arrays 클래스 : 배열의 요소값을 처리
		//Arrays.toString(Obejct[] array) : 매개변수(괄호)를 통해 배열을 전달받아 배열의 모든 요소값을 문자열로 변환하여 반환 
		System.out.println("정렬 전 >> "+Arrays.toString(test)); // = print
		
		Arrays.sort(test);   //매개변수(괄호)를 통해 배열을 전달받아 배열의 요소값을 오름차순 정렬하여 저장
		System.out.println("정렬 후 >> "+Arrays.toString(test));
		
	}//
}//
