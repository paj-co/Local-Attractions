package pl.coderslab.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.entity.Business;

public interface BusinessRepository extends JpaRepository<Business, Long> {

    Business findBusinessByEmail(String email);

}
