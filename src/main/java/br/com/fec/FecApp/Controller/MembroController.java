package br.com.fec.FecApp.Controller;

import br.com.fec.FecApp.DTO.MembroDTO.PostMembroDTO;
import br.com.fec.FecApp.Domain.Membro;
import br.com.fec.FecApp.Exceptions.DomainException;
import br.com.fec.FecApp.Repositories.MembroRepository.IMembroRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/membros")
public class MembroController {

    @Autowired
    private IMembroRepository membroRepository;

    @GetMapping("/{membroId}") // Mapeia GET para /grupos/{grupoId}
    public ResponseEntity<Membro> getMembro(@PathVariable String membroId){
        try{
            var membro = membroRepository.findById(membroId).get();
            return ResponseEntity.ok(membro);
        } catch (Exception e){
            throw new DomainException("USER NOT FOUND");
        }

    }

    @GetMapping() // Mapeia GET para /grupos/{grupoId}
    public ResponseEntity<List<Membro>> getMembros(){
        var membros = membroRepository.findAll();
        return ResponseEntity.ok(membros);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<Membro> postMembro(@RequestBody PostMembroDTO membro){
        var newMembro = membroRepository.save(new Membro(membro.name(), membro.lastName()));
        return ResponseEntity.ok(newMembro);
    }
}
