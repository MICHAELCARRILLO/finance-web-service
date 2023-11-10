package com.creditovehicular.creditovehicularapi.repository;

import com.creditovehicular.creditovehicularapi.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IClientRepository extends JpaRepository<Client, Long> {
}
