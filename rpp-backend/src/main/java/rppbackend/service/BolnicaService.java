package rppbackend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rppbackend.model.Bolnica;
import rppbackend.repository.BolnicaRepository;

@Service
public class BolnicaService {
	
	@Autowired
	private BolnicaRepository bolnicaRepository;
	
		public List<Bolnica> getAll(){
			return bolnicaRepository.findAll();
		}
	
		public Optional<Bolnica> findById(Integer id) {
			return bolnicaRepository.findById(id);
		}
	
		public List<Bolnica> findByNazivContainingIgnoreCase(String naziv) {
			return bolnicaRepository.findByNazivContainingIgnoreCase(naziv);
		}

		public Bolnica save(Bolnica bolnica) {
			return bolnicaRepository.save(bolnica);
		}
	
		public boolean existsById(Integer id) {
			return bolnicaRepository.existsById(id);
		}
	
		public void deleteById(Integer id) {
			bolnicaRepository.deleteById(id);
		}

}
