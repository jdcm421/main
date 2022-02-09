package com.retotecnico.main.service.impl;

import com.retotecnico.main.dto.ClienteDTO;
import com.retotecnico.main.dto.ResponseDTO;
import com.retotecnico.main.entity.Cliente;
import com.retotecnico.main.repository.ClienteRepository;
import com.retotecnico.main.service.ClienteService;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class ClienteServiceImpl implements ClienteService {

    private static final Logger LOG = LoggerFactory.getLogger(ClienteServiceImpl.class);
    
    @Autowired
    ClienteRepository clienteRepository;
    
    @Override
    public ResponseDTO registrar(ClienteDTO clienteDTO) {
        try{
            Cliente client = new Cliente();
            client.setFirstName(clienteDTO.getFirstName());
            client.setLastName(clienteDTO.getLastName());
            client.setPassword(clienteDTO.getPassword());
            client.setSex(clienteDTO.getSex());
            client.setEmail(clienteDTO.getEmail());
            client.setPhone(clienteDTO.getPhone());
            client = clienteRepository.save(client);
            return new ResponseDTO(client, HttpStatus.CREATED.toString());
        }catch(Exception ex){
            LOG.error("Ocurrio un error", ex);
            return new ResponseDTO(null, HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(), ex.getMessage());
        }
    }

    @Override
    public ResponseDTO actualizar(ClienteDTO clienteDTO) {
        try{
            Cliente client = clienteRepository.getById(clienteDTO.getId());
            client.setFirstName(clienteDTO.getFirstName());
            client.setLastName(clienteDTO.getLastName());
            client.setPassword(clienteDTO.getPassword());
            client.setSex(clienteDTO.getSex());
            client.setEmail(clienteDTO.getEmail());
            client.setPhone(clienteDTO.getPhone());
            client = clienteRepository.save(client);
            return new ResponseDTO(client, HttpStatus.OK.toString());
        }catch(Exception ex){
            LOG.error("Ocurrio un error", ex);
            return new ResponseDTO(null, HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(), ex.getMessage());
        }
    }

    @Override
    public ResponseDTO consultar(int id) {
        try{
            Cliente cliente = clienteRepository.getById(id);
            ClienteDTO client = new ClienteDTO();
            client.setId(cliente.getId());
            client.setFirstName(cliente.getFirstName());
            client.setLastName(cliente.getLastName());
            client.setPassword(cliente.getPassword());
            client.setSex(cliente.getSex());
            client.setEmail(cliente.getEmail());
            client.setPhone(cliente.getPhone());
            return new ResponseDTO(client, HttpStatus.OK.toString());
        }catch(Exception ex){
            LOG.error("Ocurrio un error", ex);
            return new ResponseDTO(null, HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(), ex.getMessage());
        }
     }

    @Override
    public ResponseDTO eliminar(int id) {
        try{
            clienteRepository.deleteById(id);
            return new ResponseDTO(null, HttpStatus.OK.toString());
        }catch(Exception ex){
            LOG.error("Ocurrio un error", ex);
            return new ResponseDTO(null, HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(), ex.getMessage());
        }
    }

    @Override
    public ResponseDTO listado() {
        List<Cliente> listado = clienteRepository.findAll();
        return new ResponseDTO(listado, HttpStatus.OK.getReasonPhrase());
    }
    
}
