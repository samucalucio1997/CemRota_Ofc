package com.rota.cemrota.model;

import java.util.UUID;

import jakarta.persistence.Embeddable;
@Embeddable
public class ReservaUsuarioPontoInteresse {
   private UUID usuarioId;
   private UUID pontoInteresseId;


   public ReservaUsuarioPontoInteresse(UUID usuarioId, UUID pontoInteresseId) {
    this.usuarioId = usuarioId;
    this.pontoInteresseId = pontoInteresseId;
}


public UUID getUsuarioId() {
    return usuarioId;
}
public void setUsuarioId(UUID usuarioId) {
    this.usuarioId = usuarioId;
}
public UUID getPontoInteresseId() {
    return this.pontoInteresseId;
}
public void setPontoInteresseId(UUID pontoInteresseId) {
    this.pontoInteresseId = pontoInteresseId;
}
}
