package com.rota.cemrota.service;


import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.FileSystemException;

import com.rota.cemrota.config.FilestorageProperties;
import org.springframework.stereotype.Service;

@Service
public class ImageService {

    private final Path caminhoImagem;

    public ImageService(FilestorageProperties fileStoragePropPontoInt) {
        this.caminhoImagem = Paths.get(fileStoragePropPontoInt.getUploadDir()).toAbsolutePath().normalize();
    }

    public byte[] extrairImagem(String path) throws FileSystemException{
     try {
            path = path.replace("\\", File.separator);
            Path caminhoCompleto = this.caminhoImagem.resolve(path).toAbsolutePath().normalize();
            return Files.readAllBytes(caminhoCompleto);
        } catch (Exception e) {
            throw new FileSystemException(path + "Deu erro");
        }
   }

}
