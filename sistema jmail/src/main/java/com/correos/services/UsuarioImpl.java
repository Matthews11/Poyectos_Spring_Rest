package com.correos.services;

import com.correos.entity.Usuarios;
import com.correos.repository.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UsuarioImpl implements IUsuarioService {

    @Autowired
    private IUsuarioRepository Repository;


    @Override
    @Transactional(readOnly = true)
    public List<Usuarios> listar() {
        List<Usuarios> usuario = (List<Usuarios>) Repository.findAll();
        return usuario;
    }

    @Override
    @Transactional
    public Usuarios insertar(Usuarios usuario) {

        return Repository.save(usuario);
    }

    @Override
    @Transactional(readOnly=true)
    public Usuarios obtener(long id) {

        return Repository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void eliminar(long id) {
        Repository.deleteById(id);

    }
}
