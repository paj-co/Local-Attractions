package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.entity.Commune;

public interface CommuneRepository extends JpaRepository<Commune, Long> {
}
