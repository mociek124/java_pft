package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.pft.addressbook.model.GroupData;

/**
 * Created by mocius on 2017-03-26.
 */
public class GroupHelper extends HelperBase {

  public GroupHelper(WebDriver wd) {

    super(wd);
  }

  public void returnToGroupPage() {
    submitGroupCreation(By.linkText("group page"));
  }

  public void submitGroupCreation(By click) {
    click(click);
  }

  public void fillGroupForm(GroupData groupData) {

    type(By.name("group_name"), groupData.getName());
    type(By.name("group_header"), groupData.getHeader());
    type(By.name("group_header"), groupData.getFooter());
  }

  public void initGroupCreation() {
    submitGroupCreation(By.name("new"));
  }

  public void deleteSelectedGroups() {
    submitGroupCreation(By.name("delete"));
  }

  public void selectGroup() {
    submitGroupCreation(By.name("selected[]"));
  }


  public void initGroupModification() {
    click(By.name("edit"));
  }

  public void submitGroupModification() {
    click(By.name("update"));
  }

  public void createGroup(GroupData group) {
   initGroupCreation();
    fillGroupForm(group);
    submitGroupCreation(By.name("submit"));
    returnToGroupPage();
  }
  public boolean isThereAGroup(){
    return isElementPresent(By.name("selected[]"));
  }
}
