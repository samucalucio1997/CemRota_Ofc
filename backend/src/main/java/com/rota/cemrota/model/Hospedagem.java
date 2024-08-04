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
public class Hospedagem extends PontoInteresse {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private int qntd_cama_solteiro;
    private int qntd_cama_casal;
    private boolean aceita_animais;
    private boolean disponivel;
    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<ImagemPonto> imgs;
    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private Usuario responsavel;
    @OneToMany(fetch = FetchType.EAGER)
    private List<Atrativo> atrativo;   
    
    public Hospedagem() {

    }

    public Hospedagem(String titulo, String descricao, Double longitude, Double latitude, int qntd_cama_solteiro,
            int qntd_cama_casal, boolean aceita_animais, Usuario responsavel) {
                super(titulo, descricao, longitude, latitude);
        this.qntd_cama_solteiro = qntd_cama_solteiro;
        this.qntd_cama_casal = qntd_cama_casal;
        this.aceita_animais = aceita_animais;
        this.disponivel =true;
        this.responsavel = responsavel;
    }
    
    public boolean isAceita_animais() {
        return aceita_animais;
    }
    
    public boolean isDisponivel() {
        return disponivel;
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

    public int getQntd_cama_casal() {
        return qntd_cama_casal;
    }
    
    public void setQntd_cama_casal(int qntd_cama_casal) {
        this.qntd_cama_casal = qntd_cama_casal;
    }
    
    public int getQntd_cama_solteiro() {
        return qntd_cama_solteiro;
    }
    
    public void setQntd_cama_solteiro(int qntd_cama_solteiro) {
        this.qntd_cama_solteiro = qntd_cama_solteiro;
    }

    

    public UUID getId() {
        return id;
    }

    public void setAceita_animais(boolean aceita_animais) {
        this.aceita_animais = aceita_animais;
    }
    
    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }
    public List<ImagemPonto> getImgs() {
        return imgs;
    }
    
    public List<Atrativo> getAtrativo() {
        return atrativo;
    }

    public void setAtrativo(List<Atrativo> atrativo) {
        this.atrativo = atrativo;
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
