package br.com.tt.petshop.dto;

import br.com.tt.petshop.model.Atendimento;

public class AtendimentoSaidaDto {

    private Long id;
    private AnimalSaidaDto animal;

    public AtendimentoSaidaDto(Atendimento atendimento) {
        id = atendimento.getId();
        animal = AnimalSaidaDto.build(atendimento.getAnimal());
    }

}
