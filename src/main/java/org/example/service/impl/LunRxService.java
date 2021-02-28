package org.example.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.example.client.LunRxClient;
import org.example.dto.lun.LunResponse;
import org.example.service.LunService;

import javax.inject.Inject;
import javax.inject.Singleton;

@Slf4j
@Singleton
public class LunRxService implements LunService {

  @Inject
  private LunRxClient client;

  @Override
  public LunResponse receiveAirData() {
    LunResponse response = client.receiveData().blockingGet();
    log.info("Received response of Lun API: " + response);
    return response;
  }

}
