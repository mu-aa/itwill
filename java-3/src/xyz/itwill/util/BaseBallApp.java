package xyz.itwill.util;

import java.util.Random;
import java.util.Scanner;

//숫자야구게임 : 정수난수(0~9)를 3개 제공받아 키보드로 입력하여 맞추는 게임
//ㄴ 난수와 키보드 입력값은 0~9범위 3개의 정수값으로, 서로 다르며 0으로 시작 불가능
//ㄴ 키보드 입력값이 형식에 맞지 않은 경우 재입력
//ㄴ 난수와 입력값을 서로 비교하여 동일한 정수값이 존재할 경우 위치가 같으면 스트라이크
//ㄴ 다르면 볼로 처리하여 계산
//ㄴ 스트라이크가 3개면 성공 메세지 출력 후 프로그램 종료, 아니라면 스트라이크와 볼의 갯수 출력
//ㄴ 키보드 입력 기회는 15번 제공하며 맞추지 못한 경우 정답(난수) 출력

public class BaseBallApp {
	public static void main(String[] args) {
		Random random=new Random();
		
		//0~9 범위의 정수값 3개를 저장하기 위한 배열 선언 - 난수값을 저장하기 위한 배열
		int[] dap=new int[3];
		
		//규칙에 맞는 난수값을 배열 요소에 저장하도록 처리하는 반복문
		while(true) {
			for(int i=0;i<dap.length;i++) {
				dap[i]=random.nextInt(10);//0~9 범위의 난수값을 배열 요소에 저장
			}
			
			//규칙에 맞는 난수값인 경우에만 반복문 종료
			if(dap[0]!=0 && dap[0]!=dap[1] && dap[1]!=dap[2] && dap[2]!=dap[0]) break;
		}
		
		Scanner scanner=new Scanner(System.in);

		//0~9 범위의 정수값 3개를 저장하기 위한 배열 선언 - 키보드 입력값을 저장하기 위한 배열
		int[] num=new int[3];
		
		//정답 관련 상태정보를 저장하기 위한 변수
		boolean result=false;

		//키보드로 정수값을 입력받기 위한 기회를 제공하는 반복문
		// => 키보드 입력값을 난수값과 비교하여 결과 출력
		for(int cnt=1;cnt<=15;cnt++) {
			//스트라이크와 볼의 갯수를 저장하기 위한 변수 선언
			int strike=0, ball=0;	

			//키보드 입력값에 대한 검증을 위한 반복문
			loop:
			while(true) {
				System.out.print(cnt+"번째 입력 >> ");
				String input=scanner.nextLine();
				
				if(input.length()!=3) {//비정상적인 값이 입력된 경우
					System.out.println("[에러]3자리의 숫자만 입력 가능합니다.");
					continue;
				}
				
				//입력된 문자열에서 문자를 추출하여 배열 요소에 저장
				// => 문자열의 문자를 추출하여 정수값으로 변환하여 배열 요소에 저장
				for(int i=0;i<num.length;i++) {
					//문자코드(CharacterCode) - '0' : 48 ~'9' : 57
					//ex)'4'-'0' = 52-48 = 4 
					num[i]=input.charAt(i)-'0';
					
					if(num[i]<0 || num[i]>9) {//비정상적인 값이 입력된 경우
						System.out.println("[에러]숫자값만 입력 가능합니다.");
						continue loop;
					}
				}

				//규칙에 맞는 입력값인 경우에만 반복문 종료
				if(num[0]!=0 && num[0]!=num[1] && num[1]!=num[2] && num[2]!=num[0]) break;
				
				System.out.println("[에러]0으로 시작되거나 중복된 숫자가 존재합니다.");
			}
			
			//난수값과 키보드 입력값을 비교하여 스트라이크와 볼을 구분하여 계산
			// => 난수값과 키보드 입력값을 교차 비교하도록 중첩된 for 구문 사용
			for(int i=0;i<dap.length;i++) {//난수값을 처리하기 위한 반복문
				for(int j=0;j<num.length;j++) {//키보드 입력값을 처리하기 위한 반복문
					if(dap[i]==num[j]) {//배열의 요소값이 같은 경우
						if(i==j) {//배열 요소의 위치가 값은 경우
							strike++;
						} else {
							ball++;
						}
					}
				}
			}
			
			if(strike==3) {
				System.out.println("[메세지]축하합니다."+cnt+"번만에 맞췄습니다.");
				result=true;
				break;
			}
			
			System.out.println("[결과]"+strike+"스트라이크 "+ball+"볼");
		}
		 
		if(!result) {//제공된 기회동안 정답을 맞추지 못한 경우
			System.out.print("[메세지]정답을 못 맞췄군요. 정답은 [");
			for(int su:dap) {
				System.out.print(su);
			}
			System.out.println("]입니다.");
		}

		scanner.close();
	
	}//main
}//class
