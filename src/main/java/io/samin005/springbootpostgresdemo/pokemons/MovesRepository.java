package io.samin005.springbootpostgresdemo.pokemons;

import org.springframework.data.repository.CrudRepository;

public interface MovesRepository extends CrudRepository<MovesEntity, String> {
}
