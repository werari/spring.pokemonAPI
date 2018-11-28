package pl.sda.pokemon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.sda.pokemon.domain.PokemonDomain;

@Repository
public interface PokemonRepository extends JpaRepository<PokemonDomain, Long> {
}
