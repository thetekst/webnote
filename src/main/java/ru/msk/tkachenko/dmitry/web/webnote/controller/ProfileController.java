package ru.msk.tkachenko.dmitry.web.webnote.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/profile")
public class ProfileController {
	
	@RequestMapping(value="/{login}", method=RequestMethod.GET)
	public String profilePage(Model model) {
//		model.addAttribute("username", username);
		return "profile";
	}
}
