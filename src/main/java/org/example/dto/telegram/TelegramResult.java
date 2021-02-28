package org.example.dto.telegram;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.micronaut.core.annotation.Introspected;
import lombok.ToString;
import org.example.util.UnixTimestampDeserializer;

import javax.validation.constraints.NotNull;
import java.util.Date;

@ToString
@Introspected
public class TelegramResult {

  @NotNull
  @JsonProperty("message_id")
  private int id;

  @NotNull
  @JsonProperty("chat")
  private TelegramChat chat;

  @NotNull
  @JsonProperty("date")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @JsonDeserialize(using = UnixTimestampDeserializer.class)
  private Date timestamp;

}
