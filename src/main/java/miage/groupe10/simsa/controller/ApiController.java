package miage.groupe10.simsa.controller;


import miage.groupe10.simsa.service.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "https://polite-dune-015e2f203.4.azurestaticapps.net/")
public class ApiController {

    @GetMapping("/api/greet")
    public ResponseEntity<?> greet(@RequestParam(required = true) String name) {
        if (name == null || name.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Le paramètre 'name' est obligatoire et ne peut pas être vide.");
        }
        return ResponseEntity.ok("Bonjour, " + name + " !");
    }


    @Autowired
    private PokemonService pokemonService;

    @GetMapping("/api/pokemon")
    public ResponseEntity<String> getPokemon(@RequestParam String name) {

        String response = pokemonService.getPokemon(name);
        return ResponseEntity.ok(response);
    }
}
