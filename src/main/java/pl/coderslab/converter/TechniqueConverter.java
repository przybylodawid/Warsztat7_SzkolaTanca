package pl.coderslab.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.model.Technique;
import pl.coderslab.repositories.TechniqueRepository;

public class TechniqueConverter implements Converter<String, Technique> {

    @Autowired
    private TechniqueRepository techniqueRepository;

    @Override
    public Technique convert(String s) {
        return techniqueRepository.findOne(Long.parseLong(s));
    }
}
