package pl.coderslab.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.entity.Commune;
import pl.coderslab.repository.CommuneRepository;

public class CommuneConverter implements Converter<String, Commune> {

    @Autowired
    private CommuneRepository communeRepository;

    @Override
    public Commune convert(String id) {
        return communeRepository.findById(Long.parseLong(id)).orElse(null);
    }
}
