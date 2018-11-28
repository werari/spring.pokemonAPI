package pl.sda.pokemon.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;


@NoArgsConstructor
@Getter
@Setter

public class PokemonDto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private List<AbilitiesDto> abilities;
    private SpeciesDto speciesDto;
    private int base_experience;
    private String name;
    private int orderPokemon;


    @JsonCreator
    public PokemonDto(
            @JsonProperty("id") int id,
            @JsonProperty("abilities") List<AbilitiesDto> abilities,
            @JsonProperty("speciesDto") SpeciesDto speciesDto,
            @JsonProperty("base_experience") int base_experience,
            @JsonProperty("name") String name,
            @JsonProperty("orderPokemon") int orderPokemon) {
        this.abilities = abilities;
        this.speciesDto = speciesDto;
        this.base_experience = base_experience;
        this.name = name;
        this.orderPokemon = orderPokemon;
        this.id = id;

    }

    @Override
    public String toString() {
        return "PokemonDto{" +
                "id=" + id +
                ", abilities=" + abilities +
                ", speciesDto=" + speciesDto +
                ", base_experience=" + base_experience +
                ", name='" + name + '\'' +
                ", orderPokemon=" + orderPokemon +
                '}';
    }
}


