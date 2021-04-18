package org.example.service.impl;

import io.micronaut.context.annotation.Value;
import io.micronaut.http.client.multipart.MultipartBody;
import lombok.extern.slf4j.Slf4j;
import org.example.client.TelegramClient;
import org.example.dto.lun.LunAir;
import org.example.dto.telegram.TelegramResponse;
import org.example.service.TelegramService;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Slf4j
@Singleton
public class TelegramHttpService implements TelegramService {

  @Inject
  private LunComposer composer;

  @Inject
  private TelegramClient client;

  @Value("${telegram.client.token}")
  private String token;

  @Value("${telegram.client.chat}")
  private String id;

  @Override
  public TelegramResponse sendAirData(@NotNull @Valid LunAir air) {
    MultipartBody body = composer.composeBody(air);
    return client.sendMessage(token, id, body);
  }

}
