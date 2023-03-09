package xyz.itwill.other;

import xyz.itwill.access.ProtectedMember;

public class ProtectedMemberOtherInheritanceUse extends ProtectedMember{
	public void run() {
		//상속 받으면 사용 가능
		num=100;
		display();
	}
	
}
