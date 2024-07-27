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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.maxi.despensa.dto.ProveedorDTO;
import com.maxi.despensa.model.Proveedor;
import com.maxi.despensa.service.IProveedorService;
import com.maxi.despensa.service.IProveedorServiceDTO;

@RestController
@RequestMapping("/proveedor")
public class ProveedorController {

	@Autowired
	private IProveedorService provServ;
	
	@Autowired
	private IProveedorServiceDTO provDTOServ;
	
	@PostMapping("/crear")
	public String crearProveedor(@RequestBody Proveedor prov) {
		 provServ.createProveedor(prov);
		 return "Proveedor creado";
	}
	
	@GetMapping("buscar/{nombre}")
	@ResponseBody
	public ProveedorDTO findProveedorByNombre(@PathVariable String nombre) {
		return provDTOServ.findProveedorByName(nombre);
	}
	
	@GetMapping("/{id}")
	@ResponseBody
	public Proveedor getProveedor(@PathVariable Long id) {
		return provServ.getProveedorById(id);
	}
	
	@GetMapping("lista-proveedores")
	@ResponseBody
	public List<Proveedor> getProveedores(){
		return provServ.getProveedores();
	}
	
	@DeleteMapping("/eliminar/{id}")
	public String deleteProveedor(@PathVariable Long id) {
		provServ.deleteProveedor(id);
		return "Proveedor eliminado";
	}
	
	@PutMapping("/editar/{id}")
	public Proveedor editarProveedor(@PathVariable Long id,@RequestBody Proveedor prov) {
		return provServ.updateProveedor(id, prov);
	}
	
	
}
