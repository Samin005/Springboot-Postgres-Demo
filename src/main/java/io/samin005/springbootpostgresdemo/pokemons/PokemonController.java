package io.samin005.springbootpostgresdemo.pokemons;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class PokemonController {

    private final PokemonService pokemonService;

    public PokemonController(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    @RequestMapping("/pokemons")
    public List<Pokemon> getAllPokemons() {
        return pokemonService.getAllPokemon();
    }

    @RequestMapping("/pokemons/{dex_no}")
    public Pokemon getPokemonByDexNo(@PathVariable String dex_no) {
        return pokemonService.getPokemonByDexNo(dex_no);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/pokemons")
    public String addPokemon(@RequestBody Pokemon newPokemon) {
        return pokemonService.addPokemon(newPokemon);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/pokemons")
    public String updatePokemon(@RequestBody Pokemon newPokemon) {
        return pokemonService.updatePokemon(newPokemon);
    }
}
