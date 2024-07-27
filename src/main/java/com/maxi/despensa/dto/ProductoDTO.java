package com.maxi.despensa.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class ProductoDTO {

	 private Long id_producto;
     private String nombre;
     private String descripcion;
     private Double precio;
     private String imagen;
     private String marca;
     private String promocion;
     private String notas_adicionales;
}
