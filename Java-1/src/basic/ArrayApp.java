package basic;
/*
 자료형 : 기본(원시)형(Primitive Type), 참조형(Reference Type)					  숫자형  //   논리형
 - 기본(원시)형 : 값을 표현하기 위한 자료형(byte, short, char, int, long, float, double  //  boolean)
 - 참조형 : 특정 대상(값 들)을 표현하기 위한 자료형(배열(Array), 클래스(Class), 인터페이스(Interface), 열거형(Enum))
 
 기본변수 : 기본(원시)형으로 생성된 변수, 값을 저장하기 위한 변수 ex)int num=10;
 참조변수 : 참조형으로 생성된 변수, 특정 대상의 메모리 주소값을 저장하기 위한 변수 ex)String name="홍길동";         //포인터 -> 해시코드, 메모리 주소
 ㄴ 힙 영역에 생성된 배열 또는 객체의 메모리 주소를 저장하여 접근하기 위해 사용			   
 ㄴ 비교 연산자 사용 = 값이 아닌 메모리 주소 비교	                         		// 그래서 문자를 입력 받지 못했군
 ㄴ 배열 또는 객체를 저장하지 않을 경우 기본값으로 null(존재하지 않는 값을 표현)을 사용  -->> 가변배열에서 선언하지 않은 값의 해시코드가 null


 프로그램에서 사용하는 메모리 영역 : 정적 영역(Static Area)-메소드 영역, 힙 영역(Heap Area), 스택 영역(Stack Area)
 1. 정적 영역(Static Area) : 클래스 파일(xx.class)의 클래스, 인터페이스, 열거형을 읽어 저장하는 메모리 영역
 2. 스택 영역(Stack Area) : 지역변수(기본 또는 참조변수)가 저장되는 메모리 영역  // - FILO(후입선출)
 3. 힙 영역(Heap Area) : 배열 및 객체가 저장되는 메모리 영역 - new 연산자 사용
 ㄴ 다른 영역과는 다르게 식별자 사용 불가능 - 참조변수 필요
 ㄴ 메모리가 크고 효율이 좋음(그래서 많이 씀)

 배열(Array) : 같은 자료형의 값들을 여러 개 저장하기 위한 메모리를 할당받기 위한 자료형(참조형)
 ㄴ 일괄처리를 주 목적으로 사용(데이터 처리 : 실시간처리, 일괄처리)
 ㄴ 1차원 배열, 다차원 배열(2차원 배열, 3차원 배열 등..)로 구분
 										//거의 필요없음
 										 
 - 1차원 배열 : 다수의 값을 저장하기 위한 자료형 
 - n차원 배열 : 다수의 n-1차원 배열을 저장하기 위한 자료형
 
 
*/
public class ArrayApp {
	public static void main(String[] args) {
		
		//1차원 배열을 생성하여 참조변수에 생성된 배열의 메모리 주소(HashCode)를 저장
		//형식) 자료형[] 참조변수명=new 자료형[갯수];
		//new 자료형[갯수] : 자료형의 값을 갯수만큼 저장 가능한 배열 생성 - 힙 영역
		//자료형[] 참조변수명 : 1차원 배열의 메모리 주소를 저장하기 위한 참조변수 생성
		//ㄴ자료형 참조변수명[]   <<ㅡ 이것도 가능
		
		  int[] num=new int[3]; // [3] -> 첨자(Index : 0부터 1씩 증가) 기본값(false, 0, null)이 자동으로 저장
	      
	      System.out.println(num);  //자료형@메모리주소(HashCode)  형식으로 출력
	      	      
	      System.out.println("num[0] = "+num[0]);
	      System.out.println("num[1] = "+num[1]);
	      System.out.println("num[2] = "+num[2]);									 // 예외 클래스
//	      System.out.println("num[3] = "+num[3]); // 인덱스 밖의 범위를 호출한 예외(ArrayIndexOutOfBoundsException)
	      System.out.println("\n======================================\n");
	      
	      
	      System.out.println("배열 요소의 갯수 = "+num.length);   // 참조변수.length = 인덱스 갯수
	      System.out.println("\n======================================\n");	  // 2차원 배열 = num[x].length;

	      
	      int index=0;
	      num[index]=10; 
	      num[index+1]=20; // 변수 또는 연산식 응용
	      num[index+2]=30; 
	      System.out.println(num[0]);
	      System.out.println(num[1]);
	      System.out.println(num[2]);
	      System.out.println("\n======================================\n");	      
	      
	      
	      for(int i=0;i<num.length;i++) {  //for 활용 일괄 처리
	    	  num[i]=i;
	    	  System.out.println("num["+i+"] = "+num[i]);
	      }
	      System.out.println("\n======================================\n");
	      
	      
	      int[] su=new int[] {10,20,30};  //블럭 안에 나열된 초기값 만큼 요소를 가진 배열 생성(갯수 지정x), 초기값 지정 가능
	     
	      for(int i=0;i<su.length;i++) {
	    	  System.out.println(su[i]);
	      }
	      System.out.println("\n======================================\n");

	      
	      int[] su2= {11,22,33};          //이렇게도 만들 수 있음(약식) - 정석대로 하자
	      // int[] s2;
	      // su2={11,22,33};  --> 미리 만들어놓고 배열 선언 불가능
	     
	      // ★★배열 일괄처리 - 향상된 for문★★                                 ㅡㅡ> 배열 오름차순 알고리즘때 활용?
	      for(int temp:su2) {  			  // for(자료형 변수명:참조변수) { 명령; 명령; ... };
	    	  System.out.println(temp);   // 참조변수에 저장된 배열의 요소값을 커서(Cursor)를 사용하여 차례대로 제공받아 변수에 저장하여 반복 처리
	      }								  // 배열의 모든 요소값을 제공받은 후 반복문 종료
	      								  // 계산, 출력만 가능(입력 x)
	      System.out.println("\n======================================\n");
	    
	      
	      int[] array = {54,70,64,87,96,21,65,76,11,34,56,41,77,80};  
	      int tot=0,cnt=0;
	      for(int temp:array) {       
	    	  tot+=temp;                //배열 요소들의 합과 범위 내의 요소 개수
	    	  if(temp>=30&&temp<=60) {  //                   ㄴ 통계에서 사용
	    		  cnt++;
	    	  }
	      }
	      System.out.println("합 = "+tot);
	      System.out.println("\n30 ~ 60 범위 요소의 갯수 = "+cnt);
	      System.out.println("\n======================================\n");
	}
}
