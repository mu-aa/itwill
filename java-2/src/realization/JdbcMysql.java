package realization;

public class JdbcMysql implements Jdbc{
	
	@Override
	public void insert() {
		System.out.println("[mysql]학생 정보를 삽입하는 메소드");
	}
	@Override
	public void update() {
		System.out.println("[mysql]학생 정보를 변경하는 메소드");
	}
	@Override
	public void delete() {
		System.out.println("[mysql]학생 정보를 삭제하는 메소드");
	}
	@Override
	public void select() {
		System.out.println("[mysql]학생 정보를 검색하는 메소드");
	}
	
}//class
