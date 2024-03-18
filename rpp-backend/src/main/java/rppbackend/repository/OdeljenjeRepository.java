package rppbackend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import rppbackend.model.Odeljenje;

public interface OdeljenjeRepository extends JpaRepository<Odeljenje, Integer> {

	List<Odeljenje> findByNazivContainingIgnoreCase(String naziv);

}
