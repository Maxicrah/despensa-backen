package com.maxi.despensa.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter @Setter @Builder @AllArgsConstructor @NoArgsConstructor
public class CuentaDTO {
	
	private Long id;
	    private LocalDate fechaInicio;
	 	
	    private LocalDate fechaPago; 
	    
	    private Double totalMes;

	    private String dniCliente;
	    
}
