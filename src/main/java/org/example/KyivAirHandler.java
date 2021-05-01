package org.example;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.function.aws.MicronautRequestHandler;
import lombok.extern.slf4j.Slf4j;
import org.example.dto.lun.LunAir;
import org.example.service.LunService;
import org.example.service.TelegramService;

import javax.inject.Inject;

@Slf4j
@Introspected
public class KyivAirHandler extends MicronautRequestHandler<Object, Object> {

  @Inject
  private LunService lunService;

  @Inject
  private TelegramService telegramService;

  @Override
  public Object execute(Object input) {
    LunAir lunAir = lunService.receiveAirData().getAir();
    return telegramService.sendAirData(lunAir);
  }

}
