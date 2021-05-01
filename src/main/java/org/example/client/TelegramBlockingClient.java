package org.example.client;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.PathVariable;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.http.client.multipart.MultipartBody;
import io.micronaut.validation.Validated;
import org.example.dto.telegram.TelegramResponse;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import static io.micronaut.http.MediaType.MULTIPART_FORM_DATA;

@Validated
@Introspected
@Client("${telegram.client.host}")
public interface TelegramBlockingClient {

  @Post(value = "${telegram.client.endpoint}", produces = MULTIPART_FORM_DATA)
  TelegramResponse sendMessage(
      @NotBlank @PathVariable String token,
      @NotBlank @PathVariable String id,
      @NotNull @Body MultipartBody body
  );

}
