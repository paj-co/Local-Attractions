package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.entity.NewsFeed;

import java.util.List;

public interface NewsFeedRepository extends JpaRepository<NewsFeed, Long> {

    List<NewsFeed> findNewsFeedByServiceId(long id);

}
