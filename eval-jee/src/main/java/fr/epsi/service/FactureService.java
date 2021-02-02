package fr.epsi.service;

import java.util.List;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;

import fr.epsi.entite.Client;
import fr.epsi.entite.Facture;
import fr.epsi.repository.ClientRepository;
import fr.epsi.repository.FactureRepository;
import fr.epsi.repository.IClientRepository;
import fr.epsi.repository.IFactureRepository;

@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class FactureService implements IFactureService {

	@PersistenceContext
	private EntityManager em;

	@Resource
	private UserTransaction utx;

	public List<Facture> getAllFactures() {
		IFactureRepository dao = new FactureRepository(em, utx);
		return dao.getAllFactures();
	}
	
	public void add(Facture facture) {
		IFactureRepository dao = new FactureRepository(em, utx);
		dao.add(facture);
	}

	public Facture getFactureById(Long id) {
		IFactureRepository dao = new FactureRepository(em, utx);
		return dao.getFactureById(id);
	}	

}
