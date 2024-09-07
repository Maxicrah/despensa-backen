package com.maxi.despensa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.maxi.despensa.model.Cuenta;
@Repository
public interface ICuentaDAO extends JpaRepository<Cuenta, Long>{

}
