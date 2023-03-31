package io.catalyte.training.paymentprocessor.domains.payment.validation;

import io.catalyte.training.paymentprocessor.domains.payment.Payment;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class ExpirationValidator {


  public static final String INVALID_EXP_DATE = "The transaction details were invalid, check expiration.";


  public List<String> isValid(Payment payment) {
    int providedExpirationMonth = payment.getExpirationMonth();
    int providedExpirationYear = payment.getExpirationYear();
    List<String> errorList = new ArrayList<>();

    errorList.addAll(validateExpiration(providedExpirationMonth, providedExpirationYear));

    return errorList;
  }

  public List<String> validateExpiration(int providedExpirationMonth, int providedExpirationYear) {
    int currentYear = Calendar.getInstance().get(Calendar.YEAR);
    int currentMonth = Calendar.getInstance().get(Calendar.MONTH);

    if (providedExpirationMonth < 1
        || providedExpirationMonth > 12
        || providedExpirationYear < currentYear
        || providedExpirationYear == currentYear && providedExpirationMonth < currentMonth) {

      List<String> errorList = new ArrayList<>();
      errorList.add(INVALID_EXP_DATE);

      return errorList;
    } else {
      return new ArrayList<>();
    }
  }
}
