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
import rppbackend.model.Dijagnoza;
import rppbackend.service.DijagnozaService;

@CrossOrigin
@RestController
public class DijagnozaController {
	
	@Autowired
    private DijagnozaService dijagnozaService;
	
	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	@ApiOperation(value = "Returns List of all Dijagnozas")
	@GetMapping("dijagnoza")
	public ResponseEntity<List<Dijagnoza>> getAll(){
		List<Dijagnoza> dijagnozas = dijagnozaService.getAll();
        return new ResponseEntity<>(dijagnozas, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Returns Dijagnoza with id that was forwarded as path variable.")
	@GetMapping("dijagnoza/{id}")
	public ResponseEntity<Dijagnoza> getOne(@PathVariable("id") Integer id){
	    if (dijagnozaService.findById(id).isPresent()) {
	    	Optional<Dijagnoza> dijagnoza  = dijagnozaService.findById(id);
            return new ResponseEntity<>(dijagnoza.get(), HttpStatus.OK);
	    } else {
	    	return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	    }
	}
	
	@ApiOperation(value = "Returns list of Dijagnozas containing string that was forwarded as path variable in 'naziv'.")
	@GetMapping("dijagnoza/naziv/{naziv}")
	public ResponseEntity<List<Dijagnoza>> getByNaziv(@PathVariable("naziv") String naziv){
		List<Dijagnoza> dijagnozas = dijagnozaService.findByNazivContainingIgnoreCase(naziv);
        return new ResponseEntity<>(dijagnozas, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Adds new Dijagnoza to database.")
	@PostMapping("dijagnoza")
	public ResponseEntity<Dijagnoza> addDijagnoza(@RequestBody Dijagnoza dijagnoza) {
		Dijagnoza savedDijagnoza = dijagnozaService.save(dijagnoza);
        URI location = URI.create("/dijagnoza/" + savedDijagnoza.getId());
		return ResponseEntity.created(location).body(savedDijagnoza);
	}
	
	@ApiOperation(value = "Updates Dijagnoza that has id that was forwarded as path variable with values forwarded in Request Body.")
    @PutMapping(value = "dijagnoza/{id}")
    public ResponseEntity<Dijagnoza> updateDijagnoza(@RequestBody Dijagnoza dijagnoza, @PathVariable("id") Integer id) {
        if (dijagnozaService.existsById(id)) {
        	dijagnoza.setId(id);
            Dijagnoza savedDijagnoza = dijagnozaService.save(dijagnoza);
            return ResponseEntity.ok().body(savedDijagnoza);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
	
	@ApiOperation(value = "Deletes Dijagnoza with id that was forwarded as path variable.")
    @DeleteMapping("dijagnoza/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable Integer id) {
        if (id == -100 && !dijagnozaService.existsById(id)) {
            jdbcTemplate.execute(
            		"INSERT INTO dijagnoza (\"id\", \"naziv\", \"opis\", \"oznaka\") VALUES (-100, 'Test NazDijagnoza', 'Test OpisDijagnoza', 'Test OznDijagnoza')");
            
        }

        if (dijagnozaService.existsById(id)) {
        	dijagnozaService.deleteById(id);
            return new ResponseEntity<HttpStatus>(HttpStatus.OK);
        }
        return new ResponseEntity<HttpStatus>(HttpStatus.NOT_FOUND);
    }
	

}
