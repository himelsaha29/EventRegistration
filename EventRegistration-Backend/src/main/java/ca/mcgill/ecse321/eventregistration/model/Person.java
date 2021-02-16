package ca.mcgill.ecse321.eventregistration.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Person{
  private String name;

  public void setName(String name) {
    this.name = name;
  }

  @Id
  public String getName() {
    return this.name;
  }
}