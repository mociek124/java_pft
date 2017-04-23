package ru.stqa.pft.addressbook.model;

import java.io.File;

/**
 * Created by mocius on 2017-04-02.
 */
public class ContactData {

  private int id = Integer.MAX_VALUE;
  private  String firstname;
  private  String lastname;
  private String group;
  private String homePhone;
  private String mobilePhone;
  private String workPhone;
  private File photo;

  public File getPhoto() {
    return photo;
  }

  public ContactData withPhoto(File photo) {
    this.photo = photo;
    return this;
  }

  public String getAllPhones() {
    return allPhones;
  }

  public ContactData withAllPhones(String allPhones) {
    this.allPhones = allPhones;
    return this;
  }

  private String allPhones;

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

  public ContactData withLastname(String secondname) {
    this.lastname = secondname;
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

  public String getLastName() { return lastname;}

  public String getGroup(){
    return group;
  }


}
