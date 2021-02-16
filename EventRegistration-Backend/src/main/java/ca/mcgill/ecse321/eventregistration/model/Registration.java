package ca.mcgill.ecse321.eventregistration.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Id;


public class Registration {
  private Person person;

  @ManyToOne
  public Person getPerson(){
    return this.person;
  }

  public void setPerson(Person person) {
    this.person = person;
  }

  private Event event;

  @ManyToOne
  public Event getEvent() {
    return this.event;
  }

  public void setEvent(Event event) {
    this.event = event;
  }

  private Integer Id;

  public void setId(Integer Id) {
    this.Id = Id;
  }

  @Id
  public Integer getId() {
    return this.Id;
  }
}