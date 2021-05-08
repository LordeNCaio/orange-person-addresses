package com.caiomacedo.personaddresses.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class CepAddressDTO {

    @NotNull(message = "Person ID cannot be null")
    @Min(value = 1, message = "Person ID must be greater or equal 1")
    private final Long personId;

    @NotBlank(message = "Zip Code cannot be null or empty")
    @Pattern(regexp = "(^[0-9]{8}$)", message = "Zip Code must have eight digits")
    private final String zipcode;

    private final String houseNumber;
    private final String complement;

    public CepAddressDTO(Long personId, String zipcode, String houseNumber, String complement) {
        this.personId = personId;
        this.zipcode = zipcode;
        this.houseNumber = houseNumber;
        this.complement = complement;
    }

    public Long getPersonId() {
        return personId;
    }

    public String getZipcode() {
        return zipcode;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public String getComplement() {
        return complement;
    }
}
