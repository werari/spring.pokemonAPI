package pl.sda.pokemon.dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import java.util.List;
@JsonIgnoreProperties(ignoreUnknown = true)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class AbilitiesDto {
    private List<AbilityDto> abilityList;
    private boolean is_hidden;
    private int slot;
    @Override
    public String toString() {
        return "AbilitiesDto{" +
                "abilityList=" + abilityList +
                ", is_hidden=" + is_hidden +
                ", slot=" + slot +
                '}';
    }



}
