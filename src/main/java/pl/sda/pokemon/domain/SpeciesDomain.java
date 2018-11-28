package pl.sda.pokemon.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@JsonIgnoreProperties(ignoreUnknown = true)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class SpeciesDomain {
    private String name;
    @OneToOne
    @JoinColumn (name = "speciesDomain")
    private PokemonDomain pokemonDomain;
    private String url;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Override
    public String toString() {
        return "SpeciesDomain{" +
                "name='" + name + '\'' +
                ", url='" + url + '\'' +
                '}';
    }

}
