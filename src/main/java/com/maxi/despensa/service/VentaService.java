package com.maxi.despensa.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maxi.despensa.dao.IClienteDAO;
import com.maxi.despensa.dao.IProductoDAO;
import com.maxi.despensa.dao.IVentaDAO;
import com.maxi.despensa.model.Cliente;
import com.maxi.despensa.model.Producto;
import com.maxi.despensa.model.Venta;

import jakarta.transaction.Transactional;

@Service
public class VentaService implements IVentaService{

	@Autowired
	private IVentaDAO ventaDAO;

    @Autowired
    private IProductoDAO productoDAO;
	
    @Autowired
    private IClienteDAO clienteDAO;
    
	@Override
	@Transactional
	   public void createVenta(Venta venta) {
        // Validar cliente
        Cliente cliDB = validateClient(venta.getCliente().getDni());
        
        // Validar productos y calcular el total
        Double total = validateProductsAndCalculateTotal(venta.getLista_productos());

        // Actualizar stock de productos
        updateStock(venta.getLista_productos());

        // Configurar detalles de la venta
        venta.setFecha_venta(LocalDate.now());
        venta.setTotal_venta(total);
        venta.setCliente(cliDB);

        // Guardar la venta
        ventaDAO.save(venta);
    }

    private Cliente validateClient(String dni) {
        Cliente cliDB = clienteDAO.findClienteByDni(dni);
        if (cliDB == null) {
            throw new RuntimeException("Cliente no encontrado");
        }
        return cliDB;
    }

    private Double validateProductsAndCalculateTotal(List<Producto> productos) {
        if (productos == null || productos.isEmpty()) {
            throw new RuntimeException("La lista de productos no puede estar vacía.");
        }

        Double total = 0.0;
        for (Producto producto : productos) {
            Producto prodFromDB = productoDAO.findById(producto.getId_producto()).orElse(null);
            if (prodFromDB == null) {
                throw new RuntimeException("Producto no encontrado: " + producto.getId_producto());
            }
            if (prodFromDB.getStock() < producto.getCantidad()) {
                throw new RuntimeException("No hay stock suficiente para el producto: " + prodFromDB.getNombre());
            }
            total += prodFromDB.getPrecio() * producto.getCantidad();
        }
        return total;
    }

    private void updateStock(List<Producto> productos) {
        for (Producto producto : productos) {
            Producto prodFromDB = productoDAO.findById(producto.getId_producto()).orElse(null);
            if (prodFromDB != null) {
                prodFromDB.setStock(prodFromDB.getStock() - producto.getCantidad());
                productoDAO.save(prodFromDB);
            }
        }
    }

	@Override
	public void deleteVenta(Long id) {
		ventaDAO.deleteById(id);
	}

	@Override
	public Venta getVentaById(Long id) {
		return ventaDAO.findById(id).orElse(null);
	}

	@Override
	public List<Venta> getVentas() {
		return ventaDAO.findAll();
	}

	@Override
	public Venta editVenta(Long id, Venta venta) {
		Venta ven = this.getVentaById(id);
	
		//ven.setFecha_venta(venta.getFecha_venta());
		ven.setCliente(venta.getCliente());
		//ven.setPrecio_unitario_producto(venta.getPrecio_unitario_producto());
		//ven.setTotal_venta(venta.getTotal_venta());
		ven.setObservacion(venta.getObservacion());
		return ventaDAO.save(ven);
	}



	
	
	
	
}
