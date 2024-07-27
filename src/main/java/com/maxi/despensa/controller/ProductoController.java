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

import com.maxi.despensa.model.Producto;
import com.maxi.despensa.service.IProductoService;

@RestController
@RequestMapping("/productos")
public class ProductoController {

	@Autowired
	private IProductoService prodServ;
	
	@PostMapping("/crear")
	public String createProduct(@RequestBody Producto prod) {
		prodServ.createProduct(prod);
		return "creado pibe";
	}
	
	@GetMapping("/traer/{id}")
	public Producto getProduct(@PathVariable(required = true) Long id) {
		return prodServ.getProducto(id);
	}
	
	@GetMapping("/traer")
	public List<Producto> getProducts(){
		return prodServ.getProductos();
	}
	
	@DeleteMapping("/eliminar/{id}")
	public String deleteProducto(@PathVariable (required = true) Long id) {
		prodServ.deleteProduct(id);
		return "eliminado pibe";
	}
	
	@PutMapping("/editar/{id}")
	public Producto editProduct(@PathVariable (required = true) Long id, @RequestBody Producto prod) {
		return prodServ.editProduct(id, prod);
	}
}
