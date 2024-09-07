package com.maxi.despensa.service;

import java.util.List;

import com.maxi.despensa.model.Cliente;

public interface IClienteService{
	//buscar un cliente
	public Cliente findCliente(Long id);
	//eliminar cliente
	public void deleteCliente(Long id);
	//eliminar cliente por dni
	public void deleteClienteByDni(String dni);
	//crear cliente
	public void createCliente(Cliente cli);
	//traer todos los clientes
	public List<Cliente> findClientes();
	//modificar cliente
	public Cliente updateCliente(Long id, Cliente cli);
	//buscar cliente por dni
	public Cliente findClienteByDni(String dni);
	
}
