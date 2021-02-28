package org.example.service;

import io.micronaut.http.client.multipart.MultipartBody;
import org.example.dto.lun.LunAir;

import javax.validation.Valid;

public interface MessageComposer {

  MultipartBody composeBody(@Valid LunAir air);

}
