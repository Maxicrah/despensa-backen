package com.maxi.despensa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.maxi.despensa.model.Producto;
@Repository
public interface IProductoDAO extends JpaRepository<Producto, Long>{

}
