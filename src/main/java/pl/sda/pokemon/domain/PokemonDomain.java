package pl.sda.pokemon.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@NoArgsConstructor
@Getter
@Setter
@Entity
public class PokemonDomain {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToMany(mappedBy = "pokemonDomain", cascade = CascadeType.ALL)
    private List<AbilitiesDomain> abilities = new ArrayList<>();
    @OneToOne(mappedBy = "pokemonDomainS", cascade = CascadeType.ALL)
    private SpeciesDomain speciesDomain;
    private int base_experience;
    private String name;
    private int orderPokemon;

//
//    @JsonCreator
//    public PokemonDomain(
//            @JsonProperty("id") int id,
//            @JsonProperty("abilities") List<AbilitiesDomain> abilities,
//            @JsonProperty("speciesDomain") SpeciesDomain speciesDomain,
//            @JsonProperty("base_experience") int base_experience,
//            @JsonProperty("name") String name,
//            @JsonProperty("orderPokemon") int order) {
//        this.abilities = abilities;
//        this.speciesDomain = speciesDomain;
//        this.base_experience = base_experience;
//        this.name = name;
//        this.orderPokemon = order;
//        this.id = id;
//
//    }


    @Override
    public String toString() {
        return "PokemonDomain{" +
                "id=" + id +
                ", abilities=" + abilities +
                ", speciesDomain=" + speciesDomain +
                ", base_experience=" + base_experience +
                ", name='" + name + '\'' +
                ", orderPokemon=" + orderPokemon +
                '}';
    }
}


