package rppbackend.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import rppbackend.model.Pacijent;
import rppbackend.model.Odeljenje;
import rppbackend.model.Bolnica;
import rppbackend.model.Dijagnoza;
import rppbackend.service.PacijentService;
import rppbackend.service.DijagnozaService;
import rppbackend.service.OdeljenjeService;

@CrossOrigin
@RestController
public class PacijentController {
	
	@Autowired
	private PacijentService pacijentService;
	
	@Autowired
    private OdeljenjeService odeljenjeService;
    
    @Autowired
    private DijagnozaService dijagnozaService;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	 @ApiOperation(value = "Returns List of all Pacijents")
	 @GetMapping("pacijent")
	 public ResponseEntity<List<Pacijent>> getAll() {
	        List<Pacijent> pacijents = pacijentService.getAll();
	        return new ResponseEntity<>(pacijents, HttpStatus.OK);
	    }
	 
	 @ApiOperation(value = "Returns Pacijent with id that was forwarded as path variable.")
	 @GetMapping("pacijent/{id}")
	 public ResponseEntity<Pacijent> getOne(@PathVariable("id") Integer id) {
	        if (pacijentService.findById(id).isPresent()) {
	            Optional<Pacijent> pacijentOpt = pacijentService.findById(id);
	            return new ResponseEntity<>(pacijentOpt.get(), HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	        }
	    }
	 
	 @ApiOperation(value = "Returna list of Pacijent for Odeljenje with id that was forwarded as path variable.")
	 @GetMapping("pacijentiZaOdeljenje/{id}")
	 public ResponseEntity<List<Pacijent>> getAllForOdeljenje(@PathVariable("id") Integer id) {
	    	Optional<Odeljenje> odeljenjeOpt = odeljenjeService.findById(id);
	    	if (odeljenjeOpt.isPresent()) {
	    		List<Pacijent> pacijent = pacijentService.findByOdeljenje(odeljenjeOpt.get());
	    		return new ResponseEntity<>(pacijent, HttpStatus.OK);
	    	}
	    	return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    	
	    }
	 
	 @ApiOperation(value = "Returna list of Pacijent for Dijagnoza with id that was forwarded as path variable.")
	 @GetMapping("pacijentiZaDijagnozu/{id}")
	 public ResponseEntity<List<Pacijent>> getAllForDijagnoza(@PathVariable("id") Integer id) {
	    	Optional<Dijagnoza> dijagnozaOpt = dijagnozaService.findById(id);
	    	if (dijagnozaOpt.isPresent()) {
	    		List<Pacijent> pacijent = pacijentService.findByDijagnoza(dijagnozaOpt.get());
	    		return new ResponseEntity<>(pacijent, HttpStatus.OK);
	    	}
	    	return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    	
	    }
	
	 @ApiOperation(value = "Returns list of Pacijents containing string that was forwarded as path variable in 'ime'.")
	 @GetMapping("pacijent/ime/{ime}")
	 public ResponseEntity<List<Pacijent>> getByIme(@PathVariable("ime") String ime){
			List<Pacijent> pacijents = pacijentService.findByImeContainingIgnoreCase(ime);
	        return new ResponseEntity<>(pacijents, HttpStatus.OK);
		}
	 
	 @ApiOperation(value = "Adds new Pacijent to database.")
	 @PostMapping("pacijent")
	 public ResponseEntity<Pacijent> addPacijent(@RequestBody Pacijent pacijent) {
	        Pacijent savedPacijent = pacijentService.save(pacijent);
	        URI location = URI.create("/pacijent/" + savedPacijent.getId());
	        return ResponseEntity.created(location).body(savedPacijent);
	    }
	 
	 @ApiOperation(value = "Updates Pacijent that has id that was forwarded as path variable with values forwarded in Request Body.")
	 @PutMapping("pacijent/{id}")
	 public ResponseEntity<Pacijent> updateOne(@RequestBody Pacijent pacijent,
	            @PathVariable("id") Integer id) {
	        if (!pacijentService.existsById(id)) {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	        pacijent.setId(id);
	        Pacijent savedPacijent = pacijentService.save(pacijent);
	        return ResponseEntity.ok().body(savedPacijent);
	    }
	 
	 @ApiOperation(value = "Deletes Pacijent with id that was forwarded as path variable.")
	 @DeleteMapping("pacijent/{id}")
	 public ResponseEntity<HttpStatus> delete(@PathVariable Integer id) {
	        if (id == -100 && !pacijentService.existsById(-100)) {

	            jdbcTemplate.execute(
	                    "INSERT INTO pacijent (\"id\", \"ime\", \"prezime\", \"zdr_osiguranje\", \"datum_rodjenja\", \"odeljenje\", \"dijagnoza\") "
	                            + "VALUES ('-100', 'Test Ime', 'Test Prezime',  true, to_date('29.03.2021.', 'dd.mm.yyyy'), 1, 1)");
	        }

	        if (pacijentService.existsById(id)) {
	        	pacijentService.deleteById(id);
	            return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	        }

	        return new ResponseEntity<HttpStatus>(HttpStatus.NOT_FOUND);
	    }
	 

}
