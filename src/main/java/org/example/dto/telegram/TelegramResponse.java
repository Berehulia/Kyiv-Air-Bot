package org.example.dto.telegram;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.core.annotation.Introspected;
import lombok.Getter;
import lombok.ToString;

import javax.validation.constraints.NotNull;

@Getter
@ToString
@Introspected
public class TelegramResponse {

  @NotNull
  @JsonProperty("ok")
  private boolean ok;

  @NotNull
  @JsonProperty("result")
  private TelegramResult result;

}
