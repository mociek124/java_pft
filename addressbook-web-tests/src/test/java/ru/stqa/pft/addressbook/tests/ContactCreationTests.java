package ru.stqa.pft.addressbook.tests;

import org.junit.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.tests.TestBase;

/**
 * Created by mocius on 2017-04-02.
 */
public class ContactCreationTests extends TestBase {
  @Test
  public void testContactCreation(){
    app.getNavigationHelper().gotoHomePage();
    app.getContactHelper().createContact(new ContactData("test_name", "test_surname", "test1"));

  }


}
