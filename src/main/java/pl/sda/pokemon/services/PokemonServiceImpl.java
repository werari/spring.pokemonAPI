package pl.sda.pokemon.services;

import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.sda.pokemon.domain.AbilitiesDomain;
import pl.sda.pokemon.domain.PokemonDomain;
import pl.sda.pokemon.domain.SpeciesDomain;
import pl.sda.pokemon.dto.AbilitiesDto;
import pl.sda.pokemon.dto.PokemonDto;
import pl.sda.pokemon.dto.SpeciesDto;

import java.util.List;

@Service
public class PokemonServiceImpl implements PokemonService {


    @Override
    public PokemonDto getPokemonFromApi(Long id) {

        CloseableHttpClient httpClient
                = HttpClients.custom().setSSLHostnameVerifier(new NoopHostnameVerifier())
                .build();
        HttpComponentsClientHttpRequestFactory requestFactory
                = new HttpComponentsClientHttpRequestFactory();
        requestFactory.setHttpClient(httpClient);

        PokemonDto pokemonDto = new RestTemplate(requestFactory).getForObject("https://pokeapi.co/api/v2/pokemon/" + id, PokemonDto.class);

        return pokemonDto;
    }


    @Override
    public PokemonDomain convertPokemon(PokemonDto pokemonDto) {
        SpeciesDomain speciesParsedFromDto = new SpeciesDomain();
        PokemonDomain pokemonParsedFromDto = new PokemonDomain();
        SpeciesDto species = pokemonDto.getSpecies();
        speciesParsedFromDto.setName(species.getName());
        speciesParsedFromDto.setUrl(species.getUrl());
        speciesParsedFromDto.setPokemonDomainS(pokemonParsedFromDto);


        //  AbilitiesDomain abilitiesParsedFromDto = new AbilitiesDomain();
        // List<AbilitiesDto> abilitiesDto = pokemonDto.getAbilities();
        // abilitiesParsedFromDto.setSlot(abilitiesDto.);



        pokemonParsedFromDto.setName(pokemonDto.getName());
        pokemonParsedFromDto.setSpeciesDomain(speciesParsedFromDto);

        return pokemonParsedFromDto;
    }
}
