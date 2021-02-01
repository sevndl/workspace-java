package fr.epsi.service;

import java.util.List;

import fr.epsi.entite.Article;

public interface IArticleService {
	
	List<Article> getAllArticles();
	void add(Article article);

}
