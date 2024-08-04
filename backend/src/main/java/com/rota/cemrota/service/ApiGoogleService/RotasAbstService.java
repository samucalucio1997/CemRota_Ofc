package com.rota.cemrota.service.ApiGoogleService;

import java.net.URISyntaxException;
import java.util.List;

public interface RotasAbstService {
   public List<PontoInteresseDTO> PegarRota(String origem, String destiono, double filtroDistancia) throws URISyntaxException;
   
}
