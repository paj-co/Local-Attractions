package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.entity.Locality;

public interface LocalityRepository extends JpaRepository<Locality, Long> {

}
