package rppbackend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import rppbackend.model.Dijagnoza;


public interface DijagnozaRepository extends JpaRepository<Dijagnoza, Integer>{
	
	List<Dijagnoza> findByNazivContainingIgnoreCase(String naziv);



}
