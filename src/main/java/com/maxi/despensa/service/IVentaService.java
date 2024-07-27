package com.maxi.despensa.service;

import java.util.List;

import com.maxi.despensa.model.Venta;

public interface IVentaService {

	//crear venta
	public void createVenta(Venta venta);
	//eliminar venta
	public void deleteVenta(Long id);
	//traer venta por id
	public Venta getVentaById(Long id);
	//traer todas las ventas
	public List<Venta> getVentas();
	//editar una venta
	public Venta editVenta(Long id, Venta venta);
}
