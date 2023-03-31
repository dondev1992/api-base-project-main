package io.catalyte.training.paymentprocessor.exceptions;

public class ServiceUnavailable extends RuntimeException {

  public ServiceUnavailable() {
  }

  public ServiceUnavailable(String message) {
    super(message);
  }
}
