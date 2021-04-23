package org.example.service;

import io.micronaut.core.annotation.Introspected;
import org.example.dto.lun.LunAir;
import org.example.dto.telegram.TelegramResponse;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Introspected
public interface TelegramService {

  TelegramResponse sendAirData(@NotNull @Valid LunAir air);

}
