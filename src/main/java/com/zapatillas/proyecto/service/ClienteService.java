package com.zapatillas.proyecto.service;

import com.zapatillas.proyecto.model.bd.Cliente;
import com.zapatillas.proyecto.model.dto.ClienteDto;
import com.zapatillas.proyecto.repository.ClienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ClienteService implements IClienteService {
    private final ClienteRepository clienteRepository;

    @Override
    public Cliente obtenerClientePorUsername(String username) {
        return clienteRepository.findByUsername(username);
    }

    @Override
    public Cliente guardarCliente(ClienteDto clienteDto) {
        Cliente cliente = new Cliente();
        cliente.setUsername(clienteDto.getUsername());
        cliente.setPassword(clienteDto.getPassword());
        cliente.setNombrecliente(clienteDto.getNombrecliente());
        cliente.setApellidocliente(clienteDto.getApellidocliente());
        cliente.setSexo(clienteDto.getSexo());
        cliente.setFechanacimiento(clienteDto.getFechanacimiento());
        cliente.setEmailcliente(clienteDto.getEmailcliente());
        cliente.setTelefonocliente(clienteDto.getTelefonocliente());
        cliente.setDireccion(clienteDto.getDireccion());
        cliente.setActivo(clienteDto.getActivo());
        // Mapea otros campos según sea necesario
        return clienteRepository.save(cliente);
    }

    @Override
    public Cliente actualizarCliente(ClienteDto clienteDto) {
        Cliente cliente = clienteRepository.findById(clienteDto.getIdcliente()).orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
        cliente.setUsername(clienteDto.getUsername());
        cliente.setPassword(clienteDto.getPassword());
        cliente.setNombrecliente(clienteDto.getNombrecliente());
        cliente.setApellidocliente(clienteDto.getApellidocliente());
        cliente.setSexo(clienteDto.getSexo());
        cliente.setFechanacimiento(clienteDto.getFechanacimiento());
        cliente.setEmailcliente(clienteDto.getEmailcliente());
        cliente.setTelefonocliente(clienteDto.getTelefonocliente());
        cliente.setDireccion(clienteDto.getDireccion());
        cliente.setActivo(clienteDto.getActivo());
        // Actualiza otros campos según sea necesario
        return clienteRepository.save(cliente);
    }

    @Override
    public void eliminarClientePorId(Integer id) {
        clienteRepository.deleteById(id);
    }

    @Override
    public List<Cliente> listarClientes() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente obtenerClientePorId(Integer id) {
        return clienteRepository.findById(id).orElse(null);
    }
}
