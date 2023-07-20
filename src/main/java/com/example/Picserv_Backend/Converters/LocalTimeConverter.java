package com.example.Picserv_Backend.Converters;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.time.LocalTime;

@Converter(autoApply = true)
public class LocalTimeConverter implements AttributeConverter<LocalTime,String>{

    @Override
    public String convertToDatabaseColumn(LocalTime localTime) {
        return localTime != null ? localTime.toString() : null;
    }

    @Override
    public LocalTime convertToEntityAttribute(String dbData) {
        return dbData != null ? LocalTime.parse(dbData) : null;
    }
}
