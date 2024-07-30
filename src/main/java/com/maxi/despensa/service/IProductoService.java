package com.maxi.despensa.service;

import java.util.List;


import com.maxi.despensa.model.Producto;

public interface IProductoService {

	//crear producto
	public Producto createProduct(Producto prod);
	//eliminar producto
	public void deleteProduct(Long id);
	//traer lista productos
	public List<Producto> getProductos();
	//traer un producto
	public Producto getProducto(Long id);
	//editar prpoducto
	public Producto editProduct(Long id, Producto prod);
	
}
