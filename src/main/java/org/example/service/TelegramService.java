package org.example.service;

import org.example.dto.lun.LunAir;
import org.example.dto.telegram.TelegramResponse;

import javax.validation.Valid;

public interface TelegramService {

  TelegramResponse sendAirData(@Valid LunAir air);

}
