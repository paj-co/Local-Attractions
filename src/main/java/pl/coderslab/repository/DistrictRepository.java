package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.entity.District;

import java.util.List;

public interface DistrictRepository extends JpaRepository<District, Long> {

    List<District> findDistrictsByOrderByNameAsc();

}
