package org.example;

import io.micronaut.function.aws.MicronautRequestHandler;
import lombok.extern.slf4j.Slf4j;
import org.example.dto.lun.LunAir;
import org.example.dto.lun.LunResponse;
import org.example.dto.telegram.TelegramResponse;
import org.example.service.LunService;
import org.example.service.TelegramService;

import javax.inject.Inject;

@Slf4j
public class KyivAirHandler extends MicronautRequestHandler<Object, Object> {

  @Inject
  private LunService lunService;

  @Inject
  private TelegramService telegramService;

  @Override
  public Object execute(Object input) {
    LunResponse lunResponse = lunService.receiveAirData();
    log.info("Received response from Lun: {}", lunResponse);
    LunAir lunAir = lunResponse.getAir();
    log.info("Sent air data to Telegram: {}", lunAir);
    TelegramResponse telegramResponse = telegramService.sendAirData(lunAir);
    log.info("Received response from Telegram: {}", telegramResponse);
    return telegramResponse;
  }

}
