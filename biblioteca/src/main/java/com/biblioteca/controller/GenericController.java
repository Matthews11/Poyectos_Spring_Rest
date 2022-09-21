package com.biblioteca.controller;


 
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import com.biblioteca.service.contrato.GenericoService;

import javax.validation.Valid;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class GenericController <E,S extends GenericoService<E>> {

    protected final S servicio;

    protected String nombreEntidad;
    
   
    public GenericController(S servicio) {
        this.servicio = servicio;
    }

    @GetMapping("/listar")
    public ResponseEntity<?> listar() {
    	 Map<String, Object> mensajes= new HashMap<>();
        List<E> lista = (List<E>) servicio.listar();
        if (lista.isEmpty()) {
        	mensajes.put("respuesta", "la lista esta vacias");
        	return new ResponseEntity< Map<String, Object>>(mensajes,HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<List<E>>(lista,HttpStatus.ACCEPTED);
        }
    }


    @GetMapping(value = "/obtener/{codigo}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> obtener(@PathVariable(value = "codigo",required = false)Long id){
    	 Map<String, Object> mensajes= new HashMap<>();
        Optional<E> carreraOptional = servicio.obtener(id);
        if (!carreraOptional.isPresent()){
        	mensajes.put("respuesta", "No se encontro");
        	return new ResponseEntity< Map<String, Object>>(mensajes,HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<E>( carreraOptional.get(),HttpStatus.ACCEPTED);
    }

    @PostMapping(value = "/crear",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> crear(@RequestBody @Valid E e, BindingResult validar){
    	List<String> errores = new ArrayList<>();
    	Map<String, Object> mensajes= new HashMap<>();
    	
        if (validar.hasErrors()) {
        	 errores.clear();
        	
        	 for (FieldError errorCampos: validar.getFieldErrors()) {
                 errores.add("El campo '"+errorCampos.getField()+"' "+errorCampos.getDefaultMessage());
             }
             mensajes.put("error",errores);
             return new ResponseEntity<Map<String, Object>>(mensajes, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<E>(servicio.crear(e),HttpStatus.CREATED);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminar(@PathVariable Long id){
        servicio.eliminar(id);
    }


}