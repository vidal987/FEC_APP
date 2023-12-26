package br.com.fec.FecApp.Domain.ValuesObjects;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class PhoneNumber {
    private String number;
    private String DDD;

    public PhoneNumber(String number, String ddd) {
        this.number = number;
        this.DDD = ddd;
    }
}
