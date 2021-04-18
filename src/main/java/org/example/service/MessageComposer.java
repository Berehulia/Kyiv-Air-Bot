package org.example.service;

import io.micronaut.http.client.multipart.MultipartBody;
import org.example.dto.lun.LunAir;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public interface MessageComposer {

  MultipartBody composeBody(@NotNull @Valid LunAir air);

}
