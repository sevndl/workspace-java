package com.animoz.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.animoz.modele.Soigneur;

@Repository
public class SoigneurRepository {

	@Autowired
	private EntityManager em;
	
	public List<Soigneur> getListeSoigneurs() {
		return em.createQuery("select s from Soigneur s order by s.nom asc", Soigneur.class)
				 .getResultList();
	}

}
