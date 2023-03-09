package example;

public class BookExample {

	public static void main(String[] args) {
		
	//3번
	boolean stop=true;
	while(!stop) {
		System.out.println("...");
		}
	System.out.println("===================================");
	
	//4번
	int pencils=534, students=30;
	
	//학생 1명이 가지는 연필
	int pencilsPerStudent=pencils/students;
	System.out.println(pencilsPerStudent);
	
	//남는 연필
	int pencilsLeft=pencils%students;
	System.out.println(pencilsLeft);
	System.out.println("===================================");
	
	//6번
	int value = 356;
	System.out.println((value/100)*100);
	System.out.println("===================================");
	
	//7번
	float var1=10f, var2=var1/100;
	if(var2==0.1) {
		System.out.println("10%");
	} else {
		System.out.println("not");
	}
	
	
	}
}
