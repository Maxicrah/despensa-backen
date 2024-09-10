package com.maxi.despensa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maxi.despensa.dto.CuentaDTO;
import com.maxi.despensa.service.ICuentaService;

@RestController
@RequestMapping("cuenta")
public class CuentaController {
	
	@Autowired
	private ICuentaService cuentaServ;
	
	@PostMapping("/crear")
	public String crearCuenta(@RequestBody CuentaDTO cuenta) {
		cuentaServ.crearCuenta(cuenta.getFechaInicio(),cuenta.getFechaPago(),cuenta.getTotalMes(),cuenta.getDniCliente());
		return "Cuenta creada";
	}
	
	@PutMapping("/cambiar-estado/{id}")
	public String eliminarCuenta(@PathVariable("id") Long id) {
		cuentaServ.cambiarEstadoCuenta(id);
		return "Cambiado estado cuenta";
	}
	
}
