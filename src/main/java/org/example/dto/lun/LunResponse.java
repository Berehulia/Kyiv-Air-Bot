package org.example.dto.lun;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.core.annotation.Introspected;
import lombok.Getter;
import lombok.ToString;

import javax.validation.constraints.NotNull;

@Getter
@ToString
@Introspected
public class LunResponse {

  @NotNull
  @JsonProperty("lunmisto_air")
  private LunAir air;

}
