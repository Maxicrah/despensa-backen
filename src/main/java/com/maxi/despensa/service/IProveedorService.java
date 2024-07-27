package com.maxi.despensa.service;

import java.util.List;

import com.maxi.despensa.model.Proveedor;

public interface IProveedorService {

	//dar de alta proveedor
	public void createProveedor(Proveedor prov);
	
	//traer proveedor por id
	public Proveedor getProveedorById(Long id);
	

	
	//traer todos proveedores
	public List<Proveedor> getProveedores();
	
	//eliminar proveedor
	public void deleteProveedor(Long id);
	
	//modificar proveedor
	public Proveedor updateProveedor(Long id, Proveedor prov);
	
	
}
