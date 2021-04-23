package org.example.service.impl;

import io.micronaut.core.annotation.Introspected;
import org.example.client.LunClient;
import org.example.dto.lun.LunResponse;
import org.example.service.LunService;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
@Introspected
public class LunHttpService implements LunService {

  @Inject
  private LunClient client;

  @Override
  public LunResponse receiveAirData() {
    return client.receiveData();
  }

}
