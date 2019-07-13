package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.entity.Locality;

import java.util.List;

public interface LocalityRepository extends JpaRepository<Locality, Long> {

    List<Locality> findLocalitiesByOrderByNameAsc();

}
