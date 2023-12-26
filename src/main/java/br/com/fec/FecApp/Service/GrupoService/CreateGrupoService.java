package br.com.fec.FecApp.Service.GrupoService;

import br.com.fec.FecApp.DTO.GrupoDTO.CreateGrupoDTO;
import br.com.fec.FecApp.Domain.Grupo;
import br.com.fec.FecApp.Exceptions.DomainException;
import br.com.fec.FecApp.Repositories.GrupoRepository.IGrupoRepository;
import br.com.fec.FecApp.Repositories.LiderRepository.ILiderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CreateGrupoService {

    private final ILiderRepository liderRepository;
    private final IGrupoRepository grupoRepository;

    @Autowired
    protected CreateGrupoService(ILiderRepository liderRepository, IGrupoRepository grupoRepository) {
        this.liderRepository = liderRepository;
        this.grupoRepository = grupoRepository;
    }

    public Grupo registerGrupo(CreateGrupoDTO grupoDTO) {

        var lider = liderRepository.findById(grupoDTO.liderId());

        if (lider.isEmpty()){
            throw new DomainException("Lider não encontrado");
        }

        Grupo newGropo = grupoRepository.save(new Grupo(grupoDTO.name(), lider.get()));

        return newGropo;
    }

}
