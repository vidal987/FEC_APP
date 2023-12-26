package br.com.fec.FecApp.Domain;

import br.com.fec.FecApp.Domain.BaseEntities.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Grupo extends BaseEntity {

    public Grupo(String name, Lider lider){
        this.creationDate = Date.from(Instant.now());
        this.name = name;
        this.lider = lider;
    }

    private String name;

    @ManyToMany(mappedBy = "grupos", cascade = CascadeType.ALL)
    private List<Membro> membros = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lider_id")
    private Lider lider;

    private Date creationDate;
    public void addMember(Membro membro) {
        membros.add(membro);
        membro.getGrupos().add(this);
    }

    public void removeMember(Membro membro) {
        membros.remove(membro);
        membro.getGrupos().remove(this);
    }

    public void changeLider(Lider lider){
        this.lider = lider;
    }
}
