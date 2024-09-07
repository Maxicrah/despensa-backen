package com.maxi.despensa.model;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
@Entity
@Table(
		name= "Cliente",
		uniqueConstraints = {
			            @UniqueConstraint(name = "email_unique", columnNames = "email"),
			            @UniqueConstraint(name = "dni_unique", columnNames = "dni")
			        }
		
)
public class Cliente {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id_cliente;
	@Column(nullable = false)
	private String dni;
	private String nombre;
	private String apellido;
	private String telefono;
	private String direccion;
	private String email;
	private LocalDate fecha_registro;
	private String obs;
	@OneToMany(mappedBy="cliente")
	private List<Venta> lista_ventas;
	@OneToOne
	@JsonIgnore
	private Cuenta cuenta;
}
