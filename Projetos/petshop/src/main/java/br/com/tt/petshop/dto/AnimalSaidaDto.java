package br.com.tt.petshop.dto;

import br.com.tt.petshop.enumeration.TipoAnimal;
import br.com.tt.petshop.model.Animal;

import java.time.LocalDate;

public class AnimalSaidaDto {

    private Long id;
    private String nome;
    private LocalDate dataNascimento;
    private TipoAnimal tipo;

    public AnimalSaidaDto() {
    }

    private AnimalSaidaDto(Animal animal) {
        id = animal.getId();
        nome = animal.getNome();
        dataNascimento = animal.getDataNascimento();
        tipo = animal.getTipo();
    }

    public static AnimalSaidaDto build(Animal animal){
        return new AnimalSaidaDto(animal);
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public TipoAnimal getTipo() {
        return tipo;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public void setTipo(TipoAnimal tipo) {
        this.tipo = tipo;
    }
}
