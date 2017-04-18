package ru.stqa.pft.addressbook.model;

/**
 * Created by mocius on 2017-04-02.
 */
public class ContactData {

  private int id = Integer.MAX_VALUE;
  private  String firstname;
  private  String secondname;
  private String group;
  private String homePhone;
  private String mobilePhone;
  private String workPhone;

  public String getWorkPhone() {return workPhone;}

  public ContactData withWorkPhone (String workPhone){
    this.workPhone = workPhone;
    return this;
  }

  public String getMobilePhone() {return mobilePhone;}

  public ContactData withMobilePhone(String mobilePhone){
    this.mobilePhone = mobilePhone;
    return this;
  }

  public String getHomePhone(){return homePhone;}

  public ContactData withHomePhone(String homePhone){
    this.homePhone = homePhone;
    return this;
  }


  public int getId() {
    return id;
  }

  public ContactData withId(int id) {
    this.id = id;
    return this;
  }



  public ContactData withFirstname(String firstname) {
    this.firstname = firstname;
    return this;
  }

  public ContactData withSecondname(String secondname) {
    this.secondname = secondname;
    return this;
  }

  public ContactData withGroup(String group) {
    this.group = group;
    return this;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    ContactData that = (ContactData) o;

    if (id != that.id) return false;
    return firstname != null ? firstname.equals(that.firstname) : that.firstname == null;
  }

  @Override
  public int hashCode() {
    int result = id;
    result = 31 * result + (firstname != null ? firstname.hashCode() : 0);
    return result;
  }

  public String getFirstName() { return firstname;}

  public String getLastName() { return secondname;}

  public String getGroup(){
    return group;
  }


}
