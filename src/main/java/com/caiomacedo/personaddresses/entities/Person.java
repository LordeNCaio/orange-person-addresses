package com.caiomacedo.personaddresses.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "t_person")
public class Person extends BaseEntity {

    @NotBlank(message = "Name cannot be null or empty.")
    private String name;

    @NotBlank(message = "Email cannot be null or empty.")
    @Email(message = "Email must be email@email.com")
    @Column(unique = true)
    private String email;

    @NotBlank(message = "CPF cannot be null or empty")
    @Pattern(regexp = "(([0-9]{3}[.]){2}[0-9]{3}[-][0-9]{2})", message = "CPF must be 000.000.000.-00")
    @Column(unique = true)
    private String cpf;

    @NotNull(message = "Birth date cannot be null")
    @Past(message = "Birth date must be in the past")
    private LocalDate birthDate;

    @JsonIgnoreProperties("person")
    @OneToMany(targetEntity = Address.class, cascade = CascadeType.ALL)
    private List<Address> addresses;

    public Person() {

    }

    public Person(String name, String email, String cpf, LocalDate birthDate) {
        this.name = name;
        this.email = email;
        this.cpf = cpf;
        this.birthDate = birthDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }
}
