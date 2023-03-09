package xyz.itwill.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

//							Synchronized 되어있지않음┐	       ┌Synchronized 되어있음(멀티 스레드에 이용) - 거의 안 씀(DB에 연동이 안 되어있을 때 사용)
//List 인터페이스를 상속받은 자료구조 클래스 - (★ArrayList, Vector), LinkedList 등
//ㄴ List 객체는 요소를 차례대로 저장 - 첨자(Index)를 이용하여 구분 
public class ListApp {
	public static void main(String[] args) {
		List<String> list=new ArrayList<String>();
		
		//List.add(E element) : List 객체에 요소를 추가하는 메소드
		list.add("홍길동"); //index:0
		list.add("임꺽정"); //index:1
		list.add("전우치"); //index:2
		list.add("일지매"); //index:3  ...
		System.out.println("list = "+list); //참조변수 호출 시에는 toString() 생략가능
		System.out.println("\n===============================================================\n");

		
		//List 객체에는 중복되는 값의 객체도 요소로 저장 가능
		list.add("임꺽정");
		System.out.println(list);
		System.out.println("\n===============================================================\n");
		
		
		//★List.size() : List 객체에 저장된 //요소의 갯수//를 반환하는 메소드
		System.out.println("요소의 갯수 = "+list.size());
		System.out.println("\n===============================================================\n");
		
		
		//★List.get(int index) : List 객체에 저장된 요소 중 //첨자 위치의 요소를 반환//하는 메소드
		System.out.println("3번째 요소에 저장된 값 = "+list.get(2));
		System.out.println("\n===============================================================\n");

		
		//List.add(int index, E element) : List 객체에 원하는 첨자 위치에 요소를 삽입하는 메소드
		list.add(4,"장길산");
		System.out.println("list = "+list);
		System.out.println("\n===============================================================\n");
		
		
		//List.remove(E element) : List 객체에 저장된 요소를 제거하는 메소드
		//ㄴ 매개변수로 전달받은 객체 중 같은 요소가 여러개인 경우 첫번째 요소를 제거하는 메소드
		//List remove(int index) : List 객체에 저장된 요소 중 원하는 첨자 위치의 요소를 제거하는 메소드
		list.remove("임꺽정");
		list.remove(4);
		System.out.println("list= "+list);
		System.out.println("\n===============================================================\n");
		
		
		//List.set(int index) : List 객체에서 원하는 첨자 위치의 요소를 변경하는 메소드
		list.set(1, "임걱정");
		System.out.println("list = "+list);
		System.out.println("\n===============================================================\n");
		
		
		//List 객체에 저장된 요소에 대한 일괄 처리 - 일반 for 구문 사용
		for(int i=0;i<list.size();i++) {  //IndexOutOfBoundsException 발생 주의
			System.out.print(list.get(i)+" ");
		}
		System.out.println();
		System.out.println("\n===============================================================\n");

		
		//List 객체에 저장된 요소에 대한 일괄 처리 - Iterator 객체 사용
		//List.iteractor() : List 객체에 저장된 요소를 반복 처리할 수 있는 Iterator 객체를 반환하는 메소드
		Iterator<String> iterator=list.iterator();
		
		while(iterator.hasNext()) {
			System.out.print(iterator.next()+" ");
		}
		System.out.println();
		System.out.println("\n===============================================================\n");
		
		
		//List 객체에 저장된 요소에 대한 일괄 처리 - 향상된 for 구문 사용
		for(String temp:list) {
			System.out.print(temp+" ");
		}
		System.out.println();
		System.out.println("\n===============================================================\n");
		
		
		//Collections 클래스 : 자료구조 관련 클래스의 객체 요소에 대한 처리 기능을 메소드로 제공하는 클래스
		Collections.sort(list); //오름차순 정렬(ㄱ~ㅎ)
		System.out.println(list);
		System.out.println("\n===============================================================\n");
		
		
		list.clear(); // List 객체에 저장된 모든 요소를 제거하여 초기화 처리하는 메소드
		System.out.println(list);
		System.out.println("\n===============================================================\n");
		
		//List.isEmpty() : List 객체에 저장된 요소가 없을경우 True, 있을경우 false를 반환하는 메소드
		if(list.isEmpty()) {
			System.out.println("List 객체에 저장된 요소가 하나도 없습니다.");
		}
		System.out.println("\n===============================================================\n");
		
		
		//★Arrays.asList(E... element) : 0개 이상의 요소가 저장된 List 객체를 생성하여 반환하는 메소드(Array->List 변환)
		List<Integer> numberList=Arrays.asList(10,20,30,40,50);
		System.out.println(numberList);
		System.out.println("\n===============================================================\n");
	}
}
