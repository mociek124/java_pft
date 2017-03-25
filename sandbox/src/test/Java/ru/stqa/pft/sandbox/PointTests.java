package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by mocius on 2017-03-25.
 */
public class PointTests {
  @Test
  public void TestArea(){

    Point p = new Point(3,3,4,4);
Assert.assertEquals(p.distance(), 0.0);
  }



}
