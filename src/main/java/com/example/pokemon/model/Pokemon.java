package com.example.pokemon.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;


@Entity
@Table(name = "pokemon")
public class Pokemon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String type;
    private int generation;

    // Constructors, Getters, and Setters
    public Pokemon() {}

    public Pokemon(String name, String type, int generation) {
        this.name = name;
        this.type = type;
        this.generation = generation;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public int getGeneration() { return generation; }
    public void setGeneration(int generation) { this.generation = generation; }
}
