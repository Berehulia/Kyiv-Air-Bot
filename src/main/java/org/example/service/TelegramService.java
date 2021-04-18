package org.example.service;

import org.example.dto.lun.LunAir;
import org.example.dto.telegram.TelegramResponse;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public interface TelegramService {

  TelegramResponse sendAirData(@NotNull @Valid LunAir air);

}
