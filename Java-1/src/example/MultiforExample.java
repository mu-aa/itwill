package example;

public class MultiforExample {
	public static void main(String[] args) {
		//★★★★★
		//★★★★
		//★★★
		//★★
		//★
		
		for(int i=5;i>=1;i--) {
			for(int j=1;j<=i;j++) {
				System.out.print("★");
			}
			System.out.println();
		}
		
		System.out.println("\n=================================\n");
		
		//★★★★★
		//☆★★★★
		//☆☆★★★
		//☆☆☆★★
		//☆☆☆☆★
		
		for(int i=1;i<=5;i++) {
			for(int j=1;j<=(i-1);j++) {
				System.out.print("☆");
			}
			for(int j=5;j>=i;j--) {
				System.out.print("★");
			}
			System.out.print("\n");
		}
		
		System.out.println("\n=================================\n");
		
		//★
		//★★★
		//★★★★★
		//★★★★★★★
		//★★★★★★★★★
		
		for(int i=1;i<=9;i+=2) {
			for(int j=1;j<=i;j++) {
				System.out.print("★");
			}
			System.out.println();
		}
		
		System.out.println("\n=================================\n");
		
		//★☆☆☆★
		//☆★☆★☆
		//☆☆★☆☆
		//☆★☆★☆
		//★☆☆☆★
		
		for(int i=1;i<=5;i++) {
			for(int j=1;j<=5;j++) {
				if(i+j==6 || i==j) {
					System.out.print("★");
				} else {
					System.out.print("☆");
				}
			}
			System.out.println();
		}
		System.out.println("\n=================================\n");
		
	}
}