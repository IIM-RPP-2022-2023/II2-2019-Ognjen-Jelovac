package rppbackend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rppbackend.model.Odeljenje;
import rppbackend.repository.OdeljenjeRepository;

@Service
public class OdeljenjeService {
	
	@Autowired
	private OdeljenjeRepository odeljenjeRepository;
	
		public List<Odeljenje> getAll(){
			return odeljenjeRepository.findAll();
		}

		public Optional<Odeljenje> findById(Integer id) {
			return odeljenjeRepository.findById(id);
		}

		public List<Odeljenje> findByNazivContainingIgnoreCase(String naziv) {
			return odeljenjeRepository.findByNazivContainingIgnoreCase(naziv);
		}

		public Odeljenje save(Odeljenje odeljenje) {
			return odeljenjeRepository.save(odeljenje);
		}

		public boolean existsById(Integer id) {
			return odeljenjeRepository.existsById(id);
		}

		public void deleteById(Integer id) {
			odeljenjeRepository.deleteById(id);
		}
	
}


