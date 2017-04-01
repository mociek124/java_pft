package ru.stqa.pft.sandbox;

/**
 * Created by mocius on 2017-04-01.
 */
public class Equality {

  public static void main(String[]args){
    String s1 = "firefox";
    String s2 = s1;

    System.out.println(s1==s2);
    System.out.println(s1.equals(s2));
  }
}
