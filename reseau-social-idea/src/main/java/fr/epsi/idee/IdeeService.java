package fr.epsi.idee;

import java.util.List;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;

import fr.epsi.utilisateur.Utilisateur;

@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class IdeeService implements IIdeeService {

	@PersistenceContext
	private EntityManager em;

	@Resource
	private UserTransaction utx;

	public void add(Utilisateur u) {
		IIdeeDao dao = new IdeeDao(em, utx);
		dao.add(u);
	}

	public List<Utilisateur> get() {
		IIdeeDao dao = new IdeeDao(em, utx);
		return dao.get();
	}

}
