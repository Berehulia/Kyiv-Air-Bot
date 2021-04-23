package org.example.util;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import io.micronaut.core.annotation.Introspected;

import java.io.IOException;
import java.util.Date;

@Introspected
public class UnixTimestampDeserializer extends JsonDeserializer<Date> {

  @Override
  public Date deserialize(JsonParser parser, DeserializationContext context) throws IOException {
    return new Date(parser.getValueAsLong() * 1000);
  }

}
