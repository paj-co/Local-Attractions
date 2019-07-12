package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.entity.District;

public interface DistrictRepository extends JpaRepository<District, Long> {
}
