package com.maxi.despensa.service;

import java.time.LocalDate;
import java.util.List;

import com.maxi.despensa.model.Cuenta;

public interface ICuentaService {

	
	//crear cuenta
	public Cuenta crearCuenta( LocalDate fechaInicio,
    LocalDate fechaPago,
     Double totalMes,
     String dniCliente);
	//eliminar cuenta
	public void eliminarCuenta(Long id);
	//poner cuenta inactiva
	public void cambiarEstadoCuenta(Long id);
	//traer cuenta
	public Cuenta traerCuenta(Long id);
	//traer todas cuentas
	public List<Cuenta> traerCuentas();
	//editar cuenta
	public Cuenta editarCuenta(Cuenta cuenta, Long id);
	
	
}
