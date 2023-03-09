package basic;
/*
 switch : 값을 비교하여 명령을 선택 실행,
 		  switch의 값을 case에 작성된 값과 비교하여 같을 경우의 위치로부터 모든명령을 실행, 아닐경우 하위 명령 비교 진행
 		  case의 값은 반드시 리터럴만 사용 가능하며 중복 선언은 불가능 (ex. case1, case2 ...)
 		  모든 값이 다를 경우 default에 작성된 명령 실행(else와 같은 원리)
 		  break를 만나면 switch 강제종료
 ㄴ 형식)
  switch(비교대상[변수 또는 연산식, 실수x]) {
 		case 값1: 명령; 명령;
 		case 값2: 명령; 명령; ... [break;]
		...
		[default: 명령;] - 생략가능
 }


*/
public class SwitchApp {
	public static void main(String[] args) {
		
		int choice=1;  // switch와 case의 값이 모두 다른 경우 default 위치의 명령 실행
		
		switch(choice) {
		case 1:
			System.out.println("수성으로 이동");
		case 2:
			System.out.println("금성으로 이동"); break;
		case 3:
			System.out.println("화성으로 이동"); break;
		default:
			System.out.println("지구로 이동");
		}
		System.out.println("\n===================================\n");
		
		
		int score=85;
		String grade="";
		
		if(score>=0 && score<=100) {
			System.out.println("내 점수 : "+score);
			switch(score/10) {  // 잘 안 씀 if 쓰셈
			case 10:
			case 9: grade="A"; break;
			case 8: grade="B"; break;
			case 7: grade="C"; break;
			case 6: grade="D"; break;
			default: grade="F";
			}
			System.out.println("내 학점 : "+grade);
		} else {
			System.out.println("ERROR");
		}
		System.out.println("\n===================================\n");
		
		String kor="둘",eng="";
		switch(kor) {
		case "하나": eng="One"; break;
		case "둘": eng="Two"; break;
		case "셋": eng="Three"; break;
		}
		System.out.println("[결과]"+kor+" = "+eng);
		System.out.println("\n===================================\n");
	}
}
