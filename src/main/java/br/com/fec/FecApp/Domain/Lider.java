package br.com.fec.FecApp.Domain;

import br.com.fec.FecApp.Domain.BaseEntities.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Lider extends BaseEntity {

    public Lider(String fullName, Date dateOfBirth) {
        this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
    }

    private String fullName;
    private Date dateOfBirth;

    @OneToMany(mappedBy = "lider")
    private List<Grupo> grupos;
}
