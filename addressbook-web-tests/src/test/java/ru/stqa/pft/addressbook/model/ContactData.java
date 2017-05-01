package ru.stqa.pft.addressbook.model;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.File;

/**
 * Created by mocius on 2017-04-02.
 */
@Entity
@Table(name ="addressbook")

public class ContactData {


  @Id
  @Column(name= "id")
  private int id ;
  @Column(name = "firstname")
  private  String firstname;
  @Column(name = "lastname")
  private  String lastname;
  @Transient
  private String group;
  @Column(name = "home")
  @Type(type = "text")
  private String homePhone;
  @Column(name = "mobile")
  @Type(type = "text")
  private String mobilePhone;
  @Column(name = "work")
  @Type(type = "text")
  private String workPhone;
  @Transient
  private String AllPhones;

  @Override
  public String toString() {
    return "ContactData{" +
            "id=" + id +
            ", firstname='" + firstname + '\'' +
            ", lastname='" + lastname + '\'' +
            '}';
  }

  @Column(name = "photo")
  @Type(type = "text")
  private String photo;

  public File getPhoto() {
    return new File(photo);
  }

  public ContactData withPhoto(File photo) {
    this.photo = photo.getPath();
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
