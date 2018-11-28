package pl.sda.pokemon.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pl.sda.pokemon.domain.PokemonDomain;

import pl.sda.pokemon.dto.PokemonDto;
import pl.sda.pokemon.repository.PokemonRepository;
import pl.sda.pokemon.services.PokemonService;

import java.util.List;
import java.util.Optional;


@RestController
public class PokemonController {
    private PokemonRepository pokemonRepository;
    private PokemonService pokemonService;

    @Autowired
    public PokemonController(PokemonRepository pokemonRepository, PokemonService pokemonService) {
        this.pokemonRepository = pokemonRepository;
        this.pokemonService = pokemonService;
    }

    @RequestMapping("/pokemon")
    public PokemonDomain returnPokemonById(@RequestParam(value = "id") Long id) {

        Optional<PokemonDomain> byId = pokemonRepository.findById(id);

        if (byId.isPresent()) {
            return byId.get();
        } else {
            PokemonDto pokemonFromApi = pokemonService.getPokemonFromApi(id);
            PokemonDomain pokemonDomain = pokemonService.convertPokemon(pokemonFromApi);
            PokemonDomain save = pokemonRepository.save(pokemonDomain);
            return save;
        }

    }

    @RequestMapping("/pokemonAll")
    public List<PokemonDomain> returnAllPokemon() {
        return pokemonRepository.findAll();


    }

}
