package com.animoz.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.animoz.modele.Espece;

@Repository
public class EspeceRepository {

	@Autowired
	private EntityManager em;
	
	public List<Espece> getListeEspeces() {
		return em.createQuery("select e from Espece e order by e.nom asc", Espece.class)
				 .getResultList();
	}

}
