package br.com.fec.FecApp.Controller;

import br.com.fec.FecApp.DTO.GrupoDTO.CreateGrupoDTO;
import br.com.fec.FecApp.Domain.Grupo;
import br.com.fec.FecApp.Service.GrupoService.CreateGrupoService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/grupos")
public class GrupoController {

    private final CreateGrupoService createGrupoService;

    @Autowired
    protected GrupoController(CreateGrupoService createGrupoService) {
        this.createGrupoService = createGrupoService;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<Grupo> postMembro(@RequestBody CreateGrupoDTO grupoDTO){
        var newMembro = createGrupoService.registerGrupo(grupoDTO);

        return ResponseEntity.ok(newMembro);
    }
}
