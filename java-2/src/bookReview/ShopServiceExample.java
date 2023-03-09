package bookReview;


//6-5 3번
public class ShopServiceExample {
 public static void main(String[] args) {
	 
	 ShopService obj1=ShopService.getInstance();
	 ShopService obj2=ShopService.getInstance();
		
		if(obj1==obj2) {
			System.out.println("일치");
		} else {
			System.out.println("불일치");
		}
		
		
		
		
 	}
}
