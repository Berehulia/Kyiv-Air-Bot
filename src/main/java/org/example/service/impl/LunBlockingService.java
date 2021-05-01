package org.example.service.impl;

import io.micronaut.core.annotation.Introspected;
import lombok.extern.slf4j.Slf4j;
import org.example.client.LunBlockingClient;
import org.example.dto.lun.LunResponse;
import org.example.service.LunService;

import javax.inject.Inject;
import javax.inject.Singleton;

import static org.example.util.JsonConverter.toJson;

@Slf4j
@Singleton
@Introspected
public class LunBlockingService implements LunService {

  @Inject
  private LunBlockingClient client;

  @Override
  public LunResponse receiveAirData() {
    LunResponse lunResponse = client.receiveData();
    log.info("Received response from Lun: {}", toJson(lunResponse));
    return lunResponse;
  }

}
