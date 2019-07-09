package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.coderslab.entity.NewsFeed;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface NewsFeedRepository extends JpaRepository<NewsFeed, Long> {

    List<NewsFeed> findNewsFeedByServiceId(long id);

    @Query("SELECT nf FROM NewsFeed nf WHERE nf.service.id =:serviceId AND nf.starts <= :localDateNow AND nf.ends >= :localDateNow ORDER BY nf.ends DESC")
    List<NewsFeed> findCurrentNewsFeedByServiceId(@Param("serviceId") long serviceId, @Param("localDateNow") LocalDate localDateNow);

    @Query("SELECT nf FROM NewsFeed nf WHERE nf.service.id =:serviceId AND nf.starts > :localDateNow ORDER BY nf.starts DESC ")
    List<NewsFeed> findFutureNewsFeedByServiceId(@Param("serviceId") long serviceId, @Param("localDateNow") LocalDate localDateNow );

    @Query("SELECT nf FROM NewsFeed nf WHERE nf.service.id =:serviceId AND  nf.ends < :localDateNow ORDER BY nf.ends DESC ")
    List<NewsFeed> findPastNewsFeedByServiceId(@Param("serviceId") long serviceId, @Param("localDateNow") LocalDate localDateNow);

}
