package com.maxi.despensa.service;

import java.io.IOException;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;


public interface IStorageService {

	//metodo aux 
	void iniciar() throws IOException;
	//metodo para almacenar archivo
	public String store(MultipartFile file);
	//metodo para cargar archivo
	public Resource loadAsResource(String filename);
	
}
