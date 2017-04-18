package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
  public void modify(ContactData contact) {
    fillContactForm(contact, false);
    initContactModification();
    submitContactModification();
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
    List<WebElement> rows = wd.findElements(By.cssSelector("span.contact"));
    for (WebElement row : rows){
      String name = row.getText();
      int id = Integer.parseInt(row.findElement(By.tagName("input")).getAttribute("value"));
      contacts.add( new ContactData().withId(id).withFirstname("test_name").withSecondname( "test_surname"));
    }
    return contacts;
  }

  public Contacts all() {
    Contacts contacts = new Contacts();
    List<WebElement> elements = wd.findElements(By.cssSelector("span.contact"));
    for (WebElement element : elements){
      String name = element.getText();
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      contacts.add( new ContactData().withId(id).withFirstname("test_name").withSecondname( "test_surname"));
    }
    return contacts;
  }






  public ContactData infoFromEditForm(ContactData contact){
    initContactModificationById(contact.getId());
    String firstname = wd.findElement(By.name("firstmane")).getAttribute("value");
    String secondname = wd.findElement(By.name("secondname")).getAttribute("value");
    String home = wd.findElement(By.name("home")).getAttribute("value");
    String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
    String work = wd.findElement(By.name("work")).getAttribute("value");
    wd.navigate().back();
    return new ContactData().withId(contact.getId()).withFirstname(firstname)
            .withSecondname(secondname).withHomePhone(home).withMobilePhone(mobile)
            .withWorkPhone(work);
  }
  private void initContactModificationById(int id){
    WebElement checkbox = wd.findElement(By.cssSelector(String.format("input[value='%s']", id)));
    WebElement row = checkbox.findElement(By.xpath("./../.."));
    List<WebElement> cells = row.findElements(By.tagName("td"));
    cells.get(7).findElement(By.tagName("a")).click();

 //   wd.findElement(By.xpath(String.format("//input[@value='%s']/../../td[8]/a", id))).click();
 //   wd.findElement(By.xpath(String.format("//tr[.//input[@value='%s]]/td[8]/a", id))).click();
 //   wd.findElement(By.cssSelector(String.format("a [href='edit.php?id=%s']", id))).click();
  }
}
