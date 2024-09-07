package com.maxi.despensa.service;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maxi.despensa.dao.IProveedorDAO;
import com.maxi.despensa.dto.ProductoDTO;
import com.maxi.despensa.dto.ProveedorDTO;
import com.maxi.despensa.model.Producto;
import com.maxi.despensa.model.Proveedor;

@Service
public class ProveedorDTOService implements IProveedorServiceDTO{

	@Autowired
	private IProveedorDAO provDAO;
	
	
	@Override
	public ProveedorDTO findProveedorByName(String nombre) {
		 Proveedor proveedor = provDAO.findProveedorByName(nombre);
	     return convertToDTO(proveedor);
	}


	@Override
	public ProveedorDTO convertToDTO(Proveedor proveedor) {
		
		ProveedorDTO provDto = new ProveedorDTO();
		provDto.setNombre(proveedor.getNombre());
		provDto.setId_proveedor(proveedor.getId_proveedor());
		provDto.setDireccion(proveedor.getDireccion());
		provDto.setDni(proveedor.getDni());
		provDto.setLista_productos(proveedor.getLista_productos().stream()
				.map(this::convertProductoToDTO).collect(Collectors.toList())
				);
		
		return provDto;
	}


	@Override
	public ProductoDTO convertProductoToDTO(Producto prod) {

		 ProductoDTO dto = new ProductoDTO();
	        dto.setNombre(prod.getNombre());
	        dto.setDescripcion(prod.getDescripcion());
	        dto.setPrecio(prod.getPrecio());
	        dto.setImagen(prod.getImagen());
	        dto.setMarca(prod.getMarca());
	        dto.setPromocion(prod.getPromocion());
	        dto.setNotas_adicionales(prod.getNotas_adicionales());
	        return dto;
	}
}
