package basic;

import java.util.Scanner;

//키보드로 메뉴 중 하나를 선택하여 주문하는 프로그램
//종료 메뉴 선택 전까지 원하는 기능을 계속 제공
//선택 메뉴가 존재하지 않을 경우 에러 메세지 출력 후 재입력


public class MenuApp {
	public static void main(String[] args) {
		
		Scanner scanner=new Scanner(System.in);
		
		System.out.println("<<학생 관리 프로그램>>");
		System.out.println("1. 학생정보 삽입");
		System.out.println("2. 학생정보 변경");
		System.out.println("3. 학생정보 삭제");
		System.out.println("4. 학생정보 검색");
		System.out.println("5. 종료");
		
		while(true) {
			System.out.print("\n메뉴 선택(1~5) : ");
			int menu=scanner.nextInt();
			
			if(menu<0 || menu>5) {
				System.out.println("error");
			}
			if(menu==5) {
				break;
			}
			
			switch(menu) {
			case 1: System.out.println("\n학생정보 삽입"); break;
			case 2: System.out.println("\n학생정보 변경"); break;
			case 3: System.out.println("\n학생정보 삭제"); break;
			case 4: System.out.println("\n학생정보 검색"); break;
			}
			
			scanner.close();
		}
		
		
		
	}
}
