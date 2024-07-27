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
        Cliente cliDB = clienteDAO.findClienteByDni(venta.getCliente().getDni());
        Double total = 0.0;
        if (cliDB == null) {
            throw new RuntimeException("Cliente no encontrado");
        }

        List<Producto> productos = venta.getLista_productos();
        
        for (Producto producto : productos) {
            Producto prodFromDB = productoDAO.findById(producto.getId_producto()).orElse(null);
            
            if (prodFromDB == null) {
                System.out.println("Producto no encontrado en la base de datos: " + producto.getId_producto());
                throw new RuntimeException("Producto no encontrado: " + producto.getId_producto());
            }

            if (prodFromDB.getStock() <= 0) {
                System.out.println("No hay stock suficiente para el producto: " + prodFromDB.getNombre());
                throw new RuntimeException("No hay stock suficiente para el producto: " + prodFromDB.getNombre());
            }
            //asignar precio unitario producto a venta
            venta.setPrecio_unitario_producto(prodFromDB.getPrecio());
            //Calcular total venta
            total += prodFromDB.getPrecio();
            // Decrementar el stock
            prodFromDB.setStock(prodFromDB.getStock() - 1);
            productoDAO.save(prodFromDB); // Guarda los cambios en el producto

            // Reemplazar el producto desacoplado por el producto gestionado
            int index = productos.indexOf(producto);
            productos.set(index, prodFromDB);
            
        }
        //asignar fecha actual a venta
        venta.setFecha_venta(LocalDate.now());
        
        //Asignar total venta a venta	
        venta.setTotal_venta(total);

        // Actualizar la lista de productos en la venta con las entidades gestionadas
        venta.setLista_productos(productos);
   
        // Asociar el cliente persistido a la venta
        venta.setCliente(cliDB);

        // Guardar la venta
        ventaDAO.save(venta);
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
