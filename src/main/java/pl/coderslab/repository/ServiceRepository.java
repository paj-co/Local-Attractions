package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.entity.Service;

import java.util.List;

public interface ServiceRepository extends JpaRepository<Service, Long> {

    List<Service> findServicesByBusinessId(long id);

}
