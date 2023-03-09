package bookReview;


//6-5 3번
public class ShopService {
	
	//스태틱 필드 선언
	private static ShopService Instance;
	
	//생성자 은닉
	private ShopService() {
		// TODO Auto-generated constructor stub
	}
	
	//객체 생성
	static {
		Instance=new ShopService();
	}
	
	//객체 반환(getter 아님 주의)
	public static ShopService getInstance() {
		return Instance;
	}
	
	
}
