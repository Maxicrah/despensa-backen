package com.maxi.despensa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maxi.despensa.model.Cliente;
import com.maxi.despensa.service.IClienteService;

@RestController
@RequestMapping("clientes")
public class ClienteController {
	
	@Autowired
	private IClienteService cliServ;

	@PostMapping("/crear")
	public String createCliente(@RequestBody Cliente cli) {
		cliServ.createCliente(cli);
		return "Cliente creado pa";
	}
	
	@GetMapping("/traer/{id}")
	public Cliente getCliente(@PathVariable Long id) {
		return cliServ.findCliente(id);
	}
	
	@GetMapping("/traer")
	public List<Cliente> getClientes(){
		return cliServ.findClientes();
	}
	
	@DeleteMapping("/eliminar/{id}")
	public String deleteCliente(@PathVariable Long id) {
		 cliServ.deleteCliente(id);
		 return "Cliente eliminado rey";
	}
	
	@PutMapping("/editar/{id}")
	public Cliente editCliente(@PathVariable Long id, @RequestBody Cliente cli) {
		return cliServ.updateCliente(id, cli);
	}
	
	
}
