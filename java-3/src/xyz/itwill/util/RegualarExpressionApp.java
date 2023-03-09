package xyz.itwill.util;

import java.util.Scanner;
import java.util.regex.Pattern;

//●정규표현식(Regular Expression) - ★모든 언어에서 사용
//ㄴ 메타문자(Meta Character), 회피문자 (Escape Character) 등을 이용하여 일정한 규칙의 문자열을 표현하는 방법(입력값 검증)

/*              <메타문자>
 ^문자 : 문자 또는 문자열로 시작됨을 의미
 문자$ : 문자 또는 문자열로 종료됨을 의미
 . : 임의의 문자 하나를 표현(\ 문자 표현 불가능)
 [문자1문자2문자3] : 나열된 문자들 중 하나를 의미
 [^문자1문자2문자3] : 나열된 문자들이 아닌 문자 중 하나를 의미
 [문자1-문자2] : 문자1 부터 문자2 까지 범위의 문자 중 하나
 문자열1|문자열2|문자열3 : 나열된 문자열들 중 하나를 의미
 문자열+ : 문자열이 1번 이상 반복됨을 의미
 문자열* : 문자열이 0번 이상 반복됨을 의미
 문자열? : 문자열이 0번 또는 1번 존재함을 의미
 문자열{숫자} : 문자열이 {숫자}만큼 반복됨을 의미
 문자열{숫자1, 숫자2} : 문자열이 숫자1부터 숫자2 범위만큼 반복됨을 의미
 (?!)문자열 : 문자열에서 대소문자를 구분하지 않음을 의미
 (?=문자열) : 문자열이 반드시 포함됨을 의미
 (!=문자열) : 문자열이 반드시 포함되지 않음을 의미
 */

/*             <회피문자>
 \s : 공백이 있는 문자열을 의미 
 \S : 공백이 없는 문자열을 의미 
 \w : 영문자, 숫자, 특수문자(_)의 문자로만 구성된 문자열을 의미
 \W : 영문자, 숫자, 특수문자(_)를 제외한 문자로 구성된 문자열을 의미
 \d : 숫자 형태의 문자로만 구성된 문자열을 의미
 \D : 숫자 형태의 문자로만 구성되지 않은 문자열을 의미
 \메타문자 : 메타문자를 일반문자로 표현함을 의미 -ex) \. = .문자
 */

//사용자에게 키보드로 입력값을 제공받아 형식에 맞는 값을 비교하여 출력하는 프로그램
//ㄴ 비정상적인 값을 입력한 경우 에러메세지를 출력하고 프로그램 종료
public class RegualarExpressionApp {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		/*
		//아이디는 영문자로 시작되며 영문자, 숫자, 특수문자(_)의 조합으로 6~20범위의 문자수를 값으로 입력받아 사용
		//값을 입력받아 사용하기 위한 규칙
		System.out.print("아이디 입력 >> ");
		String id=scanner.nextLine();
		
		if(id==null || id.equals("")) { //사용자 입력값이 없는 경우
			System.out.println("[에러]아이디를 반드시 입력해 주세요.");
			System.exit(0);
		}
		
		//아이디 관련 정규표현식을 저장
//		String idReg="^[a-zA-Z][a-zA-Z0-9_]{5,19}$"; //영문자로 시작되고 영문자,숫자,언더바의 조합으로 이루어짐
		String idReg="^[a-zA-Z]\\w{5,19}$";
		//Pattern 클래스 : 정규표현식을 이용하기 위한 기능을 제공하는 클래스
		//★Pattern.matches(String regex, CharSequence input)
		//ㄴ 정규표현식과 입력값을 전달받아 입력값이 정규표현식과 다른경우 false, 같을경우 true 반환
		if(!Pattern.matches(idReg, id)) { //입력값이 정규표현식과 다른 경우
			System.out.println("[에러]아이디를 형식에 맞게 입력해주세요.");
			System.exit(0);
		}
		System.out.println("[메세지]정상적인 아이디를 입력했습니다.");
		*/
		
		/*
		//비밀번호는 영문자, 숫자, 특수문자가 반드시 하나 이상 포함되며 8~30 범위의 문자수를 입력받아 사용
		System.out.print("비밀번호를 입력해주세요 >> ");
		String password=scanner.nextLine();
		
		if(password==null || password.equals("")) { //사용자 입력값이 없는 경우
			System.out.println("[에러]비밀번호를 반드시 입력해 주세요.");
			System.exit(0);
		}
		
		String pswdReg="^(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[!@#$%^&*_-]).{8-30}$";
		
		if(!Pattern.matches(pswdReg, password)) {
			System.out.println("[에러]비밀번호를 형식에 맞게 입력해주세요.");
			System.exit(0);
		}
		System.out.println("[메세지]정상적인 비밀번호를 입력했습니다.");
		*/
		
		//이메일은 [아이디@도메인] 형식으로 입력
		System.out.print("이메일을 입력해주세요 >> ");
		String email=scanner.nextLine();
		
		if(email==null || email.equals("")) { //사용자 입력값이 없는 경우
			System.out.println("[에러]이메일을 반드시 입력해 주세요.");
			System.exit(0);
		}
		
		String emailReg="^([a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+)*$";
		
		if(!Pattern.matches(emailReg, email)) {
			System.out.println("[에러]이메일을 형식에 맞게 입력해주세요.");
			System.exit(0);
		}
		System.out.println("[메세지]정상적인 이메일을 입력했습니다.");
		
		scanner.close();
	}
}
