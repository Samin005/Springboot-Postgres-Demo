package io.samin005.springbootpostgresdemo.service;

import io.samin005.springbootpostgresdemo.dao.PokemonRepository;
import io.samin005.springbootpostgresdemo.entity.PokemonsEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PokemonService {

    private final PokemonRepository pokemonRepository;

    public PokemonService(PokemonRepository pokemonRepository) {
        this.pokemonRepository = pokemonRepository;
    }

    public List<PokemonsEntity> getAllPokemon() {
        List<PokemonsEntity> pokemons = new ArrayList<>();
        pokemonRepository.findAll().forEach(pokemons::add);
        return pokemons;
    }

    public PokemonsEntity getPokemonByDexNo(int dex_no) {
        if (pokemonRepository.findById(dex_no).isPresent()) {
            return pokemonRepository.findById(dex_no).get();
        } else return null;
    }

    public String addNewPokemon(PokemonsEntity newPokemon) {
        if (pokemonRepository.existsById(newPokemon.getDexNo())) {
            pokemonRepository.save(newPokemon);
            return "Pokemon '" + newPokemon.getName() + "' with dex no " + newPokemon.getDexNo() + " already existed and it was updated!";
        } else {
            pokemonRepository.save(newPokemon);
            return "Pokemon '" + newPokemon.getName() + "' added successfully!";
        }
    }

    public String updatePokemon(PokemonsEntity pokemon) {
        if (pokemonRepository.existsById(pokemon.getDexNo())) {
            pokemonRepository.save(pokemon);
            return pokemon.getName() + " with dex no " + pokemon.getDexNo() + " has been updated!";
        } else {
            return "Pokedex no " + pokemon.getDexNo() + " does not exist. Try a POST request.";
        }
    }

    public String deletePokemon(int dex_no) {
        if (pokemonRepository.existsById(dex_no)) {
            pokemonRepository.deleteById(dex_no);
            return "Pokemon with dex no " + dex_no + " has been deleted!";
        } else {
            return "Pokedex no " + dex_no + " does not exist.";
        }
    }
}
