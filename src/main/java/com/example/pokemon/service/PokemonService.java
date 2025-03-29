package com.example.pokemon.service;

import com.example.pokemon.model.Pokemon;
import com.example.pokemon.repository.PokemonRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PokemonService {

    private final PokemonRepository pokemonRepository;

    public PokemonService(PokemonRepository pokemonRepository) {
        this.pokemonRepository = pokemonRepository;
    }

    public List<Pokemon> getAllPokemon() {
        return pokemonRepository.findAll();
    }

    public Optional<Pokemon> getPokemonById(Long id) {
        return pokemonRepository.findById(id);
    }

    public Pokemon addPokemon(Pokemon pokemon) {
        return pokemonRepository.save(pokemon);
    }

    public Optional<Pokemon> updatePokemon(Long id, Pokemon updatedPokemon) {
        if (pokemonRepository.existsById(id)) {
            updatedPokemon.setId(id);
            return Optional.of(pokemonRepository.save(updatedPokemon));
        }
        return Optional.empty();
    }

    public boolean deletePokemon(Long id) {
        if (pokemonRepository.existsById(id)) {
            pokemonRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
