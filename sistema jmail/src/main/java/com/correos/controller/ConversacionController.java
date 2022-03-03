package com.correos.controller;

import com.correos.entity.Conversaciones;
import com.correos.services.IConversacioneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("conversacion")
public class ConversacionController {

    @Autowired
    private IConversacioneService ICS;

    @GetMapping("/listar")
    private ResponseEntity<?> listar (){
        HashMap<String, Object> mensajes= new HashMap<>();
        List<Conversaciones> lista = ICS.listar();

        if(lista.size()>0){
           return new ResponseEntity<List<Conversaciones>>(lista, HttpStatus.OK);
        } else{
            mensajes.put("respuesta","No hay Conversaciones ");
            return new  ResponseEntity<Map<String,Object>>(mensajes,HttpStatus.INTERNAL_SERVER_ERROR);
        }


    }


}
