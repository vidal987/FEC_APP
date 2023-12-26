package br.com.fec.FecApp.Service.GrupoService;

import br.com.fec.FecApp.DTO.GrupoDTO.AddMembroGrupoDTO;
import br.com.fec.FecApp.Domain.Grupo;
import br.com.fec.FecApp.Exceptions.DomainException;
import br.com.fec.FecApp.Repositories.GrupoRepository.IGrupoRepository;
import br.com.fec.FecApp.Repositories.MembroRepository.IMembroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AddMembroGrupoService {
    private final IMembroRepository membroRepository;
    private final IGrupoRepository grupoRepository;

    @Autowired
    protected AddMembroGrupoService(IMembroRepository membroRepository, IGrupoRepository grupoRepository) {
        this.membroRepository = membroRepository;
        this.grupoRepository = grupoRepository;
    }


    public Optional<Grupo> addMembro(AddMembroGrupoDTO membroGrupoDTO) {

        var membro = membroRepository.findById(membroGrupoDTO.membroId());

        if (membro.isEmpty()){
            throw new DomainException("Membro não encontrado");
        }

        var grupo = grupoRepository.findById(membroGrupoDTO.grupoId());

        if (grupo.isEmpty()){
            throw new DomainException("Grupo não encontrado");
        }

        grupo.get().addMember(membro.get());

        return grupo;
    }
}
