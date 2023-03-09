package nested;

//중첩 클래스(Nested Class) : 클래스(OuterClass) 내부에 다른 클래스(InnerClass)를 선언   --> 보통 이벤트 만들 때 사용
//ㄴ 두 개의 클래스가 밀접한 관계에 있을 때 선언하며 캡슐화를 강화하는데 사용   // 나(외부클래스)만 쓰고 다른 곳에 안 쓸 때 내부클래스로 만듦
public class OuterOne {
	private int outerNum;
	
	public OuterOne() {
		// TODO Auto-generated constructor stub
	}
	
	public OuterOne(int outerNum) {
		super();
		this.outerNum = outerNum;
	}

	public int getouterNum() {
		return outerNum;
	}

	public void setouterNum(int outerNum) {
		this.outerNum = outerNum;
	}
	
	public void displayOuter() {
		System.out.println("outerNum = "+outerNum);
//		외부 클래스에서 내부 클래스의 필드 또는 메소드에 대한 직접적인 참조 불가능 <<
//		System.out.println("innerNum = "+InnerNum); X
		
//		외부 클래스에서는 내부 클래스의 객체를 생성하여 접근제한자에 상관없이(같은 클래스니께)참조 가능 <<
//		필드 또는 메소드 참조 가능
//		InnerOne innerOne=new InnerOne();
//		System.out.println("innerNum = "+innerOne.innerNum); O
	}
	
	
	//● 일반 중첩 클래스 : 컴파일 결과를 [외부클래스$내부클래스.class] 파일로 제공
	//ㄴ 일반 중첩 클래스 내부에서는 static 제한자를 사용하여 필드 또는 메소드 선언이 불가능
	//ㄴ 내부 클래스에서는 외부클래스의 필드 또는 메소드를 접근제한자에 상관없이 참조 가능
	public class InnerOne {
		private int innerNum=10;
		
		public InnerOne() {
			// TODO Auto-generated constructor stub
		}
		
		public InnerOne(int innerNum) {
			super();
			this.innerNum = innerNum;
		}

		public int getInnerNum() {
			return innerNum;
		}

		public void setInnerNum(int innerNum) {
			this.innerNum = innerNum;
		}
		
		public void displayInner() {
//			내부 클래스에서는 외부클래스의 필드 또는 메소드를 접근제한자에 상관없이(같은 클래스니까) 참조 가능
			System.out.println("innerNum = "+innerNum);
//			System.out.println("outerNum = "+outerNum);  == 가능
//			displayOuter();  == 가능
			
		}
		
		
		
	}//InnerOne
}//OuterOne
