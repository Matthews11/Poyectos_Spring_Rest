package com.correos.services;

import com.correos.entity.Estados;
import com.correos.repository.IEstadosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class EstadosImpl implements IEstadosService{

    @Autowired
   private IEstadosRepository estadosRepo;

    @Override
    @Transactional(readOnly =true)
    public List<Estados> listar() {
        return estadosRepo.findAll();
    }

    @Override
    @Transactional()
    public Estados insertar(Estados estados) {
        return estadosRepo.save(estados);
    }

    @Override
    @Transactional(readOnly = true)
    public Estados Obtener(long id) {
        return estadosRepo.findById(id).orElse(null);
    }

    @Override
    @Transactional()
    public void eliminar(long id) {

        estadosRepo.deleteById(id);

    }
}
