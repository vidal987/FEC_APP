package br.com.fec.FecApp.Domain;

import br.com.fec.FecApp.Domain.BaseEntities.BaseEntity;
import br.com.fec.FecApp.Domain.ValuesObjects.Address;
import br.com.fec.FecApp.Domain.ValuesObjects.PhoneNumber;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;

@EqualsAndHashCode(callSuper = false)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Membro extends BaseEntity {

    private String Name;

    private String LastName;

    private LocalDate dateOfBirth;

    @Embedded
    private Address address;

    @Embedded
    private PhoneNumber phoneNumber;

    public Membro(String name, String lastName, LocalDate birth){
        super();
        this.Name = name;
        this.LastName = lastName;
        this.dateOfBirth = birth;
    }
}
