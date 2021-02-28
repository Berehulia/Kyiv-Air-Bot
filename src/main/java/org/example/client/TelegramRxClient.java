package org.example.client;

import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.PathVariable;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.http.client.multipart.MultipartBody;
import io.micronaut.validation.Validated;
import io.reactivex.Single;
import org.example.dto.telegram.TelegramResponse;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import static io.micronaut.http.MediaType.MULTIPART_FORM_DATA;

@Validated
@Client("${telegram.client.host}")
public interface TelegramRxClient {

  @Post(value = "${telegram.client.endpoint}", produces = MULTIPART_FORM_DATA)
  Single<TelegramResponse> sendMessage(
      @NotBlank @PathVariable String token,
      @NotBlank @PathVariable String id,
      @NotNull @Body MultipartBody body
  );

}
