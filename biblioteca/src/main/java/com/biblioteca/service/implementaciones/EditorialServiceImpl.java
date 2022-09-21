package com.biblioteca.service.implementaciones;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
  
import com.biblioteca.entity.Lector; 
import com.biblioteca.repositories.LectorRepository; 
import com.biblioteca.service.contrato.LectorService;

@Service
public class EditorialServiceImpl extends GenericoServiceImpl<Lector, LectorRepository> implements LectorService{

	@Autowired
	public EditorialServiceImpl(LectorRepository repo) {
		super(repo);
		// TODO Auto-generated constructor stub
	}
	

}
