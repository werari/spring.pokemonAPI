package pl.sda.pokemon.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import pl.sda.pokemon.domain.PokemonDomain;

import pl.sda.pokemon.domain.SpeciesDomain;
import pl.sda.pokemon.dto.PokemonDto;
import pl.sda.pokemon.dto.SpeciesDto;
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

    @GetMapping("/pokemon")
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

    @GetMapping("/pokemonAll")
    public List<PokemonDomain> returnAllPokemon() {
        return pokemonRepository.findAll();


    }

    @PostMapping("/addPokemonUrl")
    public Long addNewPokemonByUrlParam(@RequestParam(value = "name") String name,
                                        @RequestParam(value = "speciesName") String speciesName,
                                        @RequestParam(value = "speciesUrl") String url) {


        PokemonDomain pokemonDomain = new PokemonDomain();
        SpeciesDomain speciesDomain = new SpeciesDomain();

        speciesDomain.setName(speciesName);
        speciesDomain.setUrl(url);
        speciesDomain.setPokemonDomainS(pokemonDomain);

        pokemonDomain.setName(name);
        pokemonDomain.setSpeciesDomain(speciesDomain);

        PokemonDomain save = pokemonRepository.save(pokemonDomain);
        Long idNewPokemon = save.getId();
        //return pokemon id after save to db
        return idNewPokemon ;
    }

    @PostMapping("/addPokemonBody")
    public int addNewPokemonByBody() {

        //return pokemon id after save to db

        return 0;

    }

}
