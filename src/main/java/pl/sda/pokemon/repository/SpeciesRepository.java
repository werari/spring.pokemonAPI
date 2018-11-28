package pl.sda.pokemon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.sda.pokemon.domain.SpeciesDomain;

@Repository
public interface SpeciesRepository extends JpaRepository<SpeciesDomain, Long>
{
}
