package com.jared.ejemplos.springboot.registro.app.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.jared.ejemplos.springboot.registro.app.modelo.Pais;

@Service
public class PaisServiceImpl implements PaisService {

	private List<Pais> list;

	public PaisServiceImpl() {
		this.list = Arrays.asList(new Pais(1, "ES", "Espana"), new Pais(2, "MX", "Mexico"), new Pais(3, "I", "Italia"));

	}

	@Override
	public List<Pais> listar() {
		// TODO Auto-generated method stub
		return list;
	}

	@Override
	public Pais obtenerID(Integer id) {
		Pais resultado = null;
		for (Pais pais : this.list) {
			if (id == pais.getId()) {

				resultado = pais;
				break;
			}
		}
		return resultado;
	}

}
