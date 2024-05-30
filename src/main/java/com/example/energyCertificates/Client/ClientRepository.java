package com.example.energyCertificates.Client;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepository extends CrudRepository<Client, Long> {
    void deleteByEmail(String email);

    Optional<Client> findByEmail(String email);
}
