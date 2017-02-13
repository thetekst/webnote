package ru.msk.tkachenko.dmitry.web.webnote.controller;

import static org.junit.Assert.assertEquals;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

import ru.msk.tkachenko.dmitry.web.webnote.config.DispatcherServlet;
import ru.msk.tkachenko.dmitry.web.webnote.config.RootConfig;
import ru.msk.tkachenko.dmitry.web.webnote.config.WebMvcConfigurer;
import ru.msk.tkachenko.dmitry.web.webnote.data.UserDao;
import ru.msk.tkachenko.dmitry.web.webnote.data.UserDaoImpl;
import ru.msk.tkachenko.dmitry.web.webnote.model.User;

//@ContextConfiguration(classes=DispatcherServlet.class)

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = WebMvcConfigurer.class)
public class NoteControllerTest {
	
	@Autowired
	private WebApplicationContext wac;
	
//	@Autowired
//	private JdbcTemplate jdbcTemplate;
	
//	@Autowired
//	UserDao userDao;
	
	
//	@Autowired
//	@Qualifier("userDao")
//	private UserDao userDao;
//	
//	public NoteControllerTest() {
//	}
//
//	@Test
//	public void testNotePage() {
//		NoteController controller = new NoteController();
//		assertEquals("notepage", controller.notePage());
//	}

	
	@Test
	public void testConnection() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
      dataSource.setDriverClassName("org.mariadb.jdbc.Driver");
      dataSource.setUrl("jdbc:mysql://localhost:3306/webnote_db"); // or jdbc:mariadb://localhost:3306/webnote_db
      dataSource.setUsername("root");
      dataSource.setPassword("good35");
      
      JdbcTemplate jdbcTemplate = new JdbcTemplate();
      jdbcTemplate.setDataSource(dataSource);
      
      final String sql = "SELECT count(*) FROM profile"; // webnote_db.profile
      long count = jdbcTemplate.queryForObject(sql, Long.class);
      System.out.println(count);
//      
//      UserDao userDaoImpl = new UserDaoImpl();
//      userDaoImpl.totalCount();
	}
	
	@Test
	public void testCount() {
//		User user = new User();
//		user.setEmail("asfd@sfsdf");
//		user.setLogin("log");
//		user.setPassword("asdfasdf");
//		user.setRememberMe(true);
//		userDaoImpl.save(user);
//		UserDaoImpl userDao = new UserDaoImpl();
//		System.out.println(userDao.totalCount());
		
//		AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext();
//		applicationContext.register(WebMvcConfigurer.class);
//		UserDao empDAO = applicationContext.getBean(UserDao.class);
// 
//        long empName = empDAO.totalCount();
// 
//        System.out.println("Employee name is " + empName);
// 
//        applicationContext.close();
	}
	
//	@Test
//	public void testData() {
////		JdbcUserRepository jdbc = new JdbcUserRepository();
//		User user = jdbc.save();
//		System.out.println(user.toString());
//	}

}
