package org.example.service;

import io.micronaut.core.annotation.Introspected;
import org.example.dto.lun.LunResponse;

@Introspected
public interface LunService {

  LunResponse receiveAirData();

}
