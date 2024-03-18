package rppbackend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import rppbackend.model.Bolnica;

public interface BolnicaRepository extends JpaRepository<Bolnica, Integer>{
	
	List<Bolnica> findByNazivContainingIgnoreCase(String naziv);

}
