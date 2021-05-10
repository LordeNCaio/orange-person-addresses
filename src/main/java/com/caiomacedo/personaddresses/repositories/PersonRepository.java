package com.caiomacedo.personaddresses.repositories;

import com.caiomacedo.personaddresses.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    Optional<Person> findPersonByEmailOrCpf(String email, String cpf);
}
