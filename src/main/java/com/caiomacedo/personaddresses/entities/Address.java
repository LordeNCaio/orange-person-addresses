package com.caiomacedo.personaddresses.entities;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "t_address")
public class Address extends BaseEntity {

    @NotBlank(message = "Street cannot be null or empty")
    @JsonAlias("logradouro")
    private String street;

    private String houseNumber;

    @JsonAlias("complemento")
    private String complement;

    @NotBlank(message = "District cannot be null or empty")
    @JsonAlias("bairro")
    private String district;

    @NotBlank(message = "City cannot be null or empty")
    @JsonAlias("localidade")
    private String city;

    @NotBlank(message = "State cannot be null or empty")
    @JsonAlias("uf")
    private String state;

    @NotBlank(message = "Zip Code cannot be null or empty")
    @Pattern(regexp = "(^[0-9]{8}$)", message = "Zip Code must have eight digits")
    @JsonAlias("cep")
    private String zipcode;

    @JsonIgnoreProperties("addresses")
    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;

    public Address() {
    }

    public Address(
            String street, String houseNumber,
            String complement, String district,
            String city, String state, String zipcode
    ) {
        this.street = street;
        this.houseNumber = houseNumber;
        this.complement = complement;
        this.district = district;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String postalCode) {
        this.zipcode = postalCode;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
