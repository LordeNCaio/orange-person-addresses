package com.caiomacedo.personaddresses.dto;

public class CepAddressDTO {

    private String zipcode;
    private String complement;
    private String houseNumber;

    public CepAddressDTO(String zipcode, String complement, String houseNumber) {
        this.zipcode = zipcode;
        this.complement = complement;
        this.houseNumber = houseNumber;
    }

    public String getZipcode() {
        return zipcode;
    }

    public String getComplement() {
        return complement;
    }

    public String getHouseNumber() {
        return houseNumber;
    }
}
