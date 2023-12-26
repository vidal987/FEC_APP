package br.com.fec.FecApp.DTO.MembroDTO;

import br.com.fec.FecApp.Domain.ValuesObjects.PhoneNumber;

public record GetMembroDTO(String name, String lastName, PhoneNumber phoneNumber) {

}
