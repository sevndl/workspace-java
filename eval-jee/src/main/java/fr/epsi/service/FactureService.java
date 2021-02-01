package fr.epsi.service;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;

import fr.epsi.entite.Facture;
import fr.epsi.repository.FactureRepository;
import fr.epsi.repository.IFactureRepository;

@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class FactureService implements IFactureService {

	@PersistenceContext
	private EntityManager em;

	@Resource
	private UserTransaction utx;
	
	public void add(Facture facture) {
		IFactureRepository dao = new FactureRepository(em, utx);
		dao.add(facture);
	}	

}
