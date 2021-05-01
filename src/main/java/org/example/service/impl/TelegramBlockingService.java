package org.example.service.impl;

import io.micronaut.context.annotation.Value;
import io.micronaut.core.annotation.Introspected;
import io.micronaut.http.client.multipart.MultipartBody;
import lombok.extern.slf4j.Slf4j;
import org.example.client.TelegramBlockingClient;
import org.example.dto.lun.LunAir;
import org.example.dto.telegram.TelegramResponse;
import org.example.service.TelegramService;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import static org.example.util.JsonConverter.toJson;

@Slf4j
@Singleton
@Introspected
public class TelegramBlockingService implements TelegramService {

  @Inject
  private LunMessageComposer composer;

  @Inject
  private TelegramBlockingClient client;

  @Value("${telegram.client.token}")
  private String token;

  @Value("${telegram.client.chat}")
  private String chat;

  @Override
  public TelegramResponse sendAirData(@NotNull @Valid LunAir air) {
    MultipartBody body = composer.composeBody(air);
    TelegramResponse telegramResponse = client.sendMessage(token, chat, body);
    log.info("Received response from Telegram: {}", toJson(telegramResponse));
    return telegramResponse;
  }

}
