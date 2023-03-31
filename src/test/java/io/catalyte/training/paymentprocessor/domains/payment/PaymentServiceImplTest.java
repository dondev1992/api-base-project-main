//package io.catalyte.training.paymentprocessor.domains.payment;
//
//import static io.catalyte.training.paymentprocessor.domains.payment.Demographic.Women;
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertNotNull;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.when;
//
//import io.catalyte.training.paymentprocessor.exceptions.ServiceUnavailable;
//import java.math.BigDecimal;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.Mock;
//import org.mockito.junit.MockitoJUnitRunner;
//import org.springframework.dao.DataAccessException;
//import org.springframework.data.domain.Example;
//
//@RunWith(MockitoJUnitRunner.class)
//public class PaymentServiceImplTest {
//
//  @Mock
//  ProductRepository mockProductRepository;
//
//  PaymentServiceImpl productService;
//
//  @Before
//  public void before() {
//    productService = new PaymentServiceImpl(mockProductRepository);
//  }
//
//  @After
//  public void after() {
//    mockProductRepository.deleteAll();
//  }
//
//  @Test
//  public void getProductsTest() {
//    List<Payment> payments = new ArrayList<>();
//    Payment payment = new Payment(BigDecimal.ONE, "a", "a", Women, "a", "a", "a");
//    payment.setId(1L);
//    payments.add(payment);
//    when(mockProductRepository.findAll(Example.of(payment))).thenReturn(payments);
//    List<Payment> productsTest = productService.getProducts(payment);
//    assertEquals(payments, productsTest);
//  }
//
//  @Test
//  public void getProductByIdTest() {
//    Long id = 1L;
//    when(mockProductRepository.findById(id)).thenReturn(Optional.of(new Payment()));
//    Payment paymentTest = productService.getProductById(id);
//    assertNotNull(productService);
//  }
//
//  @Test(expected = Status404.class)
//  public void getProductByIdThrowsExceptionTest() {
//    Long id = 1L;
//    Optional<Payment> product = mockProductRepository.findById(id);
//    when(mockProductRepository.findById(id)).thenReturn(product);
//    Payment paymentTest = productService.getProductById(id);
//  }
//
//  @Test(expected = ServiceUnavailable.class)
//  public void getProductsTestDAE() {
//    Payment payment = new Payment();
//    when(mockProductRepository.findAll(Example.of(payment)))
//        .thenThrow(new DataAccessException("...") {
//        });
//    productService.getProducts(payment);
//  }
//
//  @Test(expected = ServiceUnavailable.class)
//  public void getProductsByIdTestDAE() {
//    when(mockProductRepository.findById(any(Long.class))).thenThrow(new DataAccessException("...") {
//    });
//    productService.getProductById(1L);
//  }
//}