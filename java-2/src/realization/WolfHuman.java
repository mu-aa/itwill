package realization;

//클래스 선언 시 기존 클래스를 상속받기 위해 extends 키워드 사용(단일상속)
//클래스 선언 시 기존 인터페이스를 상속받기 위해 implements 키워드 사용(다중상속)
//ㄴ 인터페이스를 상속받은 클래스는 인터페이스에 선언 된 모든 추상 메소드를 반드시 오버라이드 선언 해야함 -> 실체화(Realization)
public class WolfHuman extends Human/*기본적으로 Human 값을 이용*/ implements Wolf/*실체화 해서 가져다 쓸 수 있음*/{

	@Override	//실체화
	public void cryLoudly() {
		System.out.println("[늑대]큰 소리로 울부짖을 수 있는 능력");
	}

	@Override	//실체화
	public void fastWalk() {
		System.out.println("[늑대]네 발로 빠르게 달릴 수 있는 능력");
	}
	
	public void change() {
		System.out.println("[늑대인간]변신할 수 있는 능력");
	}
	
	
	
	
}//class
