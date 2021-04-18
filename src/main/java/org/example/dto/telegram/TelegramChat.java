package org.example.dto.telegram;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.core.annotation.Introspected;
import lombok.Getter;
import lombok.ToString;

import javax.validation.constraints.NotNull;

@Getter
@ToString
@Introspected
public class TelegramChat {

  @NotNull
  @JsonProperty("id")
  private String id;

  @NotNull
  @JsonProperty("title")
  private String title;

  @NotNull
  @JsonProperty("type")
  private String type;

}
