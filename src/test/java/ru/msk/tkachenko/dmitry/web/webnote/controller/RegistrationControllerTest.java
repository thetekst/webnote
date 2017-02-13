package ru.msk.tkachenko.dmitry.web.webnote.controller;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.context.WebApplicationContext;

import ru.msk.tkachenko.dmitry.web.webnote.config.WebMvcConfigurer;
import ru.msk.tkachenko.dmitry.web.webnote.data.UserDao;

@RunWith(SpringRunner.class)
@SpringBootTest
//@WebMvcTest(RegistrationController.class)
//@JdbcTest
@ContextConfiguration(classes = WebMvcConfigurer.class)
public class RegistrationControllerTest {
	
	@Autowired
	private WebApplicationContext wac;
	
	@Autowired
	@Qualifier("userDao")
	private UserDao userDao;

	@Test
	public void testShowRegistrationForm() {
		
	}

}
