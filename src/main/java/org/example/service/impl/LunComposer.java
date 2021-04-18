package org.example.service.impl;

import io.micronaut.http.client.multipart.MultipartBody;
import lombok.AllArgsConstructor;
import org.example.dto.lun.LunAir;
import org.example.exception.KyivAirException;
import org.example.service.MessageComposer;

import javax.inject.Singleton;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.io.File;
import java.util.Arrays;
import java.util.Formatter;

@Singleton
public class LunComposer implements MessageComposer {

  public static final String PARAMETER_CAPTION = "caption";
  public static final String PARAMETER_PHOTO = "photo";

  @Override
  public MultipartBody composeBody(@NotNull @Valid LunAir air) {
    String caption = createCaption(air);
    File photo = choosePhoto(air);
    return MultipartBody.builder()
        .addPart(PARAMETER_CAPTION, caption)
        .addPart(PARAMETER_PHOTO, photo)
        .build();
  }

  private String createCaption(LunAir air) {
    StringBuilder builder = new StringBuilder();
    Formatter formatter = new Formatter(builder);
    formatter.format(
        "AQI індекс: %d\n" +
        "Температура: %d℃\n" +
        "Вологість: %d%%",
        air.getIndex(),
        air.getTemperature(),
        air.getHumidity()
    );
    return builder.toString();
  }

  private File choosePhoto(LunAir air) {
    int index = air.getIndex();
    switch (Range.of(index)) {
      case RANGE_0_50: return new File("img/0-range-0-50.jpg");
      case RANGE_50_100: return new File("img/1-range-50-100.jpg");
      case RANGE_100_150: return new File("img/2-range-100-150.jpg");
      case RANGE_150_200: return new File("img/3-range-150-200.jpg");
      case RANGE_200_300: return new File("img/4-range-200-300.jpg");
      case RANGE_300_500: return new File("img/5-range-300-500.jpg");
      default: throw new KyivAirException();
    }
  }

  @AllArgsConstructor
  private enum Range {

    RANGE_0_50(0, 50),
    RANGE_50_100(50, 100),
    RANGE_100_150(100, 150),
    RANGE_150_200(150, 200),
    RANGE_200_300(200, 300),
    RANGE_300_500(300, 500);

    private final int min;
    private final int max;

    public static Range of(int index) {
      return Arrays.stream(Range.values())
          .filter(range -> index >= range.min && index < range.max)
          .findAny()
          .orElseThrow(KyivAirException::new);
    }

  }

}
