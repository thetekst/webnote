package ru.msk.tkachenko.dmitry.web.webnote.data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import ru.msk.tkachenko.dmitry.web.webnote.config.DataSourceConfig;
import ru.msk.tkachenko.dmitry.web.webnote.model.User;

@Repository
public class UserDaoImpl implements UserDao { // extends JdbcDaoSupport

	private JdbcTemplate jdbcTemplate;
	
	private final String findAllQuery = "SELECT * FROM profile";

	public UserDaoImpl(DataSourceConfig dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource.getDataSource());
	}

	public List<User> getAllUsers() {
		
        List<User> users = new ArrayList<User>();
        
        User user = new User();

        user.setLogin("dima");
		user.setPassword("folk");
		user.setEmail("dima@asf.ru");
		user.setRememberMe(false);
		
		users.add(user);

		user.setLogin("john");
		user.setPassword("dot");
		user.setEmail("john@asf.ru");
		user.setRememberMe(true);
		
		users.add(user);

        return users;
    }
	
//	@Autowired
//	public void setJdbcTemplate(JdbcTemplate jdbcTemplate){
//        this.jdbcTemplate = jdbcTemplate;
//    }
	
//	@Autowired
//	public UserDaoImpl(DataSource dataSource) {
//        jdbcTemplate = new JdbcTemplate(dataSource);
//    }
	
	@Override
	public long totalCount() {
		final String sql = "SELECT count(*) FROM profile"; // webnote_db.profile
		long count = jdbcTemplate.queryForObject(sql, Long.class);
//		int size = jdbcTemplate.getFetchSize();
//		System.out.println(count);
		return count;
	}
	
//	private JdbcOperations jdbc;
//	
//	@Autowired
//	public JdbcUserRepository(JdbcOperations jdbc) {
//		this.jdbc = jdbc;
//	}
	
	@Override
	public User save(User user) {
//		System.out.println(user.toString());
		jdbcTemplate.update(
		"insert into profile (login, password, email, remember_me)" +
		" values (?, ?, ?, ?)",
		user.getLogin(),
		user.getPassword(),
		user.getEmail(),
		user.getRememberMe());
		
//		user.getLogin();
//		user.getPassword();
//		user.getEmail();
//		user.getRememberMe();
		
//		System.out.println("***********" + user.toString());

//		user.setLogin("dima");
//		user.setPassword("dsfsad");
//		user.setEmail("asf@asf.ru");
//		user.setRememberMe(false);
		return user;
	}

	@Override
	public List<User> findAll() {
		return jdbcTemplate.query(findAllQuery, new UserRowMapper());
	}

	
	
//	public User findByUsername(String username) {
//		return jdbc.queryForObject(
//		"select id, username, null, first_name, last_name, email from Spitter where login=?", 
//		new UserRowMapper(), 
//		login);
//	}
//
//	private static class UserRowMapper implements RowMapper<User> {
//		public User mapRow(ResultSet rs, int rowNum) throws SQLException {
//			return new User(
//			rs.getLong("id"),
//			rs.getString("login"),
//			null,
//			rs.getString("email"));
//		}
//	}
	
	private class UserRowMapper implements RowMapper<User> {

		@Override
		public User mapRow(ResultSet rs, int rowNum) throws SQLException {
			return new User(
					rs.getLong("id"),
					rs.getString("login"),
					rs.getString("password"),
					rs.getString("email"),
					rs.getBoolean("remember_me")
			);
		}
		
	}
}
