package br.com.fec.FecApp.Repositories.MembroRepository;

import br.com.fec.FecApp.Domain.Membro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface IMembroRepository extends JpaRepository<Membro, String> {
    List<Membro> findBydateOfBirth(LocalDate date);

}
