package fr.epsi.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

import fr.epsi.entite.Article;

public class ArticleRepository implements IArticleRepository {

	EntityManager em;
	UserTransaction utx;
	
	public ArticleRepository(EntityManager em, UserTransaction utx) {
		this.em = em;
		this.utx = utx;
	}
	
	public Article getArticleById(Long id) {
		return em.createQuery("select a from Article a where a.id = :id", Article.class)
				 .setParameter("id", id)
				 .getSingleResult();
	}

	public List<Article> getAllArticles() {
		return em.createQuery("select a from Article a", Article.class).getResultList();
	}
	
	public void add(Article article) {
		try {
			utx.begin();
			em.persist(article);
			utx.commit();
		} catch (NotSupportedException e) {
			e.printStackTrace();
		} catch (SystemException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (RollbackException e) {
			e.printStackTrace();
		} catch (HeuristicMixedException e) {
			e.printStackTrace();
		} catch (HeuristicRollbackException e) {
			e.printStackTrace();
		}
	}

}
