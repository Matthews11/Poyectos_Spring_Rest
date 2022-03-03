package com.correos.controller;

import com.correos.entity.Estados;
import com.correos.services.EstadosImpl;
import com.correos.services.IEstadosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/estados")
public class EstadosController {

    @Autowired
    private IEstadosService estadosService;

    private Estados estados;

    @GetMapping("/listar")
    public ResponseEntity<?> listar(){
        List<Estados> lista = estadosService.listar();
        Map<String,Object> mensajes = new HashMap<>();

            if(lista.size()>0){
                return new ResponseEntity<List<Estados>>(lista, HttpStatus.OK);
            }else{
                mensajes.put("respuesta","No hay registros en la base de datos");
                return new ResponseEntity<Map<String,Object>>(mensajes,HttpStatus.INTERNAL_SERVER_ERROR);

            }

    }

    @PostMapping("/ingresar")
    public ResponseEntity<?> ingresar(@RequestBody Estados estado){
        Map<String,Object> mensajes = new HashMap<>();

        try{
            estados = estadosService.insertar(estado);
        }catch (DataAccessException ex){
            mensajes.put("respuesta","No se pudo realizar la consulta a la base de datos ");
            mensajes.put("error",ex.getMessage().concat(": ".concat(ex.getMostSpecificCause().getMessage())));
            return new ResponseEntity<Map<String,Object>>(mensajes,HttpStatus.INTERNAL_SERVER_ERROR);

        }

        mensajes.put("respuesta","Estado registrado en la base de datos ");
        return new ResponseEntity<Map<String,Object>>(mensajes,HttpStatus.CREATED);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<?> actualizar(@PathVariable("id") Long id,  @RequestBody Estados estado){
        Map<String,Object> mensaje = new HashMap<>();
        Estados eModificado=null;
        Estados estadoActual = estadosService.Obtener(id);

        if (estadoActual == null){
            mensaje.put("respuesta","El "+ id+ "No existe en la base de datos");
        }else{
            try{
                estadoActual.setEstado(estado.getEstado());
                eModificado=estadosService.insertar(estadoActual);
            }catch(DataAccessException ex){
                mensaje.put("respuesta","No se pudo realizar la consulta a la base de datos");
                mensaje.put("error",ex.getMessage().concat(": ").concat(ex.getMostSpecificCause().getMessage()));
                return new ResponseEntity<Map<String,Object>>(mensaje,HttpStatus.INTERNAL_SERVER_ERROR);
            }


        }
        mensaje.put("respuesta","Estado actualizado con exito");
        mensaje.put("estado",eModificado);
        return new ResponseEntity<Map<String,Object>>(mensaje,HttpStatus.CREATED);
    }

    @GetMapping("/obtener/{id}")
    public ResponseEntity<?> obtener(@PathVariable("id") Long id){
        Map<String,Object> mensajes = new HashMap<>();

        try {
            estados = estadosService.Obtener(id);

            if(estados==null){
                mensajes.put("respuesta","El registro no exite en la base de datos");
                return new ResponseEntity<Map<String,Object>>(mensajes,HttpStatus.INTERNAL_SERVER_ERROR);
            }

        }catch (DataAccessException ex){
            mensajes.put("respuesta","No se realiazo la consulta a la base de datos");
            mensajes.put("error",ex.getMessage().concat(": ").concat(ex.getMostSpecificCause().getMessage()));

        }
        mensajes.put("respuesta","el registro es el siguiente");
        mensajes.put("estados",estados);
        return new ResponseEntity<Map<String,Object>>(mensajes,HttpStatus.OK);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminar(@PathVariable("id") Long id){
            Map<String,Object> mensajes = new HashMap<>();

            try {
             estadosService.eliminar(id);
            }catch (DataAccessException ex){
                mensajes.put("respuesta","No se realizo la consulta a la base de datos");
                mensajes.put("error",ex.getMessage().concat(": ").concat(ex.getMostSpecificCause().getMessage()));
            }
            mensajes.put("respuesta","El registro se elimino");
            return new ResponseEntity<Map<String,Object>>(mensajes,HttpStatus.OK);
    }
}
