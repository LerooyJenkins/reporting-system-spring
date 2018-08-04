package com.ceepdode.reportingsystem.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.sql.Timestamp;
import java.time.Instant;

@Converter(autoApply = true)
public class InstantConverter implements AttributeConverter<Instant, Timestamp> {

    @Override
    public Timestamp convertToDatabaseColumn(Instant instant) {
        if (instant != null) {
            return Timestamp.from(instant);
        } else {
            return null;
        }
    }

    @Override
    public Instant convertToEntityAttribute(Timestamp timestamp) {
        if (timestamp != null) {
            return timestamp.toInstant();
        } else {
            return null;
        }

    }

}
