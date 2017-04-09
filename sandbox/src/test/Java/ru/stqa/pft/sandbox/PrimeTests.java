package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by mocius on 2017-04-09.
 */
public class PrimeTests {

  @Test
  public void testPrime(){
    Assert.assertTrue(Primes.isPrime(Integer.MAX_VALUE));
  }

  @Test
  public void testNonPrimes(){
    Assert.assertFalse(Primes.isPrime(Integer.MAX_VALUE - 2));
  }
}
