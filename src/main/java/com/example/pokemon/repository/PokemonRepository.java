package com.example.pokemon.repository;

import com.example.pokemon.model.Pokemon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PokemonRepository extends JpaRepository<Pokemon, Long> {
    List<Pokemon> findByNameIgnoreCase(String name);
    List<Pokemon> findByGeneration(int generation);
    List<Pokemon> findByTypeIgnoreCase(String type);
}
