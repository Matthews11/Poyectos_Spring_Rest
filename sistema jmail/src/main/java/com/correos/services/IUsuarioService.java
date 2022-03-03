package com.correos.services;

import com.correos.entity.Usuarios;

import java.util.List;

public interface IUsuarioService {

     List<Usuarios> listar();

     Usuarios insertar(Usuarios usuario);

     Usuarios obtener(long usuario);

     void eliminar(long id);

}
