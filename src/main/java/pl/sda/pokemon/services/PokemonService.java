package pl.sda.pokemon.services;

import org.springframework.stereotype.Service;
import pl.sda.pokemon.domain.PokemonDomain;
import pl.sda.pokemon.dto.PokemonDto;


public interface PokemonService {
    PokemonDto getPokemonFromApi (Long id);
PokemonDomain convertPokemon (PokemonDto pokemonDto);

}
