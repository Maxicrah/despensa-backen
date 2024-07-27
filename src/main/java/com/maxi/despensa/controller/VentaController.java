package com.maxi.despensa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.maxi.despensa.dto.VentaDTO;
import com.maxi.despensa.model.Venta;
import com.maxi.despensa.service.IVentaDTOService;
import com.maxi.despensa.service.IVentaService;

@RestController
@RequestMapping("venta")
public class VentaController {
	
	@Autowired
	private IVentaService ventaServ;
	
	@Autowired
	private IVentaDTOService ventaDTO;
	
	
	@PostMapping("/crear")
	public String createVenta(@RequestBody Venta venta) {
		ventaServ.createVenta(venta);
		return "Venta creada rey";
	}
	
	@GetMapping("/traer/{id}")
	public void getVenta(@PathVariable Long id) {
		ventaServ.getVentaById(id);
	}
	
	@GetMapping("/traer")
	public List<Venta> getVentas(){
	return ventaServ.getVentas();
	}
	
	@DeleteMapping("/eliminar/{id}")
	public void deleteVenta(@PathVariable Long id) {
		ventaServ.deleteVenta(id);
	}
	
	@GetMapping("{idVenta}/{dniCliente}")
	@ResponseBody
	public VentaDTO getVentaDTObyDniCliente(@PathVariable Long idVenta,@PathVariable String dniCliente) {
		return ventaDTO.getVentaDTOByDniCliente(dniCliente,idVenta);
	}
	
	@PutMapping("/editar/{id}")
	public Venta editVenta(@PathVariable Long id, @RequestBody Venta venta) {
		return ventaServ.editVenta(id, venta);
	}
	
}
