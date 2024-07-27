package com.maxi.despensa.service;

import com.maxi.despensa.dto.ProductoDTO;
import com.maxi.despensa.dto.ProveedorDTO;
import com.maxi.despensa.model.Producto;
import com.maxi.despensa.model.Proveedor;

public interface IProveedorServiceDTO {

	//buscar proveedor por nombre
	public ProveedorDTO findProveedorByName(String nombre);
	
	//convertir a dto proveedor
	public ProveedorDTO convertToDTO(Proveedor proveedor);
	
	//convertir a dto producto
	public ProductoDTO convertProductoToDTO(Producto prod);
	
	
}
