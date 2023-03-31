package io.catalyte.training.paymentprocessor.config;

import io.catalyte.training.paymentprocessor.domains.payment.validation.ExpirationValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfigurations {

  @Bean
  public ExpirationValidator expirationValidator() {
    return new ExpirationValidator();
  }

}
