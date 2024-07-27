package com.maxi.despensa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.maxi.despensa.dao.IProductoDAO;
import com.maxi.despensa.model.Producto;
@Service
public class ProductoService implements IProductoService{

	
	@Autowired
	private IProductoDAO prodDAO;
	@Autowired
	
    private IStorageService storageService;
	
    @Override
    public void createProduct(Producto prod, MultipartFile file) {
        String imageURL = storageService.store(file);
        prod.setImagen(imageURL);
        prodDAO.save(prod);
    }

	@Override
	public void deleteProduct(Long id) {
		prodDAO.deleteById(id);
	}

	@Override
	public List<Producto> getProductos() {
		return prodDAO.findAll();
	}

	@Override
	public Producto getProducto(Long id) {
		return prodDAO.findById(id).orElse(null);
	}

	@Override
	public Producto editProduct(Long id, Producto prod) {
		
		Producto product = this.getProducto(id);
		product.setNombre(prod.getNombre());
		product.setCosto_adquisicion(prod.getCosto_adquisicion());
		product.setDescripcion(prod.getDescripcion());
		product.setFecha_vencimiento(prod.getFecha_vencimiento());
		product.setFecha_ingreso(prod.getFecha_ingreso());
		product.setPrecio(prod.getPrecio());
		product.setPromocion(prod.getPromocion());
		product.setStock(prod.getStock());
		product.setNotas_adicionales(prod.getNotas_adicionales());
		product.setMarca(prod.getMarca());
		product.setImagen(prod.getImagen());
		
		prodDAO.save(product);
		
		return product;
	}

}
