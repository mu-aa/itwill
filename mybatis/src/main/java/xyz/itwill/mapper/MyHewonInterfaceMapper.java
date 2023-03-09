package xyz.itwill.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import xyz.itwill.dto.MyHewon;

//mybatis framework는 인터페이스만 이용하여 Mapper 설정 가능
//ㄴ 추상메소드에 Mapper Annotation을 사용하여 SQL 명령 등록
public interface MyHewonInterfaceMapper {
	//추상메소드에 등록된 SELECT 명령은 기본적으로 검색결과를 자동 Mapping 하여 제공
	//ㄴ 검색결과를 자동 Mapping 하기 위해서는 검색행의 컬럼명과 Java 클래스의 필드명이 반드시 일치해야함
	//ㄴ 검색행의 컬럼명과 Java 클래스의 필드명이 하나도 같지 않으면 Java 객체 대신 NULL 제공
	//@Results : 검색행의 컬럼값을 Java 객체의 필드값으로 저장되도록 Mapping 처리하는 정보를 제공하는 Annotation
	//ㄴ XML 기반의 Mapper 파일에서 resultMap Element와 유사한 기능을 제공
	//ㄴ 재사용 불가능 - 유지보수 효율성 감소
	//value 속성 : Mapping 정보를 제공하는 @Result Annotation 배열을 속성값으로 설정
	//ㄴ 다른 속성이 없는 경우 속성값만 설정 가능(생략 가능)
	@Results(value = {
		//@Result : 검색행의 컬럼값이 Java 객체 필드에 저장되도록 설정하는 Element
		//ㄴ XML 기반의 Mapper 파일에서 id(result) Element와 유사한 기능을 제공
		//column 속성 : 검색행의 컬럼명을 속성값으로 설정
		//property 속성 : 검색행의 컬럼값이 저장될 Java 클래스의 필드명을 속성값으로 설정
		@Result(column = "hewon_id", property = "id")
		, @Result(column = "hewon_name", property = "name")
		, @Result(column = "hewon_phone", property = "phone")
		, @Result(column = "hewon_email", property = "email")
		, @Result(column = "hewon_state", property = "state")
	})
	@Select("select * from myhewon order by hewon_id")
	List<MyHewon> selectHewonList();
	
	
	@Results({
			@Result(column = "hewon_id", property = "id")
			, @Result(column = "hewon_name", property = "name")
			, @Result(column = "hewon_phone", property = "phone")
			, @Result(column = "hewon_email", property = "email")
			, @Result(column = "hewon_state", property = "state")
		})
	@Select("select * from myhewon where hewon_name=#{name} order by hewon_id")
	List<MyHewon> selectNameHewonList(String name);
	
	
	/*@Results({
		@Result(column = "hewon_id", property = "id")
		, @Result(column = "hewon_name", property = "name")
		, @Result(column = "hewon_phone", property = "phone")
		, @Result(column = "hewon_email", property = "email")
		, @Result(column = "hewon_state", property = "state")
	})
	//@SelectProvider : SQL Builder 클래스의 메소드를 호출하여 SELECT 명령을 반환받아 등록하는 Annotation
	//ㄴ 동적 SQL 기능을 사용하기 위한 Annotation
	//SQL Builder 클래스 : SQL 객체를 생성하여 메소드를 호출해 SQL 명령을 작성하고 객체에 저장하는 클래스
	//type 속성 : SQL Builder 관련 클래스(Clazz)를 속성값으로 설정
	//method 속성 : SQL 객체를 생성하여 SQL 명령을 작성해 반환하는 메소드명을 속성값으로 설정
	@SelectProvider(type = MyHewonProvider.class, method = "selectDynamicName")
	List<MyHewon> selectDynamicHewonList(String name);
	*/
	
	
	@Results({
		@Result(column = "hewon_id", property = "id")
		, @Result(column = "hewon_name", property = "name")
		, @Result(column = "hewon_phone", property = "phone")
		, @Result(column = "hewon_email", property = "email")
		, @Result(column = "hewon_state", property = "state")
	})
	//@Select Annotation의 value 속성값으로 script Element를 사용하면 SQL 명령 작성 시
	//동적 SQL 관련 Element 사용 가능
	//ㄴ value 속성값으로 배열을 설정하여 SQL 명령을 순차적으로 작성 가능
	@Select({"<script>select * from myhewon"
			, " <if test=\"name!=null and name!=''\">where hewon_name=#{name}</if>"
			, " order by hewon_id</script>"})
	List<MyHewon> selectDynamicHewonList(String name);
}