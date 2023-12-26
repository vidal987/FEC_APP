package br.com.fec.FecApp.Repositories.MembroRepository;

import br.com.fec.FecApp.Domain.Membro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMembroRepository extends JpaRepository<Membro, String> {

}
