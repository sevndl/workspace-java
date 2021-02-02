package fr.epsi.repository;

import java.util.List;

import fr.epsi.entite.Facture;

public interface IFactureRepository {
	
	List<Facture> getAllFactures();
	void add(Facture facture);

}
