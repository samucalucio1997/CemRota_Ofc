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
public class Comercio extends PontoInteresse{
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String horarios;
    private String dias;
    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<ImagemPonto> imgs;
    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private Usuario responsavel;
    
    
    
    public Comercio(){
        
    }
    
    public Comercio(String titulo, String descricao, Double longitude, Double latitude, String horarios, String dias,
            Usuario responsavel) {
        super(titulo, descricao, longitude, latitude);
        this.horarios = horarios;
        this.dias = dias;
        this.responsavel = responsavel;
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

    public String getDias() {
        return dias;
    }

    public void setDias(String dias) {
        this.dias = dias;
    }

    public String getHorarios() {
        return horarios;
    }

    public void setHorarios(String horarios) {
        this.horarios = horarios;
    }

    public UUID getId() {
        return id;
    }
}
   
