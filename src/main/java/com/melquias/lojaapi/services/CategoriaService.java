package com.melquias.lojaapi.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.melquias.lojaapi.domain.Categoria;
import com.melquias.lojaapi.repositories.CategoriaRepository;
import com.melquias.lojaapi.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository repo;
	
	public Categoria buscar(Integer id) {
		 Optional<Categoria> obj = repo.findById(id);
			return obj.orElseThrow(() -> new ObjectNotFoundException(
			 "Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
			}
		
	
}
