package com.animoz.repository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.animoz.modele.Animal;
import com.animoz.modele.Espece;
import com.animoz.modele.Soigneur;

@Repository
public class SoigneurRepository {

	@Autowired
	private EntityManager em;
	
	public List<Soigneur> getListeSoigneurs() {
		return em.createQuery("select s from Soigneur s order by s.nom asc", Soigneur.class)
				 .getResultList();
	}
	
	public void addSoigneur(String nomSoigneur, String numeroSoigneur, String dateRecrutement) {
		Long verificationSoigneurExiste = (Long) em.createQuery("select count(s) from Soigneur s where s.nom = :nom")
				.setParameter("nom", nomSoigneur)
				.getSingleResult();
		if (verificationSoigneurExiste < 1) {
			Soigneur newSoigneur = new Soigneur();
			newSoigneur.setNom(nomSoigneur);
			newSoigneur.setNumero(numeroSoigneur);
			
			Date nouvelleDateRecrutement;
			try {
				nouvelleDateRecrutement = new SimpleDateFormat("yyyy-MM-dd").parse(dateRecrutement);
				System.out.println(nouvelleDateRecrutement);
				newSoigneur.setDateRecrutement(nouvelleDateRecrutement);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
			em.persist(newSoigneur);
		}
	}

}
