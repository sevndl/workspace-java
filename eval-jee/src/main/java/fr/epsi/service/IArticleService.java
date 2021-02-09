package fr.epsi.service;

import java.util.List;

import fr.epsi.entite.Article;

public interface IArticleService {
	
	void add(Article article);
	List<Article> getAllArticles();
	Article getArticleById(Long id);

}
