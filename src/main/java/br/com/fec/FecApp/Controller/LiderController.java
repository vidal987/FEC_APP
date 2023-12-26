package br.com.fec.FecApp.Controller;

import br.com.fec.FecApp.DTO.LiderDTO.CreateLiderDTO;
import br.com.fec.FecApp.Domain.Lider;
import br.com.fec.FecApp.Domain.Membro;
import br.com.fec.FecApp.Repositories.LiderRepository.ILiderRepository;
import br.com.fec.FecApp.Service.LiderService.CreateLiderService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/liders")
public class LiderController {
    private final CreateLiderService createLiderService;
    private final ILiderRepository liderRepository;

    @Autowired
    protected LiderController(CreateLiderService createLiderService, ILiderRepository liderRepository) {
        this.createLiderService = createLiderService;
        this.liderRepository = liderRepository;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<Lider> postMembro(@RequestBody CreateLiderDTO liderDTO){
        var newMembro = createLiderService.registerLider(liderDTO);

        return ResponseEntity.ok(newMembro);
    }

    @GetMapping() // Mapeia GET para /grupos/{grupoId}
    public ResponseEntity<List<Lider>> getMembros(){
        var liders = liderRepository.findAll();
        return ResponseEntity.ok(liders);
    }
}
