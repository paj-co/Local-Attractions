package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.coderslab.entity.Category;

import java.util.List;


public interface CategoryRepository extends JpaRepository<Category, Long> {

    @Query("SELECT c FROM Category c JOIN c.services service WHERE service.id = :serviceId ORDER BY c.name ASC")
    List<Category> findCategoriesByServiceId(@Param("serviceId") long serviceId);

    List<Category> findCategoriesByOrderByNameAsc();

}
