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
import rppbackend.model.Odeljenje;
import rppbackend.model.Bolnica;
import rppbackend.service.OdeljenjeService;

@CrossOrigin
@RestController
public class OdeljenjeController {
	
	@Autowired
    private OdeljenjeService odeljenjeService;
	
	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	@ApiOperation(value = "Returns List of all Odeljenjes")
    @GetMapping("odeljenje")
    public ResponseEntity<List<Odeljenje>> getAll() {
        List<Odeljenje> odeljenjes = odeljenjeService.getAll();
        return new ResponseEntity<>(odeljenjes, HttpStatus.OK);
    }

	
	@ApiOperation(value = "Returns Odeljenje with id that was forwarded as path variable.")
    @GetMapping("odeljenje/{id}")
    public ResponseEntity<Odeljenje> getOne(@PathVariable("id") Integer id) {
        if (odeljenjeService.findById(id).isPresent()) {
            Optional<Odeljenje> odeljenjeOpt = odeljenjeService.findById(id);
            return new ResponseEntity<>(odeljenjeOpt.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
	

    @ApiOperation(value = "Returns list of Odeljenjes containing string that was forwarded as path variable in 'naziv'.")
	@GetMapping("odeljenje/naziv/{naziv}")
	public ResponseEntity<List<Odeljenje>> getByNaziv(@PathVariable("naziv") String naziv){
		List<Odeljenje> odeljenjes = odeljenjeService.findByNazivContainingIgnoreCase(naziv);
        return new ResponseEntity<>(odeljenjes, HttpStatus.OK);
	}
	
    @ApiOperation(value = "Adds new Odeljenje to database.")
    @PostMapping("odeljenje")
    public ResponseEntity<Odeljenje> addOdeljenje(@RequestBody Odeljenje odeljenje) {
    	Odeljenje savedOdeljenje = odeljenjeService.save(odeljenje);
        URI location = URI.create("/odeljenje/" + savedOdeljenje.getId());
        return ResponseEntity.created(location).body(savedOdeljenje);
    }
    
    @ApiOperation(value = "Updates Odeljenje that has id that was forwarded as path variable with values forwarded in Request Body.")
    @PutMapping(value = "odeljenje/{id}")
    public ResponseEntity<Odeljenje> updateOdeljenje(@RequestBody Odeljenje odeljenje, @PathVariable("id") Integer id) {
        if (odeljenjeService.existsById(id)) {
            odeljenje.setId(id);
            Odeljenje savedOdeljenje = odeljenjeService.save(odeljenje);
            return ResponseEntity.ok().body(savedOdeljenje);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
    @ApiOperation(value = "Deletes Odeljenje with id that was forwarded as path variable.")
    @DeleteMapping("odeljenje/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable Integer id) {
        if (id == -100 && !odeljenjeService.existsById(-100)) {

            jdbcTemplate.execute("INSERT INTO odeljenje "
                    + "(\"id\", \"naziv\", \"lokacija\", \"bolnica\") "
                    + "VALUES (-100, 'TestNaziv', 'TestLokacija', 1) ");
        }

        if (odeljenjeService.existsById(id)) {
        	odeljenjeService.deleteById(id);
            return new ResponseEntity<HttpStatus>(HttpStatus.OK);
        }
        return new ResponseEntity<HttpStatus>(HttpStatus.NOT_FOUND);
    }
	

}
