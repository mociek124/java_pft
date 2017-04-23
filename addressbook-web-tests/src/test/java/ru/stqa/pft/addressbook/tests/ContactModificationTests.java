package ru.stqa.pft.addressbook.tests;

import org.junit.Test;

import org.testng.annotations.BeforeMethod;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

/**
 * Created by mocius on 2017-04-02.
 */
public class ContactModificationTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions(){
    app.goTo().homePage();
    if (! app.contactHelper().isThereAGroup()){
      app.contactHelper().createContact(new ContactData().withFirstname("test_name"));

    }
  }

  @Test
  public void testContactModification(){

    Contacts before = app.contactHelper().all();
    int index = before.size()-1;
    ContactData contact = new ContactData()
            .withFirstname("test_name").withLastname("test_surname").withGroup("test1") ;
    ContactData modifiedContact = before.iterator().next();
    app.contactHelper().modify(contact);
    Contacts after = app.contactHelper().all();
    assertEquals(after.size(), before.size() );
    assertThat(after, equalTo(before.without(modifiedContact).withAdded(contact)));

  }


}
