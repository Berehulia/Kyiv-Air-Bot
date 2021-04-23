package org.example;

import com.amazonaws.services.lambda.runtime.RequestHandler;
import io.micronaut.function.aws.runtime.AbstractMicronautLambdaRuntime;

import java.net.MalformedURLException;

public class KyivAirRuntime extends AbstractMicronautLambdaRuntime<Object, Object, Object, Object> {

  public static void main(String... args) {
    try {
      new KyivAirRuntime().run(args);
    } catch (MalformedURLException exception) {
      exception.printStackTrace();
    }
  }

  @Override
  protected RequestHandler<Object, Object> createRequestHandler(String... args) {
    return new KyivAirHandler();
  }

}
