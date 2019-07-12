package io.samin005.springbootpostgresdemo.pokemons;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class PokemonService {

    private final PokemonRepository pokemonRepository;
    private final MovesRepository movesRepository;
    private Logger LOGGER = LoggerFactory.getLogger(PokemonService.class.getName());

    public PokemonService(PokemonRepository pokemonRepository, MovesRepository movesRepository) {
        this.pokemonRepository = pokemonRepository;
        this.movesRepository = movesRepository;
    }

    List<Pokemon> getAllPokemon(){
        List<Pokemon> pokemons = new ArrayList<>();
        pokemonRepository.findAll().forEach(pokemons::add);
        return pokemons;
    }

    Pokemon getPokemonByDexNo(String dex_no) {
        if(pokemonRepository.findById(dex_no).isPresent()) {
            return pokemonRepository.findById(dex_no).get();
        }
        else {
            return null;
        }
    }

    //JPA repository.save method inserts/updates. That's why this is done for specific requests.
    String addPokemon(Pokemon newPokemon) {
        String result;
        String pokemonCheckStatus = checkPokemonProperties(newPokemon);
        if(pokemonCheckStatus.equals("OK")) {
            try{
                if(pokemonRepository.existsById(newPokemon.getDex_no())) {
                    result = "Poke dex no. '" + newPokemon.getDex_no() + "' already exists with name '"+ newPokemon.getName() + "'. Try a PUT request!";
                    LOGGER.warn(result);
                } else {
                    pokemonRepository.save(newPokemon);
                    result = "Pokemon '" + newPokemon.getName() + "' added successfully!";
                    LOGGER.info(result);
                }
            } catch (Exception e) {
                result = "Error adding new pokemon:\n"+e.toString();
                LOGGER.error(e.toString());
            }

        } else {
            result = "Error in pokemon format";
            result = setResultErrorString(pokemonCheckStatus, result);
            LOGGER.error(result);
        }
        return result;
    }

    String updatePokemon(Pokemon newPokemon) {
        String result;
        String pokemonCheckStatus = checkPokemonProperties(newPokemon);
        if(pokemonCheckStatus.equals("OK")) {
            try{
                if(pokemonRepository.existsById(newPokemon.getDex_no())) {
                    pokemonRepository.save(newPokemon);
                    result = "Pokemon '" + newPokemon.getName() + "' updated successfully!";
                    LOGGER.info(result);
                } else {
                    result = "Poke dex no. '" + newPokemon.getDex_no() + "' does not exist. Try a POST request!";
                    LOGGER.warn(result);
                }
            } catch (Exception e) {
                result = "Error adding new pokemon:\n"+e.toString();
                LOGGER.error(e.toString());
            }

        } else {
            result = "Error in pokemon format";
            result = setResultErrorString(pokemonCheckStatus, result);
            LOGGER.error(result);
        }
        return result;
    }

    MovesEntity getMoves(String dex_no) {
        return movesRepository.findById(dex_no).get();
    }

    private String checkPokemonProperties(Pokemon pokemon) {
        String result = "OK";
        if(pokemon.getDex_no() == null) result = "dex_no";
        else if(pokemon.getName() == null) result = "name";
        else if(pokemon.getDescription() == null) result = "description";
        return result;
    }

    private String setResultErrorString(String pokemonCheckStatus, String result) {
        switch (pokemonCheckStatus) {
            case "dex_no":
                result += ": dex_no";
                break;
            case "name":
                result += ": name";
                break;
            case "description":
                result += ": description";
                break;
        }
        return result;
    }
}
