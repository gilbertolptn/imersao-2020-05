package br.com.tt.petshop.service;

import br.com.tt.petshop.model.Animal;
import br.com.tt.petshop.repository.AnimalRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class AnimalService {

    //Você pode injetar tanto classes quanto interfaces
    // (desde que as interfaces tenham uma implementação)
    // Neste caso o Spring irá criar essa implementação EM RUNTIME.
    private AnimalRepository animalRepository;

    public AnimalService(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    public void removerAnimal(Long idAnimal){
        animalRepository.deleteById(idAnimal);
    }

    public void removerAnimalComValidacao(Long idAnimal){
        animalRepository.findById(idAnimal)
                .ifPresentOrElse( animal -> animalRepository.delete(animal),
                () -> {throw new RuntimeException("Animal não existe");});
    }

    public Animal criarAnimal(Animal animal){
        return animalRepository.save(animal);
    }

    public List<Animal> buscarPorNomeENascimento(String nome, LocalDate dataNascimento){
        return animalRepository.findByNomeAndDataNascimentoOrderByNome(nome, dataNascimento);
    }


}
