package com.biblioteca.service.implementaciones;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import com.biblioteca.entity.Editorial; 
import com.biblioteca.repositories.EditorialRepository; 
import com.biblioteca.service.contrato.EditorialService;

@Service
public class LectorServiceImpl extends GenericoServiceImpl<Editorial, EditorialRepository> implements EditorialService{

	@Autowired
	public LectorServiceImpl(EditorialRepository repo) {
		super(repo);
		// TODO Auto-generated constructor stub
	}
	

}
