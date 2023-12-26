package br.com.fec.FecApp.Domain;

import br.com.fec.FecApp.Domain.BaseEntities.BaseEntity;
import br.com.fec.FecApp.Domain.ValuesObjects.Address;
import br.com.fec.FecApp.Domain.ValuesObjects.PhoneNumber;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Membro extends BaseEntity {

    private String Name;

    private String LastName;

    private Date dateOfBirth;

    @Embedded
    private Address address;

    @Embedded
    private PhoneNumber phoneNumber;

    @ManyToMany
    @JoinTable(
            name = "membro_grupo",
            joinColumns = @JoinColumn(name = "membro_id"),
            inverseJoinColumns = @JoinColumn(name = "groupo_id")
    )
    private List<Grupo> grupos = new ArrayList<>();

    public Membro(String name, String lastName){
        super();
        this.Name = name;
        this.LastName = lastName;
    }

    public void addGroup(Grupo grupo) {
        grupos.add(grupo);
        grupo.getMembros().add(this);
    }

    public void removeGroup(Grupo grupo) {
        grupos.remove(grupo);
        grupo.getMembros().remove(this);
    }
}
