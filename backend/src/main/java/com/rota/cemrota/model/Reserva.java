package com.rota.cemrota.model;

import java.util.Date;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;

@Entity
public class Reserva {
   @EmbeddedId
   private ReservaUsuarioPontoInteresse reservaId;
   private double valorTotal;
   private Date dataHoraEntrada;
   private Date dataHoraSaida;
   
   public ReservaUsuarioPontoInteresse getReservaId() {
      return reservaId;
   }
   public void setReservaId(ReservaUsuarioPontoInteresse reservaId) {
      this.reservaId = reservaId;
   }
   public double getValorTtotal() {
      return valorTotal;
   }
   public void setValor_total(double valorTotal) {
      this.valorTotal = valorTotal;
   }
   public Date getData_hora_entrada() {
      return dataHoraEntrada;
   }
   public void setDataHoraEntrada(Date dataHoraEntrada) {
      this.dataHoraEntrada = dataHoraEntrada;
   }
   public Date getDataHoraSaida() {
      return dataHoraSaida;
   }
   public void setData_hora_saida(Date dataHoraSaida) {
      this.dataHoraSaida = dataHoraSaida;
   }
   
}
