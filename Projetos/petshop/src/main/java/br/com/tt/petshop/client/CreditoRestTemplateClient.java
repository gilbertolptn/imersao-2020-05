package br.com.tt.petshop.client;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component// ou @Service
public class CreditoRestTemplateClient {

    private final String URL_SERVICO_CREDITO = "https://imersao-credito-api.herokuapp.com";

    private final RestTemplate restTemplate;

    public CreditoRestTemplateClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    /*
       Retorno esperado: {"situacao":"NEGATIVADO","pontos":-679}
     */
    public CreditoDto consultaSituacaoCpf(String cpf){
        String url = String.format("%s/credito/%s", URL_SERVICO_CREDITO, cpf);
        return restTemplate.getForObject(url, CreditoDto.class);
    }
}
