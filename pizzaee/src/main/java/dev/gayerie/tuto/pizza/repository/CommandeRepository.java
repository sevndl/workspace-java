package dev.gayerie.tuto.pizza.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.gayerie.tuto.pizza.model.Commande;

public interface CommandeRepository extends JpaRepository<Commande, Long>{

	default List<Commande> getCommandesEnAttente() {
		return findByPreteOrderByCreation(false);
	}
	
	default Optional<Commande> getCommandeSuivante() {
		return findTopByPreteOrderByCreation(false);
	}
	
	List<Commande> findByPreteOrderByCreation(boolean prete);

	Optional<Commande> findTopByPreteOrderByCreation(boolean prete);
}
