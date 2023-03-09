package xyz.itwill.controller;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import xyz.itwill10.dto.PointBoard;
import xyz.itwill10.dto.PointUser;
import xyz.itwill10.service.PointBoardService;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PointBoardServiceTest {
	private static final Logger logger=LoggerFactory.getLogger(PointBoardServiceTest.class);
	
	@Autowired
	private PointBoardService pointBoardService;
	
	@Transactional
	@Test
	public void test1(){
		PointBoard board=new PointBoard();
		//board.setWriter("abc123");
		board.setWriter("xyz789"); //게시글 작성자를 존재하지 않는 회원정보로 설정
		board.setSubject("테스트");
		
		PointUser user=null;
		try {
			//게시글 작성자가 없는 경우 예외 발생
			//문제점) 예외 발생 전 실행된 게시글 삽입 SQL 명령은 이미 전달되어 실행된 상태로
			//POINTBOARD 테이블에 게시글 저장
			//ㄴ 게시글 작성자가 존재하지 않는 게시글 - 게시글을 검색하여 출력 시 문제 발생
			//해결법) 예외 발생 전 실행된 모든 SQL 명령은 ROLLBACK 처리
			//ㄴ Spring Framework에서는 TransactionManager 관련 클래스를 사용하여 일관성 있는
			//Transaction 처리 기능 제공 - SpringAOP
			user=pointBoardService.addPointBoard(board);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		
		logger.info(pointBoardService.getPointBoardList().toString());
		logger.info(user.toString());
	}
	
	/*
	@Transactional
	@Test
	public void test2() {
		PointUser user=null;
		try {
			user=pointBoardService.removePointBoard(1);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		
		logger.info(pointBoardService.getPointBoardList().toString());
		logger.info(user.toString());
	}
	*/
}