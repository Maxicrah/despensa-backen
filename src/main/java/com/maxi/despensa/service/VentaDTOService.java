package com.maxi.despensa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maxi.despensa.dao.IClienteDAO;
import com.maxi.despensa.dto.VentaDTO;
import com.maxi.despensa.model.Cliente;
import com.maxi.despensa.model.Venta;
@Service
public class VentaDTOService implements IVentaDTOService{

		
	@Autowired
	private IClienteDAO cliDAO;
	
	@Autowired
	private IVentaService ventServ;
	
	
	@Override
	public VentaDTO getVentaDTOByDniCliente(String dni, Long id) {
	
		Venta venta = this.ventServ.getVentaById(id);
		Cliente cliente = this.cliDAO.findClienteByDni(dni);
		
        if (venta == null) {
            throw new RuntimeException("Venta no encontrada con el ID: " + id);
        }

        if (cliente == null) {
            throw new RuntimeException("Cliente no encontrado con el DNI: " + dni);
        }
		
		VentaDTO ventaDTO = new VentaDTO();
		
	    ventaDTO.setId_venta(venta.getId_venta());
	    ventaDTO.setFecha_venta(venta.getFecha_venta());
	    ventaDTO.setTotal_venta(venta.getTotal_venta());
	    ventaDTO.setPrecio_unitario_producto(venta.getPrecio_unitario_producto());
	    ventaDTO.setNombre_cliente(cliente.getNombre());
	    ventaDTO.setApellido_cliente(cliente.getApellido());
	    ventaDTO.setDni(cliente.getDni());
	    ventaDTO.setDireccion(cliente.getDireccion());
	    ventaDTO.setLista_productos(venta.getLista_productos());
	        
		return ventaDTO;
	}
	
	
	

}
