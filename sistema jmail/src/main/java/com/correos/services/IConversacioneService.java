package com.correos.services;

import com.correos.entity.Conversaciones;

import java.util.List;

public interface IConversacioneService {

    List<Conversaciones> listar();

    Conversaciones ingresar(Conversaciones conversaciones);

    Conversaciones obtener(long id);

    void eliminar (long id);

}
