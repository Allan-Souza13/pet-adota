package com.allan.pets.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.allan.pets.entity.Pet;
import com.allan.pets.repository.PetRepository;


@Service
public class PetService {
	
	@Autowired
	private PetRepository repository;
	
	
	
	public List<Pet> listarPetsAdotados() {
	    return repository.findByAdotadoTrue();
	}
	
	public List<Pet> listarPetsDisponiveis() {
		
		return repository.findByAdotadoFalse();
	}
	
	
	public List<Pet> listarPets(){
		return repository.findAll();
	}
	
	public Pet criarPet(Pet pet) {
		
		return repository.save(pet);
		
	}
	 
	public void deletarPet(Long id) {
		repository.deleteById(id);
	}
	
	
	public Pet atualizarPet(Long id, Pet petAtualizado) {
		
		Pet pet = repository.findById(id).orElse(null);
		
		if (pet == null) {
			return null;
		}
		
		
		pet.setNome(petAtualizado.getNome());
		pet.setEspecie(petAtualizado.getEspecie());
		
		return repository.save(pet);
		
	}
	
	public Pet adotarPet(Long id) {
		
		Pet pet = repository.findById(id).orElse(null);
		
		if(pet == null) {
			return null;
		}
		
		
		
		if (pet.getAdotado() != null && pet.getAdotado()) {
			throw new RuntimeException("Pet ja foi adotado!");
		}
		
		pet.setAdotado(true);
		return repository.save(pet);
		
	}
	
	
	
	
	
	
	
	
	
	
}
