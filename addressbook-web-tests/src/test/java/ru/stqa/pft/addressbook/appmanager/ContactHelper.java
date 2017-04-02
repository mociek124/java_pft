package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;

/**
 * Created by mocius on 2017-04-02.
 */
public class ContactHelper extends HelperBase {
  public ContactHelper(WebDriver wd){super (wd);}

  public void initContactCreation() {click(By.linkText("add new"));}

  public void fillContactForm(ContactData contactData, boolean creation){
    type(By.name("firstname"), contactData.getFirstName());
    type(By.name("lastname"), contactData.getLastName());

    if (creation){
      new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
    } else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }

  }

  public void submitContactCreation() { click(By.name("submit"));}

  public void returnToHomePage() { click(By.linkText("home page"));}

  public void initContactModification() { click(By.cssSelector("img[alt='Edit]");}
  public void submitContactModification(){
    click(By.name("update"));
  }

}
