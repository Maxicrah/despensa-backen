package com.maxi.despensa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maxi.despensa.dao.IClienteDAO;
import com.maxi.despensa.model.Cliente;

@Service
public class ClienteService implements IClienteService{

	@Autowired
	private IClienteDAO clienteDAO;
	
	@Override
	public Cliente findCliente(Long id) {
		try {
			return clienteDAO.findById(id).orElse(null);
		}catch(Exception e) {
			System.out.println("error: " + e);
			return null;
		}
	}

	@Override
	public void deleteCliente(Long id) {
		clienteDAO.deleteById(id);
	}

	@Override
	 public void createCliente(Cliente cli) {
        //buscar si ya existe un cliente con el mismo DNI
        Cliente clienteExistente = clienteDAO.findClienteByDni(cli.getDni());
        
        //si clienteExistente no es null, significa que ya hay un cliente con ese DNI
        if (clienteExistente != null) {
            throw new RuntimeException("Cliente con DNI repetido: " + cli.getDni());
        }
        clienteDAO.save(cli);
    }

	@Override
	public List<Cliente> findClientes() {
		return clienteDAO.findAll();
	}

	@Override
	public Cliente updateCliente(Long id, Cliente cli) {
		Cliente cliente = this.findCliente(id);
		
		cliente.setNombre(cli.getNombre());
		cliente.setApellido(cli.getApellido());
		cliente.setDireccion(cli.getDireccion());
		cliente.setDni(cli.getDni());
		cliente.setEmail(cli.getEmail());
		cliente.setFecha_registro(cli.getFecha_registro());
		cliente.setTelefono(cli.getTelefono());
		
		return clienteDAO.save(cliente);
	}

	@Override
	public Cliente findClienteByDni(String dni) {
		return clienteDAO.findClienteByDni(dni);
	}

	@Override
	public void deleteClienteByDni(String dni) {
		clienteDAO.delete(this.findClienteByDni(dni));
	}

}
