package com.maxi.despensa.dto;


import java.time.LocalDate;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class ProductoDTO {

     private String nombre;
     private String descripcion;
     private Double precio;
     private String imagen;
 	 private Double costo_adquisicion;
 	 private LocalDate fecha_vencimiento;
     private String marca;
 	 private Long stock;
     private String promocion;
     private String notas_adicionales;
     private MultipartFile imagen_media;
}
