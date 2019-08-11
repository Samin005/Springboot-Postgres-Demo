package io.samin005.springbootpostgresdemo.dao;

import io.samin005.springbootpostgresdemo.entity.PokemonsEntity;
import org.springframework.data.repository.CrudRepository;


public interface PokemonRepository extends CrudRepository<PokemonsEntity, Integer> {
    Iterable<PokemonsEntity> findAllByOrderByDexNoAsc();
}
