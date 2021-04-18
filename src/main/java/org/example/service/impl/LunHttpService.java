package org.example.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.example.client.LunClient;
import org.example.dto.lun.LunResponse;
import org.example.service.LunService;

import javax.inject.Inject;
import javax.inject.Singleton;

@Slf4j
@Singleton
public class LunHttpService implements LunService {

  @Inject
  private LunClient client;

  @Override
  public LunResponse receiveAirData() {
    return client.receiveData();
  }

}
