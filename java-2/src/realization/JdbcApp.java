package realization;

public class JdbcApp {
	public static void main(String[] args) {
		/*
		JdbcMysql mySql=new JdbcMysql();
		
		mySql.update();
		mySql.insert();
		mySql.delete();
		mySql.select();
		
		//시스템 변경에 의한 클래스 교체 시에 대한 메소드 호출 명령 변경 
		//ㄴ 바꾸려면 다 뜯어고쳐야 함(결합도가 높아서 유지보수 효율성↓)
		
		JdbcOracle oracle=new JdbcOracle();
		
		oracle.add();
		oracle.modify();
		oracle.remove();
		oracle.search();
		*/
		
		//객체간의 결합도를 낮추기 위해 참조변수는 인터페이스를 이용하여 선언
		//시스템 변경에 의한 클래스 교체 시 메소드 호출 명령 미변경
		//ㄴ 객체간의 결합도를 낮춰 유지보수의 효율성↑
		
//		Jdbc sys=new JdbcMysql();   
		Jdbc sys=new JdbcOracle(); // => 객체만 바꾸면 원하는 결과 도출
		
		//참조변수로 인터페이스의 추상 메소드를 호출하여 묵시적 객체 형변환으로
		//참조변수에 저장된 자식 클래스 객체의 메소드를 참조하여 호출
		sys.insert();
		sys.update();
		sys.delete();
		sys.select();
		
	}
}
