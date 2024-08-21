package com.zapatillas.proyecto.service;

import com.zapatillas.proyecto.model.bd.Cliente;
import com.zapatillas.proyecto.model.dto.ClienteDto;

import java.util.List;

public interface IClienteService {
    Cliente obtenerClientePorUsername(String username);
    Cliente guardarCliente(ClienteDto clienteDto);
    Cliente actualizarCliente(ClienteDto clienteDto);
    void eliminarClientePorId(Integer id);
    List<Cliente> listarClientes();
    Cliente obtenerClientePorId(Integer id);
}

