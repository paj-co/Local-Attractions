package pl.coderslab.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.entity.Province;
import pl.coderslab.repository.ProvinceRepository;

public class ProvinceConverter implements Converter<String, Province> {

    @Autowired
    private ProvinceRepository provinceRepository;

    @Override
    public Province convert(String id) {
        return provinceRepository.findById(Long.parseLong(id)).orElse(null);
    }
}
