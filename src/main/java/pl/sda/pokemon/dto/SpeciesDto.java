package pl.sda.pokemon.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
@JsonIgnoreProperties(ignoreUnknown = true)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class SpeciesDto {
    private String name;
    private String url;

    @Override
    public String toString() {
        return "SpeciesDto{" +
                "name='" + name + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}

