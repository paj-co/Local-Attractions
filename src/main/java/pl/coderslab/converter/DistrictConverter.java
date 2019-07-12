package pl.coderslab.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.entity.District;
import pl.coderslab.repository.DistrictRepository;

public class DistrictConverter implements Converter<String, District> {

    @Autowired
    private DistrictRepository districtRepository;

    @Override
    public District convert(String id) {
        return districtRepository.findById(Long.parseLong(id)).orElse(null);
    }
}
