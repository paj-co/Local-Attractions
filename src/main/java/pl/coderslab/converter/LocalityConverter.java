package pl.coderslab.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.entity.Locality;
import pl.coderslab.repository.LocalityRepository;

public class LocalityConverter implements Converter<String, Locality> {

    @Autowired
    private LocalityRepository localityRepository;

    @Override
    public Locality convert(String id) {
        return localityRepository.findById(Long.parseLong(id)).orElse(null);
    }
}
