package pl.coderslab.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.entity.Category;
import pl.coderslab.repository.CategoryRepository;

import java.util.Optional;

public class CategoryConverter implements Converter<String, Category> {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Category convert(String id) {
        Optional<Category> category = categoryRepository.findById(Long.parseLong(id));
        if(category.isPresent()) {
            return category.get();
        }
        return null;
    }
}
