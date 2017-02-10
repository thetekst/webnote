package ru.msk.tkachenko.dmitry.web.webnote.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping({"/note"})
public class NoteController {
	
	@RequestMapping(method=RequestMethod.GET)
	public String notePage() {
		return "notepage";
	}
}
