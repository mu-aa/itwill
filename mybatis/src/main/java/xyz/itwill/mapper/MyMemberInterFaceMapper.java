package xyz.itwill.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import xyz.itwill.dto.MyMember;

//mybatis framework에서는 interface를 이용해서 mapper 설정 가능
//ㄴ 추상메소드에 mapper annotation을 사용하여 SQL 명령 등록
public interface MyMemberInterFaceMapper {
	//@Insert : 추상메소드에 INSERT 명령을 등록하기 위한 annotation
	//value 속성 : 추상메소드에 등록한 SQL 명령을 속성값으로 설정
	//ㄴ value 속성 외에 다른 속성이 없는 경우 생략 가능
	@Insert(/*value=*/"insert into mymember values(#{id}, #{name}, #{phone}, #{email})")
	//추상메소드의 매개변수에는 SQL 명령에 필요한 객체(값)를 전달받기 위해 선언하며
	//반환형은 등록된 SQL 명령을 전달하여 실행한 결과를 제공받기 위해 Java 자료형으로 선언
	int insertMember(MyMember member);
	
	@Update("update mymember set name=#{name}, phone=#{phone}, email=#{email} where id=#{id}")
	int updateMember(MyMember member);
	
	@Delete("delete from mymember where id=#{id}")
	int deleteMember(String id);
	
	@Select("select * from mymember where id=#{id}")
	MyMember selectMember(String id);
	
	@Select("select * from mymember order by id")
	List<MyMember> selectMemberList();
}