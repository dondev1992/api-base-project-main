package io.catalyte.training.paymentprocessor.domains.payment;

import java.math.BigDecimal;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class Payment {

  @NotBlank(message = "Credit card number is required.")
  private String creditCardNumber;

  @NotNull(message = "Expiration month is required.")
  private int expirationMonth;

  @NotNull(message = "Expiration year is required.")
  private int expirationYear;

  @NotNull(message = "Security code is required.")
  private int securityCode;

  @NotNull(message = "Charge amount is required.")
  private BigDecimal chargeAmount;

  private String correlationGuid;

  public Payment(
      @NotBlank String creditCardNumber,
      @Positive @NotNull int expirationMonth,
      @Positive @NotNull int expirationYear,
      @Positive @NotNull int securityCode,
      @NotNull BigDecimal chargeAmount) {
    this.creditCardNumber = creditCardNumber;
    this.expirationMonth = expirationMonth;
    this.expirationYear = expirationYear;
    this.securityCode = securityCode;
    this.chargeAmount = chargeAmount;
  }

  public Payment() {
  }

  public String getCreditCardNumber() {
    return creditCardNumber;
  }

  public void setCreditCardNumber(String creditCardNumber) {
    this.creditCardNumber = creditCardNumber;
  }

  public int getExpirationMonth() {
    return expirationMonth;
  }

  public void setExpirationMonth(int expirationMonth) {
    this.expirationMonth = expirationMonth;
  }

  public int getExpirationYear() {
    return expirationYear;
  }

  public void setExpirationYear(int expirationYear) {
    this.expirationYear = expirationYear;
  }

  public int getSecurityCode() {
    return securityCode;
  }

  public void setSecurityCode(int securityCode) {
    this.securityCode = securityCode;
  }

  public BigDecimal getChargeAmount() {
    return chargeAmount;
  }

  public void setChargeAmount(BigDecimal chargeAmount) {
    this.chargeAmount = chargeAmount;
  }

  public String getCorrelationGuid() {
    return correlationGuid;
  }

  public void setCorrelationGuid(String correlationGuid) {
    this.correlationGuid = correlationGuid;
  }
}
