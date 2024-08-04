package com.rota.cemrota.service.ApiGoogleService;

import java.util.List;
import java.util.UUID;

import com.rota.cemrota.model.Atrativo;
import com.rota.cemrota.model.ImagemPonto;

import lombok.Getter;
import lombok.Setter;

public class PontoInteresseDTO{
   
    @Getter
    @Setter
    private UUID id;
    @Getter
    @Setter
    private String titulo;
    @Getter
    @Setter
    private String descricao;
    @Getter
    @Setter
    private String tipo;
    @Getter
    @Setter
    private Double longitude; 
    @Getter
    @Setter
    private Double latitude; 
    @Getter
    @Setter
    private UUID responsavel;
    @Getter
    @Setter
    private int qntd_cama_solteiro; 
    @Getter
    @Setter
    private int qntd_cama_casal;
    @Getter
    @Setter
    private boolean aceita_animais;
    @Getter
    @Setter
    private boolean disponivel;
    @Getter
    @Setter
    private List<ImagemPonto> imgs; 
    @Getter
    @Setter
    private List<Atrativo> atrativo;
    @Getter
    @Setter
    private String horarios;
    @Getter
    @Setter
    private String dias;
    @Getter
    @Setter
    private int valor_entrada;

    public PontoInteresseDTO(UUID id, String titulo, String descricao, String tipo, Double longitude, Double latitude, UUID responsavel, int qntd_cama_solteiro, int qntd_cama_casal, boolean aceita_animais, boolean disponivel, List<ImagemPonto> imgs, List<Atrativo> atrativo, String horarios, String dias, int valor_entrada) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.tipo = tipo;
        this.longitude = longitude;
        this.latitude = latitude;
        this.responsavel = responsavel;
        this.qntd_cama_solteiro = qntd_cama_solteiro;
        this.qntd_cama_casal = qntd_cama_casal;
        this.aceita_animais = aceita_animais;
        this.disponivel = disponivel;
        this.imgs = imgs;
        this.atrativo = atrativo;
        this.horarios = horarios;
        this.dias = dias;
        this.valor_entrada = valor_entrada;
    }
}
