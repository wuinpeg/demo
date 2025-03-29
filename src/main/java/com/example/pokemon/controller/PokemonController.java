package com.example.pokemon.controller;

import com.example.pokemon.model.Pokemon;
import com.example.pokemon.service.PokemonService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pokemon")
public class PokemonController {

    private final PokemonService pokemonService;

    public PokemonController(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    @GetMapping
    public List<Pokemon> getAllPokemon() {
        return pokemonService.getAllPokemon();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pokemon> getPokemonById(@PathVariable Long id) {
        return ResponseEntity.of(pokemonService.getPokemonById(id));
    }

    @PreAuthorize("hasRole('EDITOR') or hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<Pokemon> addPokemon(@RequestBody Pokemon pokemon) {
        return ResponseEntity.ok(pokemonService.addPokemon(pokemon));
    }

    @PreAuthorize("hasRole('EDITOR') or hasRole('ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<Pokemon> updatePokemon(@PathVariable Long id, @RequestBody Pokemon updatedPokemon) {
        return ResponseEntity.of(pokemonService.updatePokemon(id, updatedPokemon));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePokemon(@PathVariable Long id) {
        boolean deleted = pokemonService.deletePokemon(id);
        if (deleted) {
            return ResponseEntity.ok("Pokémon deleted successfully!");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
