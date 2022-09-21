package com.biblioteca.service.contrato;

import java.util.List;
import java.util.Optional;

public interface GenericoService<E> {
	
	Optional<E> obtener(Long id);

	List<E> listar();
	
	E crear(E e);
	
	void eliminar(Long id);
	
}
