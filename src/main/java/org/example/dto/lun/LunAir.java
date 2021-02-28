package org.example.dto.lun;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.core.annotation.Introspected;
import lombok.Getter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@ToString
@Introspected
public class LunAir {

  @NotNull
  @JsonProperty("aqi_scale_value")
  private int index;

  @NotBlank
  @JsonProperty("aqi_scale_desc")
  private String description;

  @NotNull
  @JsonProperty("humidity")
  private int humidity;

  @NotNull
  @JsonProperty("temperature")
  private int temperature;

  @NotNull
  @JsonProperty("ts")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private Date timestamp;

}
