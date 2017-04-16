package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import static ru.stqa.pft.addressbook.tests.TestBase.app;

/**
 * Created by mocius on 2017-04-16.
 */
public class ContactPhone extends TestBase {

  @Test
  public void testContactPhones(){
    app.goTo().gotoHomePage();
    ContactData contact = app.contact().all().iterator().next();
    ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
  }
}
