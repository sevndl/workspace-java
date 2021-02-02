package fr.epsi.repository;

import java.util.List;

import fr.epsi.entite.Article;

public interface IArticleRepository {
	
	Article getArticleById(Long id);
	List<Article> getAllArticles();
	void add(Article article);

}
