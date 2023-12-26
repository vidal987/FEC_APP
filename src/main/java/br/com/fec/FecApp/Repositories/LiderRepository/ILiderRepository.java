package br.com.fec.FecApp.Repositories.LiderRepository;

import br.com.fec.FecApp.Domain.Lider;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ILiderRepository extends JpaRepository<Lider, String> {
}
