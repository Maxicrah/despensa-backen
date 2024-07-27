package com.maxi.despensa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.maxi.despensa.model.Proveedor;

@Repository
public interface IProveedorDAO extends JpaRepository<Proveedor, Long>{

	@Query("SELECT p FROM Proveedor p WHERE p.nombre = :nombre")
	public Proveedor findProveedorByName(@Param("nombre") String nombre);
}
