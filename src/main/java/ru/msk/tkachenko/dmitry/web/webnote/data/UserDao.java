package ru.msk.tkachenko.dmitry.web.webnote.data;

import java.util.ArrayList;
import java.util.List;

import ru.msk.tkachenko.dmitry.web.webnote.model.User;

public interface UserDao {
	
	long totalCount();
	
	User save(User user);
	List<User> findAll();
}
