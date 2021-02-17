package fr.epsi.categorie;

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
public class CategorieService implements ICategorieService {

	@PersistenceContext
	private EntityManager em;

	@Resource
	private UserTransaction utx;

	public void add(Categorie c) {
		ICategorieDao dao = new CategorieDao(em, utx);
		dao.add(c);

	}

	public List<Categorie> get() {
		ICategorieDao dao = new CategorieDao(em, utx);
		return dao.get();
	}

	public Categorie getById(Long id) {
		ICategorieDao dao = new CategorieDao(em, utx);
		return dao.getById(id);
	}

}
