package ru.stqa.pft.addressbook.tests;

import org.junit.Test;
import ru.stqa.pft.addressbook.model.ContactData;

/**
 * Created by mocius on 2017-04-02.
 */
public class ContactModificationTests extends TestBase {

  @Test
  public void testContactModification(){
    app.getNavigationHelper().gotoHomePage();
    if (! app.getContactHelper().isThereAGroup()){
      app.getContactHelper().createContact(new ContactData("test_name", "test_surname", "test1"));

    }
    app.getContactHelper().initContactModification();
    app.getContactHelper().fillContactForm(new ContactData("test_name", "test_surname", null), false);
    app.getContactHelper().submitContactModification();
    app.getContactHelper().returnToHomePage();
  }
}
