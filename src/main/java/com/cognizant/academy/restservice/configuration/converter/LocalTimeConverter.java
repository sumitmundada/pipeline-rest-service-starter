package com.cognizant.academy.restservice.configuration.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Optional;

@Converter(autoApply = true)
public class LocalTimeConverter implements AttributeConverter<LocalTime, Timestamp> {

    @Override
    public Timestamp convertToDatabaseColumn(LocalTime localTime) {
        LocalDateTime localDateTime = LocalDateTime.of(LocalDate.MIN, localTime);
        return Optional.ofNullable(localDateTime)
                .map(Timestamp::valueOf)
                .orElse(null);
    }

    @Override
    public LocalTime convertToEntityAttribute(Timestamp timestamp) {
        return Optional.ofNullable(timestamp)
                .map(Timestamp::toLocalDateTime)
                .orElse(null).toLocalTime();
    }

}
