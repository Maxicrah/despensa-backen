package com.maxi.despensa.service;

import java.util.List;

import com.maxi.despensa.model.Categoria;

public interface ICategoriaService {

	//crear categoria
	public Categoria createCategoria(Categoria cat);

	//eliminar categoria
	public void deleteCategoria(Long id);

	//traer categoria 
	public Categoria getCategoria(Long id);
	
	//traer todas las categorias
	public List<Categoria> getCategorias();
	
	//editar categoria
	public Categoria editCategoria(Long id, Categoria cat);
	
	
}
