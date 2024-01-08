package br.com.fec.FecApp.DTO.MembroDTO;

import br.com.fec.FecApp.Domain.ValuesObjects.PhoneNumber;

import java.time.LocalDate;

public record PostMembroDTO(String name, String lastName, LocalDate birth, PhoneNumber phoneNumber) {
}
