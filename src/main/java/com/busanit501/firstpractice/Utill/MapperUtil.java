package com.busanit501.firstpractice.Utill;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.config.Configuration;

public enum ModelMapperUtil {
    INSTANCE;
    private ModelMapper modelMapper;
    ModelMapperUtil() {
        this.modelMapper = new ModelMapper();
        modelMapper.getConfiguration()
                .setFieldMatchingEnabled(true)
                .setFieldAccessLevel(Configuration.AccessLevel.PRIVATE)
                .setMatchingStrategy(MatchingStrategies.STRICT);
    }
    
    public ModelMapper getModelMapper() {
        return modelMapper;
    }
}
