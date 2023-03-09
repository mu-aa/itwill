package nested;

public class OuterThree {
	private int outerNum;
	
	public OuterThree() {
		// TODO Auto-generated constructor stub
	}

	public OuterThree(int outerNum) {
		super();
		this.outerNum = outerNum;
	}

	public int getouterNum() {
		return outerNum;
	}

	public void setouterNum(int outerNum) {
		this.outerNum = outerNum;
	}
	
	public void displayouter() {
		System.out.println("outerNum = "+outerNum);
	}
	
	
	public void local() {   // 내가 쓸 일 별로 없음
		//로컬 클래스(Local Class) : 메소드 내부에 선언된 클래스 - 메소드가 종료되면 로컬 클래스는 자동 소멸(1회용 클래스, 지역변수 개념)
		//ㄴ final 또는 abstract 제한자만 사용하여 선언 가능
		//ㄴ 선언된 메소드에서만 객체를 생성하여 사용 가능
		//ㄴ 선언된 메소드에서만 객체를 생성하여 사용하므로 접근제한자, Setter Getter 메소드 필요X
		//ㄴ static 제한자 사용 불가능
		//ㄴ 비동기식 처리를 위한(게임 등) 스레드 객체를 생성하기 위해 사용
		class InnerThree{
			int innerNum;
			
			void displayInner() {
				System.out.println("innerNum = "+innerNum);
			}
		}//inner
		
		InnerThree innerThree=new InnerThree();
		innerThree.innerNum=200;
		innerThree.displayInner();
		
	}//local
	
}//outer
