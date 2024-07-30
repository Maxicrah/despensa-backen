package com.maxi.despensa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.maxi.despensa.model.Categoria;

@Repository
public interface ICategoriaDAO extends JpaRepository<Categoria, Long>{

}
