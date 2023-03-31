package io.catalyte.training.paymentprocessor.domains.payment;

import io.catalyte.training.paymentprocessor.domains.payment.validation.ExpirationValidator;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {

  // https://stackoverflow.com/a/23231321
  public static final String CC_REGEX = "^(?:4[0-9]{12}(?:[0-9]{3})?|5[1-5][0-9]{14})$";
  private Logger logger = LogManager.getLogger(PaymentService.class);
  private ExpirationValidator expirationValidator;

  @Autowired
  public PaymentServiceImpl(
      ExpirationValidator expirationValidator) {
    this.expirationValidator = expirationValidator;
  }

  @Override
  public PaymentVerification verifyPayment(Payment payment) {
    List<String> errorList;

    errorList = expirationValidator.isValid(payment);
    boolean validCC = payment.getCreditCardNumber().matches(CC_REGEX);

    if (!validCC) {
      errorList.add("Non-visa / mastercard number provided.");
    }

    if (errorList.size() > 0) {
      logger.info("Declined payment with correlationGuid: " + payment.getCorrelationGuid());
      for (String error : errorList) {
        logger.info("correlationGuid: " + payment.getCorrelationGuid() + " error: " + error);
      }
      return new PaymentVerification("Declined", errorList, null, payment.getCorrelationGuid());
    } else {
      // We randomly decline an otherwise successful payment to simulate insufficient funds or other banking problems.
      int randomInt = (int) (10.0 * Math.random());
      if (randomInt >= 9) {
        errorList.add("Transaction declined by bank");
        logger.info("correlationGuid: " + payment.getCorrelationGuid()
            + " error: Transaction declined by bank.");
        return new PaymentVerification("Declined", errorList, LocalDate.now(),
            payment.getCorrelationGuid());
      }
      logger.info("correlationGuid: " + payment.getCorrelationGuid() + ". Successful payment");
      return new PaymentVerification("Success", new ArrayList<>(), LocalDate.now(),
          payment.getCorrelationGuid());
    }

  }
}