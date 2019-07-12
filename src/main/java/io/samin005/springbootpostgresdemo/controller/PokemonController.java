package io.samin005.springbootpostgresdemo.controller;

import io.samin005.springbootpostgresdemo.entity.PokemonsEntity;
import io.samin005.springbootpostgresdemo.service.PokemonService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PokemonController {

    private final PokemonService pokemonService;

    public PokemonController(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    @RequestMapping("/pokemons")
    public List<PokemonsEntity> getAllPokemons() {
        return pokemonService.getAllPokemon();
    }

    @RequestMapping("/pokemons/{dex_no}")
    public PokemonsEntity getPokemonByDexNo(@PathVariable int dex_no) {
        return pokemonService.getPokemonByDexNo(dex_no);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/pokemons")
    public String addNewPokemon(@RequestBody PokemonsEntity newPokemon){
        return pokemonService.addNewPokemon(newPokemon);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/pokemons")
    public String updatePokemon(@RequestBody PokemonsEntity pokemon){
        return pokemonService.updatePokemon(pokemon);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/pokemons/delete/{dex_no}")
    public String deletePokemon(@PathVariable int dex_no){
        return pokemonService.deletePokemon(dex_no);
    }
}
