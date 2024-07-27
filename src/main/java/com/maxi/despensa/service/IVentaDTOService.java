package com.maxi.despensa.service;

import com.maxi.despensa.dto.VentaDTO;

public interface IVentaDTOService{

	//traer la venta que se realizo a un cliente pasando el dni como parametro 
	public VentaDTO getVentaDTOByDniCliente(String dni, Long id);
	
	
	
}
