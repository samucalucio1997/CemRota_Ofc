package com.rota.cemrota.service.request;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.rota.cemrota.model.Hospedagem;

public class HospedagemRequest {
   private Hospedagem hospedagem;

   private List<MultipartFile> imgs;

public Hospedagem getHospedagem() {
    return hospedagem;
}

public void setHospedagem(Hospedagem hospedagem) {
    this.hospedagem = hospedagem;
}

public List<MultipartFile> getImgs() {
    return imgs;
}

public void setImgs(List<MultipartFile> imgs) {
    this.imgs = imgs;
}
}
