package io.samin005.springbootpostgresdemo.pokemons;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class PokemonService {

    private final PokemonRepository pokemonRepository;
    private Logger LOGGER = LoggerFactory.getLogger(PokemonService.class.getName());

    public PokemonService(PokemonRepository pokemonRepository) {
        this.pokemonRepository = pokemonRepository;
    }

    List<Pokemon> getAllPokemon(){
        List<Pokemon> pokemons = new ArrayList<>();
        pokemonRepository.findAll().forEach(pokemons::add);
        return pokemons;
    }

    Pokemon getPokemonByDexNo(String dex_no) {
        return pokemonRepository.findById(dex_no).get();
    }

    String addPokemon(Pokemon newPokemon) {
        String result = "Pokemon '" + newPokemon.name + "' added/updated successfully!";
        try{
            pokemonRepository.save(newPokemon);
        } catch (Exception e) {
            LOGGER.error(e.toString());
            result = "Error adding new pokemon\n"+e.toString();
        }
        return result;
    }
}
