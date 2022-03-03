package com.correos.services;

import com.correos.entity.Estados;

import java.util.List;

public interface IEstadosService {

    List<Estados> listar();

    Estados insertar(Estados estados);

    Estados Obtener (long id);

    void eliminar(long id);
}
