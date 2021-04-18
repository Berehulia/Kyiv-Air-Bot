package org.example.client;

import io.micronaut.http.annotation.Get;
import io.micronaut.http.client.annotation.Client;
import org.example.dto.lun.LunResponse;

@Client("${lun.client.host}")
public interface LunClient {

  @Get("${lun.client.endpoint}")
  LunResponse receiveData();

}