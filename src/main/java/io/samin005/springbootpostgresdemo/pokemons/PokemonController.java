package io.samin005.springbootpostgresdemo.pokemons;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PokemonController {

    @Autowired
    private PokemonService pokemonService;

    @RequestMapping("/pokemons")
    public List<Pokemon> getAllPokemons(){
        return pokemonService.getAllPokemon();
    }
}
