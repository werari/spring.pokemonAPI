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
    private Long id;
    private List<AbilitiesDto> abilities;
    private SpeciesDto species;
    private int base_experience;
    private String name;
    private int orderPokemon;


    @JsonCreator
    public PokemonDto(
            @JsonProperty("id") Long id,
            @JsonProperty("abilities") List<AbilitiesDto> abilities,
            @JsonProperty("species") SpeciesDto species,
            @JsonProperty("base_experience") int base_experience,
            @JsonProperty("name") String name,
            @JsonProperty("orderPokemon") int orderPokemon) {
        this.abilities = abilities;
        this.species = species;
        this.base_experience = base_experience;
        this.name = name;
        this.orderPokemon = orderPokemon;
        this.id = id;


    }

    @Override
    public String toString() {
        return "PokemonDto{" +
                "id=" + id +
//                ", abilities=" + abilities +
//                ", species=" + species +
//                ", base_experience=" + base_experience +
                ", name='" + name + '\'' +
                ", orderPokemon=" + orderPokemon +
                '}';
    }
}


