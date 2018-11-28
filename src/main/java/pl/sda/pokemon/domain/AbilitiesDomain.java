package pl.sda.pokemon.domain;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class AbilitiesDomain {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @OneToMany(mappedBy = "abilitiesDomain")
    private List<AbilityDomain> abilityList= new ArrayList<>();
    @ManyToOne
    @JoinColumn(name = "abilities", nullable = false)
    private PokemonDomain pokemonDomain;
    private int slot;
    private boolean is_hidden;

    @Override
    public String toString() {
        return "AbilitiesDomain{" +
                "id=" + id +
                ", abilityList=" + abilityList +
                ", pokemonDomain=" + pokemonDomain +
                ", slot=" + slot +
                ", is_hidden=" + is_hidden +
                '}';
    }


}
