package org.example.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.micronaut.core.annotation.Introspected;
import org.example.exception.KyivAirException;

import javax.inject.Singleton;

@Singleton
@Introspected
public class JsonConverter {

  private static final ObjectMapper mapper = new ObjectMapper();

  public static String toJson(Object object) {
    try {
      return mapper.writeValueAsString(object);
    } catch (JsonProcessingException exception) {
      throw new KyivAirException(exception);
    }
  }

}
