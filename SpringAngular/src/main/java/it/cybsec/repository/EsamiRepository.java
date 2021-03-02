package it.cybsec.repository;

import it.cybsec.model.Esami;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EsamiRepository extends JpaRepository<Esami, Integer>{

}
