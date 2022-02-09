package com.retotecnico.main.controller;

import com.retotecnico.main.dto.ClienteDTO;
import com.retotecnico.main.dto.ResponseDTO;
import com.retotecnico.main.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("api/clientes")
public class ClienteController {
    
    @Autowired
    ClienteService service;
    
    
    @PostMapping(path = "/crea",produces = "application/json", consumes = "application/json")
    public ResponseEntity<ResponseDTO> creaCliente(@RequestBody ClienteDTO cliente){
        ResponseDTO response = service.registrar(cliente);
        return ResponseEntity.ok().body(new ResponseDTO(response.getData(), response.getMessage()));
    }
    
    @PutMapping(path = "/actualizar",produces = "application/json", consumes = "application/json")
    public ResponseEntity<ResponseDTO> actualizarCliente(@RequestBody ClienteDTO cliente){
        ResponseDTO response = service.actualizar(cliente);
        return ResponseEntity.ok().body(new ResponseDTO(response.getData(), response.getMessage()));
    }
    
    @GetMapping(path = "/{id}", produces = "application/json")
    public ResponseEntity<ResponseDTO> consulta(@PathVariable int id){
        ResponseDTO response = service.consultar(id);
        return ResponseEntity.ok().body(new ResponseDTO(response.getData(),response.getMessage()));
    }
    
    @DeleteMapping(path = "/{id}", produces = "application/json")
    public ResponseEntity<ResponseDTO> eliminar(@PathVariable int id){
        ResponseDTO response = service.eliminar(id);
        return ResponseEntity.ok().body(new ResponseDTO(response.getData(),response.getMessage()));
    }
    
    @GetMapping(path = "/", produces = "application/json")
    public ResponseEntity<ResponseDTO> list(){
        ResponseDTO response = service.listado();
        return ResponseEntity.ok().body(new ResponseDTO(response.getData(), response.getMessage()));
    }
}
