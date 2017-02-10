package ru.msk.tkachenko.dmitry.web.webnote.controller;

import javax.annotation.Resource;
import javax.sql.DataSource;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ru.msk.tkachenko.dmitry.web.webnote.data.UserDao;
import ru.msk.tkachenko.dmitry.web.webnote.data.UserDaoImpl;
import ru.msk.tkachenko.dmitry.web.webnote.model.Animal;
import ru.msk.tkachenko.dmitry.web.webnote.model.User;

@Controller
public class RegistrationController {
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	Animal animal;

	@RequestMapping(value="/registration", method=RequestMethod.GET)
	public String showRegistrationForm(Model model) {
		model.addAttribute(new User());
		model.addAttribute("userCount", userDao.totalCount());
		return "registerForm";
	}
	
	@RequestMapping(value="/registration", method=RequestMethod.POST)
	public String processRegistration(@Valid User user, Errors errors) {
		
		if (errors.hasErrors()) {
			return "registerForm";
		}
		
		userDao.save(user);
		return "redirect:/profile/" + user.getLogin();
	}
}
