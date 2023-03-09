package xyz.itwill.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

//                       Synchronized 되어있지않음┐	   ┌Synchronized 되어있음(멀티 스레드에 이용) - 거의 안 씀(DB에 연동이 안 되어있을 때 사용)														
//Map 인터페이스를 상속받은 자료구조 클래스 - HashMap, HashTable, TreeMap, Properties 등
//ㄴ 이름(Key - 식별자)과 값(Value - 객체)을 하나로 묶어 자료구조 클래스의 객체에 저장하여 사용
//ㄴ 엔트리(Entry) : 이름과 값을 하나로 묶어 사용하는 처리 단위
//ㄴ 이름으로 값을 빠르게 검색하여 사용하기 위한 자료구조 클래스
//ㄴ Map 객체의 이름은 Set 객체로 저장되므로 중복X, 순서X
public class MapApp {
	public static void main(String[] args) {
		
		//Map 인터페이스를 상속받은 자식클래스는 이름과 값에 대한 제네릭 2개 전달하여 사용
		Map<Integer, String> map=new HashMap<Integer, String>();
		
		//Map.put(K key, V value) : Map 객체에 엔트리를 추가하는 메소드
		map.put(1000,"홍길동");
		map.put(2000,"임꺽정");
		map.put(3000,"전우치");
		map.put(4000,"일지매");
		map.put(5000,"장길산");
		
		System.out.println("map = "+map); // 참조변수 호출 시엔 toString() 생략 가능
		System.out.println("\n=========================================================\n");
		
		
		//메소드 호출 시 이름(Key)이 중복될 경우 기존값 대신 새로운 값으로 대체
		map.put(2000,"임걱정");
		System.out.println("map = "+map); 
		System.out.println("\n=========================================================\n");
		
		
		//Map.remove(K key) : Map 객체에 저장된 엔트리를 이름(Key)을 이용하여 제거하는 메소드 
		map.remove(4000);
		System.out.println("map = "+map);
		System.out.println("\n=========================================================\n");
		
		//★Map.get(K key) : Map 객체에 저장된 엔트리에서 이름(Key)을 이용하여 값(Value)을
		//검색하여 반환하는 메소드 - 이름으로 저장된 값이 없을 경우 [NULL] 반환
		String name=map.get(1000);
		System.out.println("name = "+name);
		System.out.println("\n=========================================================\n");
		
		
		//Map 객체에 저장된 엔트리에 대한 일괄 처리 - Iterator 객체 사용
		//Map.keySet() : Map 객체에 저장된 모든 엔트리의 이름(Key)을 Set 객체로 반환하는 메소드
		Iterator<Integer> iteratorKey=map.keySet().iterator();
		
		while(iteratorKey.hasNext()) {
			Integer key=iteratorKey.next(); //Set 객체에 저장된 이름(Key)만 반환받아 저장
			System.out.println(key+" == "+map.get(key)); // 값(Value)도 따로 호출
		}
		System.out.println("\n=========================================================\n");
		
		
		//Map.Values() : Map 객체에 저장된 모든 엔트리의 값(Value)만 Collection 객체로 반환하는 메소드
		Iterator<String> iteratorValue=map.values().iterator();
		
		while(iteratorValue.hasNext()) {
			System.out.println(iteratorValue.next());
		}
		System.out.println("\n=========================================================\n");
		
		
		//Map 객체에 저장된 엔트리에 대한 일괄 처리(이름 - Key) - 향상된 for 사용
		for(Integer key:map.keySet()) {
			System.out.println(key+" = "+map.get(key));
		}
		System.out.println("\n=========================================================\n");
		
	
		//Map 객체에 저장된 엔트리에 대한 일괄 처리(값 - Value) - 향상된 for 사용
		for(String value:map.values()) {
			System.out.println(value+" ");
		}
		System.out.println("\n=========================================================\n");
	}
}
