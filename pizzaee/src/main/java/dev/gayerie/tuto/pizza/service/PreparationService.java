package dev.gayerie.tuto.pizza.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.gayerie.tuto.pizza.model.Commande;
import dev.gayerie.tuto.pizza.repository.CommandeRepository;

@Service
public class PreparationService {
	
	@Autowired
	private CommandeRepository commandeRepository;

	public List<Commande> getCommandesEnAttente() {
		return commandeRepository.getCommandesEnAttente();
	}

	public Commande getCommandeSuivante() throws CommandeNonTrouveeException {
		return commandeRepository.getCommandeSuivante().orElseThrow(CommandeNonTrouveeException::new);
	}

	@Transactional
	public void signalerCommandePrete(long idCommande) throws CommandeNonTrouveeException {
		Commande commande = commandeRepository.findById(idCommande).orElseThrow(CommandeNonTrouveeException::new);
		commande.setPrete();
	}

}
