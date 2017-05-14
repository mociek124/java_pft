package ru.stqa.pft.mantis.model;

/**
 * Created by mocius on 2017-05-12.
 */
public class MailMessage {

  public String to;
  public String text;

  public MailMessage(String to, String text){
    this.to = to;
    this.text = text;
  }
}
