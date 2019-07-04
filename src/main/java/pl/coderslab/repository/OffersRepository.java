package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.entity.Offer;

import java.util.List;

public interface OffersRepository extends JpaRepository<Offer, Long> {

    List<Offer> findOffersByServiceId(long id);

}
