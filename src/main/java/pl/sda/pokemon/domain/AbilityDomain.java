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
public class AbilityDomain {

    private String name;
    private String url;


    @Override
    public String toString() {
        return "AbilityDomain{" +
                "name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", id=" + id +
                ", abilitiesDomain=" + abilitiesDomain +
                '}';
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne (cascade = CascadeType.ALL)
    private AbilitiesDomain abilitiesDomain;

}
