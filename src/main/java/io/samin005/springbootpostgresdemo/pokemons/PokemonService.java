package io.samin005.springbootpostgresdemo.pokemons;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PokemonService {

    private final PokemonRepository pokemonRepository;

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
}
