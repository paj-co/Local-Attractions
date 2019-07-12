package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.entity.Province;

public interface ProvinceRepository extends JpaRepository<Province, Long> {

}
