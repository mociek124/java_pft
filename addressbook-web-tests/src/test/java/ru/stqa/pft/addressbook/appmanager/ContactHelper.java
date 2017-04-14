package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.ArrayList;
import java.util.List;

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

  public void initContactModification() { click(By.cssSelector("img[alt='Edit]"));}
  public void submitContactModification(){
    click(By.name("update"));
  }

  public void createContact(ContactData contact) {
    initContactCreation();
    fillContactForm(contact,true);
    submitContactCreation();
    returnToHomePage();
  }

  public boolean isThereAGroup() {
    return isElementPresent(By.name("new_group"));
  }

  public int getContactCount() {
    return wd.findElements(By.name("new_group")).size();
  }

  public List<ContactData> getContactList() {
    List<ContactData> contacts = new ArrayList<ContactData>();
    List<WebElement> elements = wd.findElements(By.cssSelector("span.contact"));
    for (WebElement element : elements){
      String name = element.getText();
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      ContactData contact = new ContactData(id, "test_name", "test_surname", "test1");
      contacts.add(contact);
    }
    return contacts;
  }
}
