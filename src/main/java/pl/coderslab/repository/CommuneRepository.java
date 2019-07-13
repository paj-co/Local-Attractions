package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.entity.Commune;

import java.util.List;

public interface CommuneRepository extends JpaRepository<Commune, Long> {

    List<Commune> findCommunesByOrderByNameAsc();
}
