package fr.epsi.repository;

import java.util.List;

import fr.epsi.entite.Facture;

public interface IFactureRepository {
	
	List<Facture> getAllFactures();
	Facture getFactureById(Long id);
	List<Facture> getFactureByClientId(Long id);
	void add(Facture facture);

}
