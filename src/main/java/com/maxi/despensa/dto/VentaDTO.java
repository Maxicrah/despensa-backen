package com.maxi.despensa.dto;

import java.time.LocalDate;
import java.util.List;

import com.maxi.despensa.model.Producto;

import lombok.Data;

@Data
public class VentaDTO {
	
	private Long id_venta;
	private LocalDate fecha_venta;
	private Double total_venta;
	private Double precio_unitario_producto;
	private String dni;
	private String nombre_cliente;
	private String apellido_cliente;
	private String telefono;
	private String direccion;
	private String nombre_producto;
	private List<Producto> lista_productos;
	
}
