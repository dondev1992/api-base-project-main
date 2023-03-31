package io.catalyte.training.paymentprocessor.domains.payment;

import java.time.LocalDate;
import java.util.List;

public class PaymentVerification {

  private String status;
  private List<String> errors;
  private LocalDate processDate;
  private String correlationGuid;

  public PaymentVerification(String status, List<String> errors, LocalDate processDate, String correlationGuid) {
    this.status = status;
    this.errors = errors;
    this.processDate = processDate;
    this.correlationGuid = correlationGuid;
  }

  public PaymentVerification() {
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public List<String> getErrors() {
    return errors;
  }

  public void setErrors(List<String> errors) {
    this.errors = errors;
  }

  public LocalDate getProcessDate() {
    return processDate;
  }

  public void setProcessDate(LocalDate processDate) {
    this.processDate = processDate;
  }

  public String getCorrelationGuid() {
    return correlationGuid;
  }

  public void setCorrelationGuid(String correlationGuid) {
    this.correlationGuid = correlationGuid;
  }
}
