package rppbackend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rppbackend.model.Odeljenje;
import rppbackend.model.Dijagnoza;
import rppbackend.model.Pacijent;
import rppbackend.repository.PacijentRepository;

@Service
public class PacijentService {
	
	@Autowired
	private PacijentRepository pacijentRepository;
	
	public List<Pacijent> getAll() {
        return pacijentRepository.findAll();
    }
    
    public List<Pacijent> findByImeContainingIgnoreCase(String ime) {
        return pacijentRepository.findByImeContainingIgnoreCase(ime);
    }

    public List<Pacijent> findByOdeljenje(Odeljenje odeljenje) {
        return pacijentRepository.findByOdeljenje(odeljenje);
    }
    
    public List<Pacijent> findByDijagnoza(Dijagnoza dijagnoza) {
        return pacijentRepository.findByDijagnoza(dijagnoza);
    } 

    public Optional<Pacijent> findById(Integer id) {
        return pacijentRepository.findById(id);
    }

    public Pacijent save(Pacijent pacijent) {
        return pacijentRepository.save(pacijent);
    }

    public boolean existsById(Integer id) {
        return pacijentRepository.existsById(id);
    }

    public void deleteById(Integer id) {
        pacijentRepository.deleteById(id);
    }
}
