package br.com.tt.petshop.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component// ou @Service
public class CreditoRestTemplateClient {

    private final RestTemplate restTemplate;
    private final String creditoUrl;

    public CreditoRestTemplateClient(RestTemplate restTemplate,
                                     @Value("${app.servicos.credito.url}") String creditoUrl) {
        this.restTemplate = restTemplate;
        this.creditoUrl = creditoUrl;
    }

    /*
       Retorno esperado: {"situacao":"NEGATIVADO","pontos":-679}
     */
    public CreditoDto consultaSituacaoCpf(String cpf) {
        //ResponseEntity<CreditoDto> retorno = restTemplate.getForEntity(url, CreditoDto.class);
        //String headerToken = retorno.getHeaders().getFirst("Authorization");
        //return retorno.getBody();

        return restTemplate.getForObject(creditoUrl, CreditoDto.class, cpf);
    }
}









