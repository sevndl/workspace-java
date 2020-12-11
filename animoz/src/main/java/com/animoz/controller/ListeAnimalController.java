package com.animoz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ListeAnimalController {

	@GetMapping(path = "/animaux") // anotation qui permet de dire que c'est une méthode HTTP GET
	public String afficherListeAnimaux() {
		return "listeAnimaux"; // listeAnimaux est le nom de la vue, du template (la page html avec des instructions dynamiques)
	}

}
