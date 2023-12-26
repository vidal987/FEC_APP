package br.com.fec.FecApp.Repositories.GrupoRepository;

import br.com.fec.FecApp.Domain.Grupo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IGrupoRepository extends JpaRepository<Grupo, String> {
}
