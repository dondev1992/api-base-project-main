package io.catalyte.training.paymentprocessor.exceptions;

/*
ServerError Exception class extends RuntimeException for use by ExceptionController
 */
public class ServerError extends RuntimeException {

  public ServerError() {
  }

  public ServerError(String message) {
    super(message);
  }
}
