package com.rota.cemrota.model;

import java.util.List;
import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class PontoTuristico extends PontoInteresse{
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private int valor_entrada;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<ImagemPonto> imgs;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Usuario responsavel;

    public PontoTuristico(){
        
    }
    

    public PontoTuristico(String titulo, String descricao, Double longitude, Double latitude, UUID id,
            int valor_entrada, Usuario responsavel) {
        super(titulo, descricao, longitude, latitude);
        this.id = id;
        this.valor_entrada = valor_entrada;
        this.responsavel = responsavel;
    }

    @Override
    public String getDescricao() {
        return super.getDescricao();
    }

    @Override
    public void setDescricao(String descricao) {
        super.setDescricao(descricao);
    }

    @Override
    public Double getLatitude() {
        return super.getLatitude();
    }

    @Override
    public void setLatitude(Double latitude) {
        super.setLatitude(latitude);
    }

    @Override
    public Double getLongitude() {
        return super.getLongitude();
    }

    @Override
    public void setLongitude(Double longitude) {
        super.setLongitude(longitude);
    }

    @Override
    public String getTitulo() {
        return super.getTitulo();
    }

    @Override
    public void setTitulo(String titulo) {
        super.setTitulo(titulo);
    }

    public int getValor_entrada() {
        return valor_entrada;
    }

    public void setValor_entrada(int valor_entrada) {
        this.valor_entrada = valor_entrada;
    }

    public UUID getId() {
        return id;
    }

    public List<ImagemPonto> getImgs() {
        return imgs;
    }

    public void setImgs(List<ImagemPonto> imgs) {
        this.imgs = imgs;
    }

    public Usuario getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(Usuario responsavel) {
        this.responsavel = responsavel;
    }

  
}
