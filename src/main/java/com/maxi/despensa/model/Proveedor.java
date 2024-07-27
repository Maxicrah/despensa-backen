package com.maxi.despensa.model;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
@Entity
public class Proveedor {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id_proveedor;
	private String nombre;
	@Column(unique=true)
	private String dni;
	private String direccion;
	@Column(unique = true)
	private String email;
	private String nro_telefono;
	private LocalDate fecha_registro;
	private String obs;
	@ManyToMany
	@JoinTable(
			name = "proveedor_producto",
			joinColumns = @JoinColumn(name = "proveedor_id", referencedColumnName = "id_proveedor"),
			inverseJoinColumns =  @JoinColumn(name = "producto_id", referencedColumnName = "id_producto")
	)
	private List<Producto> lista_productos;
}
