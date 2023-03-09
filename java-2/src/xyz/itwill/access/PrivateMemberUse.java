package xyz.itwill.access;

public class PrivateMemberUse {
	public void run() {
		@SuppressWarnings("unused") //안써서 뜨는 경고 무시
		PrivateMember member=new PrivateMember();
		
		//private 접근 제한자로 은닉화 설정 된 필드와 메소드에 접근 할 경우 에러
		/*
		 member.num=100;
		 member.display();
		 */
	}

}
