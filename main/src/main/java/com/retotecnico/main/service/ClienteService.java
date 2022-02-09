package com.retotecnico.main.service;

import com.retotecnico.main.dto.ClienteDTO;
import com.retotecnico.main.dto.ResponseDTO;


public interface ClienteService {
    
    public ResponseDTO registrar(ClienteDTO clienteDTO);
    public ResponseDTO actualizar(ClienteDTO clienteDTO);
    public ResponseDTO consultar(int id);
    public ResponseDTO eliminar(int id);
    public ResponseDTO listado();
}
