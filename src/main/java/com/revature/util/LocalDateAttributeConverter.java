package com.revature.util;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply=true)
public class LocalDateAttributeConverter implements AttributeConverter<LocalDateTime, Timestamp> {

	  @Override
	  public Timestamp convertToDatabaseColumn(LocalDateTime localDate) {
	    return localDate == null ? null : Timestamp.valueOf(localDate);
	  }

	  @Override
	  public LocalDateTime convertToEntityAttribute(Timestamp sqlDate) {
	    return sqlDate == null ? null : sqlDate.toLocalDateTime();
	  }

}
