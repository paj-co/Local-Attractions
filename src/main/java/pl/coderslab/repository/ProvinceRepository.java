package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.entity.Province;

import java.util.List;

public interface ProvinceRepository extends JpaRepository<Province, Long> {

    List<Province> findProvincesByOrderByNameAsc();

}
