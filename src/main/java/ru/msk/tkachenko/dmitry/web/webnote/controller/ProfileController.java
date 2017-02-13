package ru.msk.tkachenko.dmitry.web.webnote.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import ru.msk.tkachenko.dmitry.web.webnote.data.UserDao;
import ru.msk.tkachenko.dmitry.web.webnote.error.UserNotFoundException;
import ru.msk.tkachenko.dmitry.web.webnote.model.User;

import ru.msk.tkachenko.dmitry.web.webnote.error.Error;

@RestController
@RequestMapping("/profile")
public class ProfileController {
	
	@Autowired
	private UserDao userDao;
	
//	@RequestMapping(value="/{login}", method=RequestMethod.GET)
//	public String profilePage(Model model) {
////		model.addAttribute("username", username);
//		return "profile";
//	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET, produces="application/json")
	public User userById(@PathVariable Long id) {
		return userDao.find(id);
	}
	
	@RequestMapping(value="/", method=RequestMethod.GET, produces="application/json")
	public List<User> users() {
		return userDao.findAll();
	}
	
	@ExceptionHandler(UserNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public @ResponseBody Error userNotFound(UserNotFoundException e) {
		long userId = e.getUserId();
		return new Error(4, "User [" + userId + "] not found");
	}
}
