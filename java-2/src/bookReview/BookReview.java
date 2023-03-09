package bookReview;

public class BookReview {
	//6-4 3번
	public boolean login (String id,String pswd) {
		if(id=="hong" && pswd=="12345") {  //equals 로 책에 나와있는데 되긴 함. 질문해보기
			return true;
		} else {
			return false;
		}
	}
	
	public void logout(String id) {
		if(id=="hong")
		System.out.println("log out\n");
	}

	//6-4 3번
	
	
	//6-4 4번

	public void println(int i) {
		System.out.println(i);
	}
	public void println(boolean i) {
		System.out.println(i);
	}
	public void println(double i) {
		System.out.println(i);
	}
	public void println(String i) {
		System.out.println(i);
	}
	
	//6-4 4번
	

	
	
	
	
	
	//main method
	public static void main(String[] args) {
		
		//5-2 4번
		System.out.println("--5-2 4번--");
		int max=0;
		int[] array= {9,5,3,8,1};
		
		for(int i=0;i<array.length-1;i++) {
			if(array[i]>array[i+1]) {
				max=array[i];
			} else if(max>array[i]){
				//원래있던값
			} else {
				max=array[i+1];
			}
		}
		System.out.println("max : "+max);
		System.out.println("--5-2 4번--\n");
		//5-2 4번
		
		//6-4 3번
		System.out.println("--6-4 3번--");
		BookReview memberService=new BookReview();
		
		boolean result=memberService.login("hong", "12345");
		if(result) {
			System.out.println("log in");
			memberService.logout("hong");			
		} else {
			System.out.println("error");
		}
		System.out.println("--6-4 3번--\n");
		//6-4 3번
		
		//6-4 4번
		System.out.println("--6-4 4번--");
		BookReview printer=new BookReview();
		printer.println(10);
		printer.println(true);
		printer.println(5.7);
		printer.println("홍길동\n");
		System.out.println("--6-4 4번--\n");
		//6-4 4번
		

	}
}
