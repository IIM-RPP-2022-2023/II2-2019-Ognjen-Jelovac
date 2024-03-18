package rppbackend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import rppbackend.model.Pacijent;
import rppbackend.model.Odeljenje;
import rppbackend.model.Dijagnoza;


public interface PacijentRepository extends JpaRepository<Pacijent, Integer>{
	
	List<Pacijent>findByImeContainingIgnoreCase(String ime); 
	List<Pacijent>findByOdeljenje(Odeljenje odeljenje); 
	List<Pacijent>findByDijagnoza(Dijagnoza dijagnoza); 
	
	 
}
