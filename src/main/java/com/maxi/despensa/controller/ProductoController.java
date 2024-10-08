package com.maxi.despensa.controller;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.maxi.despensa.model.Producto;
import com.maxi.despensa.service.IProductoService;
import com.maxi.despensa.service.IStorageService;

@RestController
@RequestMapping("/productos")
public class ProductoController {

	@Autowired
	private IProductoService prodServ;
	
	@Autowired
	private IStorageService storageService;

	
	 @PostMapping("/crear")
	    public ResponseEntity<Producto> createProducto(@RequestParam("nombre") String nombre,
	                                                   @RequestParam("descripcion") String descripcion,
	                                                   @RequestParam("costo_adquisicion") Double costoAdquisicion,
	                                                   @RequestParam("fecha_vencimiento") LocalDate fechaVencimiento,
	                                                   @RequestParam("marca") String marca,
	                                                   @RequestParam("stock") Long stock,
	                                                   @RequestParam("promocion") String promocion,
	                                                   @RequestParam("notas_adicionales") String notasAdicionales,
	                                                   @RequestParam("imagen") MultipartFile imagen) {
	        String imageName = storageService.store(imagen);
	        Producto producto = new Producto();
	        producto.setNombre(nombre);
	        producto.setDescripcion(descripcion);
	        //producto.setPrecio(precio);
	        producto.setCosto_adquisicion(costoAdquisicion);
	        producto.setFecha_vencimiento(fechaVencimiento);
	        producto.setFecha_ingreso(LocalDate.now());
	        producto.setImagen(imageName);
	        producto.setMarca(marca);
	        producto.setStock(stock);
	        producto.setPromocion(promocion);
	        producto.setNotas_adicionales(notasAdicionales);

	        Producto createdProducto = prodServ.createProduct(producto);
	        return ResponseEntity.ok(createdProducto);
	    }


	
	@GetMapping("/traer/{id}")
	public Producto getProduct(@PathVariable(required = true) Long id) {
		return prodServ.getProducto(id);
	}
	
	@GetMapping("/traer")
	public List<Producto> getProducts(){
		return prodServ.getProductos();
		
	}
	
	@DeleteMapping("/eliminar/{id}")
	public ResponseEntity<?> eliminarProducto(@PathVariable Long id) {
	    prodServ.deleteProduct(id);
	    Map<String, String> response = new HashMap<>();
	    response.put("message", "Producto eliminado correctamente");
	    return ResponseEntity.ok(response);
	}
	
	@PutMapping("/editar/{id}")
	public ResponseEntity<Producto> editProduct(@PathVariable Long id,
	                                            @RequestParam("nombre") String nombre,
	                                            @RequestParam("descripcion") String descripcion,
	                                            @RequestParam("costo_adquisicion") Double costoAdquisicion,
	                                            @RequestParam("fecha_vencimiento") LocalDate fechaVencimiento,
	                                            @RequestParam("marca") String marca,
	                                            @RequestParam("stock") Long stock,
	                                            @RequestParam("promocion") String promocion,
	                                            @RequestParam("notas_adicionales") String notasAdicionales,
	                                            @RequestParam(value = "imagen", required = false) MultipartFile imagen) {
	    Producto product = prodServ.getProducto(id);
	    if (product == null) {
	        return ResponseEntity.notFound().build();
	    }

	    product.setNombre(nombre);
	    product.setDescripcion(descripcion);
	    product.setCosto_adquisicion(costoAdquisicion);
	    product.setFecha_vencimiento(fechaVencimiento);
	    product.setMarca(marca);
	    product.setStock(stock);
	    product.setPromocion(promocion);
	    product.setNotas_adicionales(notasAdicionales);

	    if (imagen != null && !imagen.isEmpty()) {
	        String imageName = storageService.store(imagen);
	        product.setImagen(imageName);
	    }

	    Producto updatedProducto = prodServ.editProduct(id, product);
	    return ResponseEntity.ok(updatedProducto);
	}
}
