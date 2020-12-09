package dev.gayerie.tuto.pizza.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AccueilController {

	@GetMapping({"/", "/accueil"})
	public String accueillir() {
		return "accueil";
	}
}
