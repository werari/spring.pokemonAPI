package pl.sda.pokemon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.sda.pokemon.domain.AbilityDomain;
@Repository
public interface AbilityRepository extends JpaRepository<AbilityDomain, Long> {
}
