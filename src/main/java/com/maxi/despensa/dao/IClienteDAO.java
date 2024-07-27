package com.maxi.despensa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.maxi.despensa.model.Cliente;

@Repository
public interface IClienteDAO extends JpaRepository<Cliente, Long>{

	@Query("SELECT c FROM Cliente c WHERE c.dni = :dni")
	public Cliente findClienteByDni(@Param("dni") String dni);
	
}
