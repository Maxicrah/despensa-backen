package com.maxi.despensa.model;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
//import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
//import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
@Entity
public class Producto {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id_producto;
	private String nombre;
	private String descripcion;
	@Column(nullable = false)
	private Double precio;
	private Double costo_adquisicion;
	@Column(nullable = false)
	private LocalDate fecha_vencimiento;
	private LocalDate fecha_ingreso;
	private String imagen;
	private String marca;
	private Long stock;
	private String promocion;
	private String notas_adicionales;
	@ManyToMany (mappedBy = "lista_productos")
	private List<Venta> lista_ventas;	
    @JsonIgnore
	@ManyToMany (mappedBy = "lista_productos")
	private List<Proveedor> proveedores;
}
