package com.maxi.despensa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maxi.despensa.dao.IProveedorDAO;
import com.maxi.despensa.model.Producto;
import com.maxi.despensa.model.Proveedor;

@Service
public class ProveedorService implements IProveedorService{

	@Autowired
	private IProveedorDAO provDAO;
	
	
	@Override
	public void createProveedor(Proveedor prov) {
				
		if(prov.getLista_productos().isEmpty() || prov.getLista_productos() == null) {
			 throw new IllegalArgumentException("La lista de productos no puede estar vacía");
		}
        // verificar si la lista contiene productos vacíos o nulos
        for (Producto producto : prov.getLista_productos()) {
            if (producto == null || producto.getId_producto() == null) {
                throw new IllegalArgumentException("La lista de productos contiene productos vacíos o nulos");
            }
        }
		 provDAO.save(prov);
	}

	@Override
	public Proveedor getProveedorById(Long id) {
		return provDAO.findById(id).orElse(null);
	}

	@Override
	public List<Proveedor> getProveedores() {
		return provDAO.findAll();
	}

	@Override
	public void deleteProveedor(Long id) {
		provDAO.deleteById(id);
	}

	
	
	
	@Override
	public Proveedor updateProveedor(Long id, Proveedor prov) {
		
		Proveedor proveedor = this.getProveedorById(id);

		proveedor.setNombre(prov.getNombre());
		proveedor.setDni(prov.getDni());
		proveedor.setEmail(prov.getEmail());
		proveedor.setDireccion(prov.getDireccion());
		proveedor.setNro_telefono(prov.getNro_telefono());
		proveedor.setObs(prov.getObs());
		proveedor.setLista_productos(prov.getLista_productos());
		
		provDAO.save(proveedor);
		return proveedor;
	}



	
	
}
