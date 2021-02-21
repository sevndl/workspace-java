package fr.epsi.idee;

import java.util.List;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;

@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class IdeeService implements IIdeeService {

	@PersistenceContext
	private EntityManager em;

	@Resource
	private UserTransaction utx;

	public void add(Idee i) {
		IIdeeDao dao = new IdeeDao(em, utx);
		dao.add(i);
	}

	public List<Idee> get() {
		IIdeeDao dao = new IdeeDao(em, utx);
		return dao.get();
	}

	public Idee getById(Long id) {
		IIdeeDao dao = new IdeeDao(em, utx);
		return dao.getById(id);
	}

	public void addTopById(Long id) {
		IIdeeDao dao = new IdeeDao(em, utx);
		dao.addTopById(id);
	}

	public void addFlopById(Long id) {
		IIdeeDao dao = new IdeeDao(em, utx);
		dao.addFlopById(id);
	}

}
