package io.catalyte.training.paymentprocessor.domains.payment;

public interface PaymentService {

  PaymentVerification verifyPayment(Payment payment);
}
