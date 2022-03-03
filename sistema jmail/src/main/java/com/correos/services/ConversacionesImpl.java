package com.correos.services;

import com.correos.entity.Conversaciones;
import com.correos.repository.IConversacionesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class ConversacionesImpl implements IConversacioneService{

    @Autowired
    private IConversacionesRepository conversacionesRepo;

    @Override
    @Transactional(readOnly = true)
    public List<Conversaciones> listar() {
        return conversacionesRepo.findAll();
    }

    @Override
    @Transactional()
    public Conversaciones ingresar(Conversaciones conversaciones) {
        return conversacionesRepo.save(conversaciones);
    }

    @Override
    @Transactional(readOnly=true)
    public Conversaciones obtener(long id) {
        return conversacionesRepo.findById(id).orElse(null);
    }

    @Override
    public void eliminar(long id) {
        conversacionesRepo.deleteById(id);
    }
}
