package br.com.fec.FecApp.Service.LiderService;

import br.com.fec.FecApp.DTO.LiderDTO.CreateLiderDTO;
import br.com.fec.FecApp.Domain.Lider;
import br.com.fec.FecApp.Repositories.LiderRepository.ILiderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateLiderService {

    private final ILiderRepository liderRepository;
    @Autowired

    public CreateLiderService(ILiderRepository liderRepository) {
        this.liderRepository = liderRepository;
    }

    public Lider registerLider(CreateLiderDTO liderDTO) {
        var lider = liderRepository.save(new Lider(liderDTO.fullName(), liderDTO.dateOfBirth()));

        return lider;
    }
}
