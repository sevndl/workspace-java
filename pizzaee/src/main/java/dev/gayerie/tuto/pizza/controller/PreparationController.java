package dev.gayerie.tuto.pizza.controller;

import static org.springframework.http.HttpStatus.NOT_FOUND;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import dev.gayerie.tuto.pizza.service.CommandeNonTrouveeException;
import dev.gayerie.tuto.pizza.service.PreparationService;

@Controller
public class PreparationController {
	
	@Autowired
	private PreparationService preparationService;
	
	@GetMapping("/commandes")
	public String afficherCommandes(Model model) {
		model.addAttribute("commandes", preparationService.getCommandesEnAttente());
		return "commandes";
	}

	@GetMapping("/commandes/suivante")
	public String afficherCommandeSuivante(Model model) throws CommandeNonTrouveeException {
		model.addAttribute("commande", preparationService.getCommandeSuivante());
		return "commande-suivante";
	}

	@PostMapping("/commandes/{idCommande}")
	public String signalerCommandePrete(@PathVariable long idCommande, RedirectAttributes redirectAttributes) throws CommandeNonTrouveeException {
		preparationService.signalerCommandePrete(idCommande);
		redirectAttributes.addFlashAttribute("message", "message.commande.preparation.terminee");
		return "redirect:/commandes";
	}

	@ExceptionHandler(CommandeNonTrouveeException.class)
	@ResponseStatus(NOT_FOUND)
	public String handleException(CommandeNonTrouveeException e) {
		return "commande-non-trouvee";
	}
}
