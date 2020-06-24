package br.com.tt.petshop.service;

import br.com.tt.petshop.dto.AtendimentoEntradaDto;
import br.com.tt.petshop.dto.AtendimentoSaidaDto;
import br.com.tt.petshop.model.Animal;
import br.com.tt.petshop.model.Atendimento;
import br.com.tt.petshop.repository.AnimalRepository;
import br.com.tt.petshop.repository.AtendimentoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class AtendimentoService {

    private final AnimalService animalService;
    private final AtendimentoRepository repository;
    private final ModelMapper mapper;

    public AtendimentoService(AnimalService animalService,
                              AtendimentoRepository repository,
                              ModelMapper mapper) {
        this.animalService = animalService;
        this.repository = repository;
        this.mapper = mapper;
    }

    public Atendimento criar(AtendimentoEntradaDto entradaDto) {

        //Pre-requisito
        Animal animal = animalService.buscarPorId(entradaDto.getIdAnimal());

        //Converte
        Atendimento atendimentoAserSalvo = entradaDto.toEntity(animal);

        //Salvar
        Atendimento atendimentoSalvo = repository.save(atendimentoAserSalvo);

        //retornar o atendimento salvo
        return atendimentoSalvo;
    }

    public List<AtendimentoSaidaDto> listar() {
        //Buscar os atendimentos
        return repository.findAll()
        //Converter para dto
        .stream()
        //.map(entidade -> new AtendimentoSaidaDto(entidade))
        .map(atendimento -> mapper.map(atendimento, AtendimentoSaidaDto.class))
        //Retornar uma lista
        .collect(Collectors.toList());
    }

    //Como o modelMapper funciona?
    //    ClasseMegeada minhaVariavelDeMerge;
    //
    //    ClasseA minhaVariavelA = new ClasseA();
    //                minhaVariavelA.setNome("adasdsa");
    //
    //    ClasseB minhaVariabelB = mapper.map(minhaVariavelA, minhaVariavelDeMerge, ClasseB.class);
    //                minhaVariabelB.getNome()
    //
    //                        mapper.map(minhaVariavelDeMerge, minhaVariavelA); nome ="Joao"
    //            mapper.map(minhaVariavelDeMerge, minhaVariavelB); data = 2020-10-01
    //            mapper.map(minhaVariavelDeMerge, minhaVariavelC);
    //        mapper.map(minhaVariavelDeMerge, minhaVariavelD);
    //    minhaVariavelDeMerge nome = Joao, data = 2020-10-01


}
