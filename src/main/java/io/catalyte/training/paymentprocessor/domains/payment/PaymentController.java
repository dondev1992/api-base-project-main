package io.catalyte.training.paymentprocessor.domains.payment;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/payments")
public class PaymentController {

  @Autowired
  private PaymentService paymentService;

  @PostMapping
  public ResponseEntity<PaymentVerification> verifyPaymentDetails(
      @Valid @RequestBody Payment payment) {
    return new ResponseEntity<>(paymentService.verifyPayment(payment), HttpStatus.OK);
  }

}
