package br.com.fec.FecApp.Controller;

import br.com.fec.FecApp.DTO.GrupoDTO.AddMembroGrupoDTO;
import br.com.fec.FecApp.DTO.GrupoDTO.CreateGrupoDTO;
import br.com.fec.FecApp.Domain.Grupo;
import br.com.fec.FecApp.Service.GrupoService.AddMembroGrupoService;
import br.com.fec.FecApp.Service.GrupoService.CreateGrupoService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/grupos")
public class GrupoController {

    private final CreateGrupoService createGrupoService;
    private  final AddMembroGrupoService addMembroGrupoService;

    @Autowired
    protected GrupoController(CreateGrupoService createGrupoService, AddMembroGrupoService addMembroGrupoService) {
        this.createGrupoService = createGrupoService;
        this.addMembroGrupoService = addMembroGrupoService;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<Grupo> postMembro(@RequestBody CreateGrupoDTO grupoDTO){
        var newGrupo = createGrupoService.registerGrupo(grupoDTO);

        return ResponseEntity.ok(newGrupo);
    }

    @PostMapping("/addMembro")
    @Transactional
    public ResponseEntity<Optional<Grupo>> addMembroGrupo (@RequestBody AddMembroGrupoDTO membroGrupoDTO){
        var newMembro = addMembroGrupoService.addMembro(membroGrupoDTO);

        return ResponseEntity.ok(newMembro);
    }
}
