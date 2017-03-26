package ru.stqa.pft.addressbook;

public class PersonData {
  private final String name;
  private final String middlename;
  private final String mail;
  private final String phone;

  public PersonData(String name, String middlename, String mail, String phone) {
    this.name = name;
    this.middlename = middlename;
    this.mail = mail;
    this.phone = phone;
  }

  public String getName() {
    return name;
  }

  public String getMiddlename() {
    return middlename;
  }

  public String getMail() {
    return mail;
  }

  public String getPhone() {
    return phone;
  }
}
