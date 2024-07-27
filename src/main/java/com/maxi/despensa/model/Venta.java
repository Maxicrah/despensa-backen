package com.maxi.despensa.model;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
//import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
@Entity
public class Venta {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id_venta;
	private LocalDate fecha_venta;
	private Double total_venta;
	private Double precio_unitario_producto;
	private String observacion;
	@ManyToOne
	@JoinColumn(name = "id_cliente") 
	private Cliente cliente;
	@ManyToMany (cascade = CascadeType.ALL)
	@JoinTable(name = "venta_producto_map",
				joinColumns = @JoinColumn(
						name="venta_id",
						referencedColumnName = "id_venta"
						),
				inverseJoinColumns = @JoinColumn(
						name="producto_id",
						referencedColumnName = "id_producto"
						)
				)
	private List<Producto> lista_productos;
	
}
