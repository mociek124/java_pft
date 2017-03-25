package ru.stqa.pft.sandbox;

/**
 * Created by mocius on 2017-03-19.
 */

public class Point {

  public double x1;
  public double x2;
  public double y1;
  public double y2;

  public Point(double x1, double x2, double y1, double y2){
    this.x1 = x1;
    this.x2 = x2;
    this.y1 = y1;
    this.y2 = y2;
  }
  public  double distance(){
    return Math.sqrt((this.x2 -this.x1) * (this.x2 - this.x1) + (this.y2 - this.y1) * (this.y2 - this.y1));

  }



}