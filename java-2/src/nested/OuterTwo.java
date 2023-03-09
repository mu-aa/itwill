package nested;

public class OuterTwo {
	private int outerNum;
	
	public OuterTwo() {
		// TODO Auto-generated constructor stub
	}

	public OuterTwo(int outerNum) {
		super();
		this.outerNum = outerNum;
	}

	public int getOuterNum() {
		return outerNum;
	}

	public void setOuterNum(int outerNum) {
		this.outerNum = outerNum;
	}

	public void displayOuter() {
		System.out.println("outerNum = "+outerNum);
		
//		외부 클래스에서는 내부 클래스로 객체 생성하여 접근제한자에 상관없이(같은 클래스니께)참조 가능    (거의 안 씀
//		InnerTwo temp=new InnerTwo();
//		System.out.println("innerNum = "+temp.innerNum);
		
//		내부 클래스의 정적 필드는 객체 생성 없이 클래스로 접근하여 사용 가능
//		System.out.println("staticNum = "+innerTwo.staticNum);
	}
	
	//정적 중첩 클래스 - static 제한자를 사용하여 클래스 선언       --> 잘 안 씀
	//ㄴ 정적 중첩 클래스에서는 static 제한자를 사용하여 필드 또는 메소드 선언 가능
	public static class InnerTwo{
		private int innerNum;
		private static int staticNum=300;
		
		public InnerTwo() {
			// TODO Auto-generated constructor stub
		}

		public InnerTwo(int innerNum) {
			super();
			this.innerNum = innerNum;
		}

		public int getInnerNum() {
			return innerNum;
		}

		public void setInnerNum(int innerNum) {
			this.innerNum = innerNum;
		}

		public static int getStaticNum() {
			return staticNum;
		}

		public static void setStaticNum(int staticNum) {
			InnerTwo.staticNum = staticNum;
		}
		
		public void displayInner() {
			System.out.println("innerNum = "+innerNum);
			System.out.println("staticNum = "+staticNum);
			
			//내부 클래스에서는 외부 클래스의 필드 또는 메소드를 참조 불가능 <<
			//ㄴ 외부클래스의 정적필드나 정적메소드는 참조 가능 <<
			
			//System.out.println("outerNum = "+outerNum);  불가능
		}
		
	}
	
	
	
}
