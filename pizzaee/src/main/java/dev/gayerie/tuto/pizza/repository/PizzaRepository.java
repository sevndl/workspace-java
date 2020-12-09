package dev.gayerie.tuto.pizza.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.gayerie.tuto.pizza.model.Pizza;

public interface PizzaRepository extends JpaRepository<Pizza, Long>{

	List<Pizza> findAllByOrderByNom();

}
