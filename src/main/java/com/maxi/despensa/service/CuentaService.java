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
		// TODO Auto-generated method stub
		
	}

	@Override
	public Cuenta traerCuenta(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cuenta> traerCuentas() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cuenta editarCuenta(Cuenta cuenta, Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cuenta crearCuenta(LocalDate fechaInicio, LocalDate fechaPago, Double totalMes, String dniCliente) {

			Cliente cli = clienteServ.findClienteByDni(dniCliente);
			Cuenta account = new Cuenta();
			if(!cli.equals(null)) {
				account.setFechaInicio(fechaInicio = LocalDate.now());
				account.setFechaPago(fechaPago = LocalDate.now().plusDays(30L));
				account.setTotalMes(totalMes);
				cli.setCuenta(account);
				account.setUnCliente(cli);
				return cuentaDAO.save(account);
			}else {
				return null;
			}		
	}

}
