package br.com.tt.petshop.repository;

import br.com.tt.petshop.model.Animal;
import br.com.tt.petshop.model.Cliente;
import ch.qos.logback.core.net.server.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

//Interface extends interface (contrato)
//Classe implements interface
//Classe extends outraClasse
@Repository
public interface AnimalRepository extends
        CrudRepository<Animal, Long> {
//        , JpaRepository<Animal, Long>,
//        PagingAndSortingRepository<Animal, Long>

    List<Animal> findByNomeAndDataNascimentoOrderByNome(String nome, LocalDate dataNascimento);

    List<Animal> findByNomeAndDataNascimentoIsNotNull(String nome);

    List<Animal> findByNomeAndDataNascimentoBetween(String nome,
                                                    LocalDate dataNascimentoInicio,
                                                    LocalDate dataNascimentoFim);

    Optional<Animal> findByNomeAndCliente(String nome, Cliente cliente);
}
