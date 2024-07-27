package com.maxi.despensa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.maxi.despensa.model.Venta;

@Repository
public interface IVentaDAO extends JpaRepository<Venta, Long>{

}
