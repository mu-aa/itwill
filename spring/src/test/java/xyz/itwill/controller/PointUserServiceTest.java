package xyz.itwill.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import xyz.itwill10.dto.PointUser;
import xyz.itwill10.service.PointUserService;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class PointUserServiceTest {
	private static final Logger logger=LoggerFactory.getLogger(PointUserServiceTest.class);
	
	@Autowired
	private PointUserService pointUserService;
	
	/*
	@Test
	public void testAddPointUser() throws Exception {
		PointUser user=new PointUser();
		user.setId("abc123");
		user.setName("홍길동");
		
		PointUser addUser=null;
		try {
			addUser=pointUserService.addPointUser(user);
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
		
		logger.info(addUser.toString());
	} */
	
	@Transactional
	@Test
	public void testAddPointUser() throws Exception {
		PointUser user=new PointUser();
		user.setId("xyz789");
		user.setName("임꺽정");
		
		PointUser addUser=null;
		try {
			addUser=pointUserService.addPointUser(user);
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
		
		logger.info(addUser.toString());
	}
}