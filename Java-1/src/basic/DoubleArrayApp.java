package basic;

public class DoubleArrayApp {
	public static void main(String[] args) {
		
		//n차원 배열 : n-1차원 배열들의 모임
		//              2차원->1차원->요소
		//                  행 열       참조변수  해시코드        ㅡㅡㅡㅡㅡㅡㅡㅡ  요소들  ㅡㅡㅡㅡㅡㅡㅡㅡ
		int[][] num=new int[2][3];      //num  ->   [][]   ->  [0][0]  [0][1]  [0][2]     [1][0]  [1][1]  [1][2]
		
		System.out.println(num);  // 2차원 배열(1차원 배열들의 묶음) 해시코드만 나옴
		System.out.println(num[0]); // 1차원 배열(요소들의 묶음) 해시코드만 나옴
		System.out.println(num[1]);
		System.out.println(num[0][0]); // 요소들의 값이 나옴(해시코드 x)
		System.out.println(num[1][0]);
		System.out.println("\n====================================\n");
		
		System.out.println(num.length); // 1차원 배열의 갯수(2차원 배열을 의미)인 2가 나옴
		System.out.println(num[0].length); // 1차원 배열[0][x]의 요소의 갯수인 3이 나옴 [0][0], [0][1], [0][2]
		
		for(int i=0;i<num.length;i++) {  // 행 : 1차원 배열의 갯수(num[2][3]이라면 [2])만큼 반복
			for(int j=0;j<num[i].length;j++) {  // 열 : 1차원 배열의 요소 갯수(num[2][3]이라면 [3])만큼 반복 처리
				System.out.print(num[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println("\n====================================\n");
		
		//                       0,0 0,1 0,2 1,0 1,1 1,2
		int[][] su=new int[][] { {10,20,30},{40,50,60} };
		
		for(int[] array:su) {
			for(int number:array) {
				System.out.print(number+" ");
			}
			System.out.println();
		}
		System.out.println("\n====================================\n");
		
		int[][] value=new int[3][]; // 2차원 배열(1차원 배열들)만 정상적으로 만들고 1차원 배열의 해시코드 값이 null로 저장, 요소X
		//   value[0][] value[1][] value[2][]         ㅡ 가변배열
		//          null       null       null   요소는 아예 생성되지 않고 해시코드 값은 null로 저장
		
		System.out.println("value = "+value);		
		System.out.println("value[0] = "+value[0]);
		System.out.println("value[1] = "+value[1]);
		System.out.println("value[2] = "+value[2]);
//		System.out.println("value[0][0] = "+value[0][0]);
		System.out.println("\n====================================\n");
		//2차원 배열의 참조요소에 1차원 배열을 생성하여 저장
		// => 1차원 배열의 요소의 갯수를 다르게 생성하여 저장 가능 - 가변배열
		
		// 가변배열  ==>>   1차원 배열의 요소들의 갯수가 다른 배열
		value[0]=new int[3];
		value[1]=new int[2];      //위에서 생성되지 않은 요소값들을 만들어줌.
		value[2]=new int[4];      //그로 인해 해시코드값과(원래 지정 안해서 null이었음) 요소(기본값인 0)가 적용
		
		System.out.println("value[0] = "+value[0]);
		System.out.println("value[1] = "+value[1]);
		System.out.println("value[2] = "+value[2]);
		System.out.println("===============================================================");
		
		int[][] doubleArray={{10,20,30},{40,50},{60,70,80,90}};//가변배열 바로 선언 (약식)
		
		for(int[] array:doubleArray) {
			for(int number:array) {
				System.out.print(number+"  ");
			}
			System.out.println();
		}
		System.out.println("===============================================================");
	
		
	
		
	}
}
