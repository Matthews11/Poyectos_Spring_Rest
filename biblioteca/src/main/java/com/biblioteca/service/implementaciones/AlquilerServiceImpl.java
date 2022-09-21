package com.biblioteca.service.implementaciones;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biblioteca.entity.Alquiler;
import com.biblioteca.repositories.AlquilerRepository;
import com.biblioteca.service.contrato.AlquilerService;

@Service
public class AlquilerServiceImpl extends GenericoServiceImpl<Alquiler, AlquilerRepository> implements AlquilerService{

	@Autowired
	public AlquilerServiceImpl(AlquilerRepository repo) {
		super(repo);
		// TODO Auto-generated constructor stub
	}

}
