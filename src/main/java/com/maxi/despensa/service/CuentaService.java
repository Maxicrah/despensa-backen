package com.maxi.despensa.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maxi.despensa.dao.ICuentaDAO;
import com.maxi.despensa.model.Cliente;
import com.maxi.despensa.model.Cuenta;
@Service
public class CuentaService implements ICuentaService{

	@Autowired
	private ICuentaDAO cuentaDAO;
	
	@Autowired 
	private IClienteService clienteServ;
	


	@Override
	public void eliminarCuenta(Long id) {
		cuentaDAO.deleteById(id);
	}

	@Override
	public Cuenta traerCuenta(Long id) {
		return cuentaDAO.findById(id).orElse(null);
	}

	@Override
	public List<Cuenta> traerCuentas() {
		return cuentaDAO.findAll();
	}

	@Override
	public Cuenta editarCuenta(Cuenta cuenta, Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cuenta crearCuenta(LocalDate fechaInicio, LocalDate fechaPago, Double totalMes, String dniCliente) {
	    Cliente cli = clienteServ.findClienteByDni(dniCliente);
	    
	    if (cli == null) {
	        throw new RuntimeException("Cliente no encontrado con el DNI: " + dniCliente);
	    }

	    Cuenta cuentaClienteBD = cli.getCuenta();
	    if (cuentaClienteBD != null && cuentaClienteBD.getActivo()) {
	        throw new RuntimeException("El cliente ya tiene una cuenta activa.");
	    }

	    Cuenta account = new Cuenta();
	    account.setFechaInicio(LocalDate.now()); 
	    account.setFechaPago(LocalDate.now().plusDays(30L)); 
	    account.setTotalMes(totalMes);
	    account.setActivo(true); 
	    cli.setCuenta(account);
	    account.setUnCliente(cli);

	    return cuentaDAO.save(account);
	}

	@Override
	public void cambiarEstadoCuenta(Long id) {
		Cuenta cuenta = cuentaDAO.findById(id).orElseThrow(() -> new RuntimeException("Cuenta no encontrada"));
		if(cuenta.getActivo()) {
			cuenta.setActivo(false);
		}else {
			cuenta.setActivo(true);
		}
		cuentaDAO.save(cuenta);
	}

}
