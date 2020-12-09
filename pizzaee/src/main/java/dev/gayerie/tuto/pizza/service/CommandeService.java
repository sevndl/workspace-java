package dev.gayerie.tuto.pizza.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.gayerie.tuto.pizza.model.Commande;
import dev.gayerie.tuto.pizza.model.Pizza;
import dev.gayerie.tuto.pizza.repository.CommandeRepository;
import dev.gayerie.tuto.pizza.repository.PizzaRepository;

@Service
public class CommandeService {
	
	@Autowired
	private PizzaRepository pizzaRepository;

	@Autowired
	private CommandeRepository commandeRepository;

	public List<Pizza> getPizzas() {
		return pizzaRepository.findAllByOrderByNom();
	}

	public Optional<Pizza> getPizza(Long id) {
		return pizzaRepository.findById(id);
	}

	@Transactional
	public Commande commander(CommandeInfo commandeInfo) {
		Commande commande = new Commande();
		commande.setNom(commandeInfo.getNom());
		commande.setTelephone(commandeInfo.getTelephone());
		commande.setPizza(commandeInfo.getPizza());
		commande.setCreation(LocalDateTime.now());
		return commandeRepository.save(commande);
	}

	public Commande get(long id) throws CommandeNonTrouveeException{
		return commandeRepository.findById(id).orElseThrow(CommandeNonTrouveeException::new);
	}

}
