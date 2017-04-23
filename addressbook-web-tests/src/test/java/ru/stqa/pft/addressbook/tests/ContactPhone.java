package ru.stqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.tests.TestBase;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by mocius on 2017-04-16.
 */
public class ContactPhone extends TestBase {

  @Test
  public void testContactPhones(){
    app.goTo().homePage();
    ContactData contact = app.contactHelper().all().iterator().next();
    ContactData contactInfoFromEditForm = app.contactHelper().infoFromEditForm(contact);

    assertThat(contact.getAllPhones(), equalTo(mergePhones(contactInfoFromEditForm)));

  }

  private <T> String mergePhones(ContactData contact) {
    return Arrays.asList(contact.getHomePhone(), contact.getMobilePhone(),contact.getWorkPhone()).stream().
            filter((s) -> ! s.equals("")).map(ContactPhone::cleaned)
            .collect(Collectors.joining("\n"));

  }

  public static String cleaned(String phone){
    return phone.replaceAll("\\s", "").replaceAll("[-()]", "");
  }
}
