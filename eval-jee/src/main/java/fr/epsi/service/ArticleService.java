package fr.epsi.service;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;

import fr.epsi.entite.Article;
import fr.epsi.repository.ArticleRepository;
import fr.epsi.repository.IArticleRepository;

@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class ArticleService implements IArticleService {

	@PersistenceContext
	private EntityManager em;

	@Resource
	private UserTransaction utx;
	
	public void add(Article article) {
		IArticleRepository dao = new ArticleRepository(em, utx);
		dao.add(article);
	}	

}
