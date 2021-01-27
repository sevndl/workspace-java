package fr.epsi.service;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.epsi.entite.Produit;

@Stateless
public class ProduitService implements IProduitService {

	@PersistenceContext
	private EntityManager em;
	
	public void createProduit(Produit p) {
		em.persist(p);
	}

}
