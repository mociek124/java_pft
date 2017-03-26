package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by mocius on 2017-03-26.
 */
public class SessionHelper extends HelperBase{


  public SessionHelper(FirefoxDriver wd){
    super(wd);
  }
  public void login(String username) {
    type(By.name("user"), username);
    type(By.name("pass"), "\\undefined");
    click(By.xpath("//form[@id='LoginForm']/input[3]"));
  }
}

