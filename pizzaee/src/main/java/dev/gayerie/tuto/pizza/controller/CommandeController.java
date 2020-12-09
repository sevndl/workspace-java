package dev.gayerie.tuto.pizza.controller;

import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.validation.ValidationUtils.rejectIfEmpty;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import dev.gayerie.tuto.pizza.model.Commande;
import dev.gayerie.tuto.pizza.service.CommandeInfo;
import dev.gayerie.tuto.pizza.service.CommandeNonTrouveeException;
import dev.gayerie.tuto.pizza.service.CommandeService;

@Controller
public class CommandeController {
	
	@Autowired
	private CommandeService commandeService;

	@GetMapping("/commande")
	public String afficherFormulaireCommande(Model model, @ModelAttribute CommandeInfo commandeInfo) {
		model.addAttribute("pizzas", commandeService.getPizzas());
		return "commande-form";
	}

	@PostMapping("/commande")
	public String commander(Model model, @Valid @ModelAttribute CommandeInfo commandeInfo, BindingResult bindingResult) {
		rejectIfEmpty(bindingResult, "pizza.id", "validation");
		if (bindingResult.hasErrors()) {
			return afficherFormulaireCommande(model, commandeInfo);
		}
		Commande commande = commandeService.commander(commandeInfo);
		return "redirect:/commande/" + commande.getId();
	}
	
	@GetMapping("/commande/{idCommande}")
	public String afficherRecapitulatifCommande(Model model, @PathVariable long idCommande) throws CommandeNonTrouveeException {
		model.addAttribute("commande", commandeService.get(idCommande));
		return "commande-recap";
	}
	
	@ExceptionHandler(CommandeNonTrouveeException.class)
	@ResponseStatus(NOT_FOUND)
	public String handleException(CommandeNonTrouveeException e) {
		return "commande-non-trouvee";
	}
}
