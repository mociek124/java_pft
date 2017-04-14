package ru.stqa.pft.addressbook.model;

/**
 * Created by mocius on 2017-04-02.
 */
public class ContactData {

  private int id;
  private final String firstname;
  private final String secondname;
  private String group;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    ContactData that = (ContactData) o;

    return firstname != null ? firstname.equals(that.firstname) : that.firstname == null;
  }

  @Override
  public int hashCode() {
    return firstname != null ? firstname.hashCode() : 0;
  }

  public ContactData(String firstname, String secondname, String group){
    this.id = Integer.MAX_VALUE;
    this.firstname = firstname;
    this.secondname = secondname;
    this.group = group;
  }

  public ContactData(int id, String firstname, String secondname, String group){
    this.id = id;
    this.firstname = firstname;
    this.secondname = secondname;
    this.group = group;
  }

  public String getFirstName() { return firstname;}

  public String getLastName() { return secondname;}

  public String getGroup(){
    return group;
  }

}
