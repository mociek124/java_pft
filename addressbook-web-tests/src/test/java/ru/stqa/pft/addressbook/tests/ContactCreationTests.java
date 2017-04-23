package ru.stqa.pft.addressbook.tests;

import org.junit.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

/**
 * Created by mocius on 2017-04-02.
 */
public class ContactCreationTests extends TestBase {
  @Test
  public void testContactCreation(){
    app.goTo().homePage();
    Contacts before = app.contactHelper().all();
    File photo = new File("src/test/resources/stru.png");
    ContactData contact = new ContactData().withFirstname("test_name").
            withLastname("test_surname").withPhoto(photo);
    app.contactHelper().createContact(contact);
    Contacts after = app.contactHelper().all();
    assertEquals(after.size(), equalTo(before.size() + 1));
    assertThat(after, equalTo(before.withAdded(contact.withId(after.stream().
            mapToInt((c)->c.getId()).max().getAsInt()))));
  }
 


}
