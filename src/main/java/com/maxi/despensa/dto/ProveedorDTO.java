package com.maxi.despensa.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor

public class ProveedorDTO {
	private Long id_proveedor;
	private String nombre;
	private String dni;
	private String direccion;
    private List<ProductoDTO> lista_productos;
}
