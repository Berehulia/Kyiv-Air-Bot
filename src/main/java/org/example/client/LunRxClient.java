package org.example.client;

import io.micronaut.http.annotation.Get;
import io.micronaut.http.client.annotation.Client;
import io.reactivex.Single;
import org.example.dto.lun.LunResponse;

@Client("${lun.client.host}")
public interface LunRxClient {

  @Get("${lun.client.endpoint}")
  Single<LunResponse> receiveData();

}
