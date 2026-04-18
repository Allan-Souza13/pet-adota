package com.allan.pets.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.allan.pets.entity.Pet;
import com.allan.pets.service.PetService;


@RestController
@RequestMapping("/pets")

public class PetController {

	@Autowired
	private PetService service;
	
	
		
		//LISTAR
	
	@GetMapping
	public List<Pet> listar() {
		return service.listarPets();
	}
	
	@GetMapping("/adotados")
	public List<Pet> listarAdotados() {
		return service.listarPetsAdotados();
			
		}
		
		//CADASTRAR
	@PostMapping
		public Pet criarPets(@RequestBody Pet pet) {
			return service.criarPet(pet);
		}
		
		
	@DeleteMapping("/{id}")
	public String deletarPet(@PathVariable Long id) {
		
		service.deletarPet(id);
		return "Pet deletado";
	}
	
	@PutMapping("/{id}")
	public Pet atualizarPet(@PathVariable Long id, @RequestBody Pet pet ) {
		
		return service.atualizarPet(id, pet);
	}
	
	@PatchMapping("/{id}/adotar")
	public Pet adotarPet(@PathVariable Long id) {
		return service.adotarPet(id);
	}
	
	
		}
		
	
	
	
	

