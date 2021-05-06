package com.caiomacedo.personaddresses.repositories;

import com.caiomacedo.personaddresses.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

}
