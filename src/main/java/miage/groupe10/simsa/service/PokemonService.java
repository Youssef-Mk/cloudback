package miage.groupe10.simsa.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PokemonService {

    @Autowired
    private RestTemplate restTemplate;

    private static final String POKEAPI_URL = "https://pokeapi.co/api/v2/pokemon/{name}";

    public String getPokemon(String name) {
        try {
            // Effectuer un appel GET vers l'API PokéAPI
            String response = restTemplate.getForObject(POKEAPI_URL, String.class, name);
            return response;
        } catch (Exception e) {
            // Gérer les erreurs (par exemple, Pokémon introuvable)
            return "Erreur lors de l'appel à l'API PokéAPI : " + e.getMessage();
        }
    }
}
