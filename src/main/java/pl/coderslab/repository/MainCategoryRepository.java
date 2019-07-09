package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.entity.MainCategory;

import java.util.List;

public interface MainCategoryRepository extends JpaRepository<MainCategory, Long> {

    List<MainCategory> findMainCategoriesByOrderByNameAsc();

}
