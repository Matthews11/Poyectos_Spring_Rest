package com.correos.controller;

import com.correos.entity.Usuarios;
import com.correos.services.IUsuarioService;
import com.correos.services.UsuarioImpl;
import com.sun.source.tree.TryTree;
import org.hibernate.exception.DataException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private IUsuarioService usuarioService;

    private Usuarios usuarios = null;

    @GetMapping("/listar")
    public ResponseEntity<?> listar(){
        List<Usuarios> usuario = usuarioService.listar();
        Map<String,Object> mensajes = new HashMap<>();

        if(usuario.size()>0){
            return new ResponseEntity<List<Usuarios>>(usuario, HttpStatus.OK);
        } else {
            mensajes.put("respuesta","No hay registros en las base de datos ");
            return new ResponseEntity<Map<String,Object>>(mensajes,HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

    @PostMapping("/ingresar")
    public ResponseEntity<?> ingresar(@RequestBody Usuarios usuario){
        Map<String,Object> mensajes = new HashMap<>();

        try {
            usuarios= usuarioService.insertar(usuario);
        }catch (DataAccessException ex){
            mensajes.put("respuesta","Error al realizar la consulta a la base de datos ");
            mensajes.put("error",ex.getMessage().concat(": ").concat(ex.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String,Object>>(mensajes,HttpStatus.INTERNAL_SERVER_ERROR);

        }
        mensajes.put("exito"," Usuario creado con exito");
        return new ResponseEntity<Map<String,Object>>(mensajes,HttpStatus.CREATED);
    }

    @PutMapping ("/actualizar/{id}")
    public ResponseEntity<?> actualizar(@PathVariable("id")Long id, @RequestBody Usuarios usuario){
        usuarios=usuarioService.obtener(id);
        Usuarios usuarioModificado = null;
        Map<String,Object> mensaje= new HashMap<>();

        if (usuarios==null){
            mensaje.put("respuesta","El ID: "+id + " no existe en la base de datos");
        }else {
         try{
            usuarios.setNombre(usuario.getNombre());
            usuarios.setApellido(usuario.getApellido());
            usuarios.setCorreo(usuario.getCorreo());
            usuarios.setContrasena(usuario.getContrasena());
            usuarioModificado= usuarioService.insertar(usuarios);
        } catch (DataAccessException ex){
             mensaje.put("respuesta","Error al realizar la consulta a la base de datos");
             mensaje.put("error",ex.getMessage().concat(": ").concat(ex.getMostSpecificCause().getMessage()));
             return new ResponseEntity<Map<String,Object>>(mensaje,HttpStatus.INTERNAL_SERVER_ERROR);
         }
        }

        mensaje.put("respuesta","El usuario ha sido actualizado con exito");
        mensaje.put("usuario",usuarioModificado);
        return new ResponseEntity<Map<String,Object>>(mensaje,HttpStatus.CREATED);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminar(@PathVariable ("id") Long id){
        Map<String, Object> mensaje = new HashMap<>();

        try {
            usuarioService.eliminar(id);
        }catch (DataAccessException ex){
                mensaje.put("respuesta","Error al realizar la consulta a la base de datos");
                mensaje.put("error",ex.getMessage().concat(": ").concat(ex.getMostSpecificCause().getMessage()));
                return new ResponseEntity<Map<String,Object>>(mensaje,HttpStatus.INTERNAL_SERVER_ERROR);
        }
        mensaje.put("respuesta","El usuario se elimino con exito");
        return new ResponseEntity<Map<String,Object>>(mensaje,HttpStatus.OK);
    }

    @GetMapping("/obtener/{id}")
    public ResponseEntity<?> obtener(@PathVariable("id") Long id){
        Usuarios buscado = null;
        Map<String,Object>mensajes = new HashMap<>();

        try{
            buscado=usuarioService.obtener(id);
           if ( buscado==null){
                mensajes.put("respuesta","No existe ese registro en la base de datos");
                return new ResponseEntity<Map<String,Object>>(mensajes,HttpStatus.INTERNAL_SERVER_ERROR);
           }
        }catch (DataAccessException ex){
            mensajes.put("respuesta","Error al realizar la consulta a la base de datos");
            mensajes.put("error",ex.getMessage().concat(ex.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String,Object>>(mensajes,HttpStatus.INTERNAL_SERVER_ERROR);
        }
        mensajes.put("repuesta","Su registro es este");
        mensajes.put("usuario",buscado);
        return new ResponseEntity<Map<String,Object>>(mensajes,HttpStatus.OK);
    }


}
