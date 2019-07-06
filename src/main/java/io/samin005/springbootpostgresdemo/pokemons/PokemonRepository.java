package io.samin005.springbootpostgresdemo.pokemons;

import org.springframework.data.repository.CrudRepository;

public interface PokemonRepository extends CrudRepository<Pokemon, String> {
}
