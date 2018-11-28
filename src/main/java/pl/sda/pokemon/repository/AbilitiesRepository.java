package pl.sda.pokemon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.sda.pokemon.domain.AbilitiesDomain;
@Repository
public interface AbilitiesRepository extends JpaRepository<AbilitiesDomain, Long> {
}
