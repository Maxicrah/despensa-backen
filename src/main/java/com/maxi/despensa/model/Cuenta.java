package com.maxi.despensa.model;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity @AllArgsConstructor @NoArgsConstructor @Setter @Getter
public class Cuenta {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	 @Temporal(TemporalType.DATE)
	    private LocalDate fechaInicio;
	 	
	    @Temporal(TemporalType.DATE)	
	    private LocalDate fechaPago; 
	    
	    private Double totalMes;
	    private Boolean activo;
	    @OneToOne(mappedBy = "cuenta")
	    @JsonBackReference
	    private Cliente unCliente;

	    @OneToMany(mappedBy = "cuenta")
	    private List<Venta> ventas;
}
