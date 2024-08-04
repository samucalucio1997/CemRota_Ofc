package com.rota.cemrota.service.domain;



public class PontoRotaDto {
    public double Latitude;
    public double Longitude;
   
    public PontoRotaDto(double latitude, double longitude) {
        Latitude = latitude;
        Longitude = longitude;
    }

    public double getLatitude() {
        return Latitude;
    }
    public void setLatitude(double latitude) {
        Latitude = latitude;
    }
    public double getLongitude() {
        return Longitude;
    }
    public void setLongitude(double longitude) {
        Longitude = longitude;
    }
    
}
