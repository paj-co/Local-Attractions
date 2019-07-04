package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.coderslab.entity.Offer;

import java.time.LocalDateTime;
import java.util.List;

public interface OfferRepository extends JpaRepository<Offer, Long> {

    List<Offer> findOffersByServiceId(long id);

    @Query("SELECT o FROM Offer o WHERE o.service.id =:serviceId AND o.starts <= :localDateTimeNow AND o.ends >= :localDateTimeNow ORDER BY o.ends DESC")
    List<Offer> findCurrentOfferByServiceId(@Param("serviceId") long serviceId, @Param("localDateTimeNow") LocalDateTime localDateTimeNow);

    @Query("SELECT o FROM Offer o WHERE o.service.id =:serviceId AND o.starts > :localDateTimeNow ORDER BY o.starts DESC ")
    List<Offer> findFutureOfferByServiceId(@Param("serviceId") long serviceId, @Param("localDateTimeNow") LocalDateTime localDateTimeNow );

    @Query("SELECT o FROM Offer o WHERE o.service.id =:serviceId AND  o.ends < :localDateTimeNow ORDER BY o.ends DESC ")
    List<Offer> findPastOfferByServiceId(@Param("serviceId") long serviceId, @Param("localDateTimeNow") LocalDateTime localDateTimeNow);

}
