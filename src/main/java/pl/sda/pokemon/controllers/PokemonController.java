package pl.sda.pokemon.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pl.sda.pokemon.dto.PokemonDto;
import pl.sda.pokemon.repository.PokemonRepository;

import java.util.Optional;

@RestController
public class PokemonController {
    private PokemonRepository pokemonRepository;
@Autowired
    public PokemonController(PokemonRepository pokemonRepository) {
        this.pokemonRepository = pokemonRepository;
    }

    @RequestMapping("/pokemon")
    public String findPokemonById(@RequestParam(value = "id") int id) {
        return pokemonRepository.findById(Long.valueOf(id)).toString();
    }
}
