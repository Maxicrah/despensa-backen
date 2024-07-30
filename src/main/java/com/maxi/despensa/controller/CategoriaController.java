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

import com.maxi.despensa.model.Categoria;
import com.maxi.despensa.service.ICategoriaService;

@RestController
@RequestMapping("categoria")
public class CategoriaController {

	@Autowired
	private ICategoriaService catServ;
	
	
	@PostMapping("crear")
	public String createCategoria(@RequestBody Categoria cat) {
		catServ.createCategoria(cat);
		return "Creado";
	}
	
	@GetMapping("traer/{id}")
	public Categoria getCategoria(@PathVariable Long id) {
		return catServ.getCategoria(id);
	}
	
	@GetMapping("traer")
	public List<Categoria> getCategorias(){
		return catServ.getCategorias();
	}
	
	@DeleteMapping("eliminar/{id}")
	public String deleteCategoria(@PathVariable Long id) {
		catServ.deleteCategoria(id);
		return "Eliminado pa";
	}
	
	@PutMapping("editar/{id}")
	public Categoria editCategoria(@PathVariable Long id,@RequestBody Categoria cat) {
		return catServ.editCategoria(id, cat);
	}
	
	
	
}
