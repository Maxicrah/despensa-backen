package com.maxi.despensa.service;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import jakarta.annotation.PostConstruct;
@Service
public class FileSystemStorageService implements IStorageService {
	
	//acá podemos saber dode almacenar los archivos o para saber desde donde recuperarlos
	@Value("${media.location}")
	private String mediaLocation;
    //ruta raiz almacenamiento
	private Path rootLocation;
	
	@Override
	@PostConstruct
	public void iniciar() throws IOException {
		//iniciar ruta raiz almacenamiento
		rootLocation = Paths.get(mediaLocation);
		//asegurarse que exista antes de gestionar nuevo archivo
		Files.createDirectories(rootLocation);
	}

	@Override
	public String store(MultipartFile file) {
		try {
			if(file.isEmpty()) {
				throw new RuntimeException("Fallo");
			}
			String filename = file.getOriginalFilename();
			Path destinationFile = rootLocation.resolve(Paths.get(filename))
					.normalize().toAbsolutePath();
			System.out.println("Path to file: " + file.toString());

			try(InputStream inputStream = file.getInputStream()){
				Files.copy(inputStream, destinationFile, StandardCopyOption.REPLACE_EXISTING);
			}
			return filename;
		} catch(IOException e) {
			throw new RuntimeException("FALLOOO",e);
		}
	}

	@Override
	public Resource loadAsResource(String filename) {
		try {
			Path file = rootLocation.resolve(filename);
			Resource resource = new UrlResource((file.toUri()));
			if(resource.exists() || resource.isReadable()) {
				return resource;
			}else {
				throw new RuntimeException("no se puede leer archivo: " + filename);
			}
		}catch(MalformedURLException e){
			throw new RuntimeException("NO SE PUEDE LEER: " + filename );
		}
	}

}
