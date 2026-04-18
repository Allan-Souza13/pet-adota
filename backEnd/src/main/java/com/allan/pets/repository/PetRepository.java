package com.allan.pets.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.allan.pets.entity.Pet;

public interface PetRepository extends JpaRepository<Pet, Long>{
	
	List<Pet> findByAdotadoFalse();
	
	List<Pet> findByAdotadoTrue();
}
