package rppbackend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rppbackend.model.Dijagnoza;
import rppbackend.repository.DijagnozaRepository;

@Service
public class DijagnozaService {

	@Autowired
	private DijagnozaRepository dijagnozaRepository;
	
	 	public List<Dijagnoza> getAll(){
	        return dijagnozaRepository.findAll();
	    }

	    public Optional<Dijagnoza> findById(Integer id) {
	        return dijagnozaRepository.findById(id);
	    }

	    public List<Dijagnoza> findByNazivContainingIgnoreCase(String naziv) {
	        return dijagnozaRepository.findByNazivContainingIgnoreCase(naziv);
	    }

	    public Dijagnoza save(Dijagnoza dijagnoza) {
	        return dijagnozaRepository.save(dijagnoza);
	    }

	    public boolean existsById(Integer id) {
	        return dijagnozaRepository.existsById(id);
	    }

	    public void deleteById(Integer id) {
	        dijagnozaRepository.deleteById(id);
	    }
}
