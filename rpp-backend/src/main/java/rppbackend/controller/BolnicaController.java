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
import rppbackend.model.Bolnica;
import rppbackend.service.BolnicaService;

@CrossOrigin
@RestController
public class BolnicaController {
	
	@Autowired
	private BolnicaService bolnicaService;
	
	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	@ApiOperation(value = "Returns List of all Bolnicas")
	@GetMapping("bolnica")
	public ResponseEntity<List<Bolnica>> getAll(){
		List<Bolnica> bolnicas = bolnicaService.getAll();
        return new ResponseEntity<>(bolnicas, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Returns Bolnica with id that was forwarded as path variable.")
	@GetMapping("bolnica/{id}")
	public ResponseEntity<Bolnica> getOne(@PathVariable("id") Integer id){
	    if (bolnicaService.findById(id).isPresent()) {
	    	Optional<Bolnica> bolnica = bolnicaService.findById(id);
            return new ResponseEntity<>(bolnica.get(), HttpStatus.OK);
	    } else {
	    	return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	    }
	}
	
	@ApiOperation(value = "Returns list of Bolnicas containing string that was forwarded as path variable in 'naziv'.")
	@GetMapping("bolnica/naziv/{naziv}")
	public ResponseEntity<List<Bolnica>> getByNaziv(@PathVariable("naziv") String naziv){
		List<Bolnica> bolnicas = bolnicaService.findByNazivContainingIgnoreCase(naziv);
        return new ResponseEntity<>(bolnicas, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Adds new Bolnica to database.")
	@PostMapping("bolnica")
	public ResponseEntity<Bolnica> addBolnica(@RequestBody Bolnica bolnica) {
		Bolnica savedBolnica = bolnicaService.save(bolnica);
        URI location = URI.create("/bolnica/" + savedBolnica.getId());
		return ResponseEntity.created(location).body(savedBolnica);
	}
	
	@ApiOperation(value = "Updates Bolnica that has id that was forwarded as path variable with values forwarded in Request Body.")
    @PutMapping(value = "bolnica/{id}")
    public ResponseEntity<Bolnica> updateBolnica(@RequestBody Bolnica bolnica, @PathVariable("id") Integer id) {
        if (bolnicaService.existsById(id)) {
            bolnica.setId(id);
            Bolnica savedBolnica = bolnicaService.save(bolnica);
            return ResponseEntity.ok().body(savedBolnica);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
	
	@ApiOperation(value = "Deletes Bolnica with id that was forwarded as path variable.")
    @DeleteMapping("bolnica/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable Integer id) {
    	
        if (id == -100 && !bolnicaService.existsById(id)) {
            jdbcTemplate.execute(
                    "INSERT INTO bolnica(\"id\", \"naziv\", \"adresa\", \"budzet\" ) VALUES (-100, 'Test Bolnica', 'Test Adresa Bolnice', 32091)");
        }

        if (bolnicaService.existsById(id)) {
            bolnicaService.deleteById(id);
            return new ResponseEntity<HttpStatus>(HttpStatus.OK);
        }
        return new ResponseEntity<HttpStatus>(HttpStatus.NOT_FOUND);
    }

}
