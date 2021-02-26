/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.30.1.5099.60569f335 modeling language!*/
package ca.mcgill.ecse321.eventregistration.model;

import java.util.*;
import java.sql.Date;
import java.sql.Time;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;

// line 9 "model.ump"
// line 43 "model.ump"
@Entity
public class RegistrationManager
{

  private int id;
  @Id
  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  //RegistrationManager Associations
  private List<Person> persons;
  @OneToMany (cascade = {CascadeType.ALL})
  public List<Person> getPersons()
  {
    return this.persons;
  }
  public void setPersons(List<Person> persons) {
    this.persons = persons;
  }

  private List<Registration> registrations;
  @OneToMany (cascade = {CascadeType.ALL})
  public List<Registration> getRegistrations()
  {
    return this.registrations;
  }
  public void setRegistrations(List<Registration> registrations) {
    this.registrations = registrations;
  }

  private List<Event> events;
  @OneToMany (cascade = {CascadeType.ALL})
  public List<Event> getEvents()
  {
    return this.events;
  }
  public void setEvents(List<Event> events) {
    this.events = events;
  }



  public Person getPerson(int index)
  {
    Person aPerson = persons.get(index);
    return aPerson;
  }

  public Registration getRegistration(int index)
  {
    Registration aRegistration = registrations.get(index);
    return aRegistration;
  }

  public Event getEvent(int index)
  {
    Event aEvent = events.get(index);
    return aEvent;
  }


  public int numberOfPersons()
  {
    int number = persons.size();
    return number;
  }

  public boolean hasPersons()
  {
    boolean has = persons.size() > 0;
    return has;
  }

  public int indexOfPerson(Person aPerson)
  {
    int index = persons.indexOf(aPerson);
    return index;
  }
  /* Code from template association_GetMany */


  public int numberOfRegistrations()
  {
    int number = registrations.size();
    return number;
  }

  public boolean hasRegistrations()
  {
    boolean has = registrations.size() > 0;
    return has;
  }

  public int indexOfRegistration(Registration aRegistration)
  {
    int index = registrations.indexOf(aRegistration);
    return index;
  }
  /* Code from template association_GetMany */


  public int numberOfEvents()
  {
    int number = events.size();
    return number;
  }

  public boolean hasEvents()
  {
    boolean has = events.size() > 0;
    return has;
  }

  public int indexOfEvent(Event aEvent)
  {
    int index = events.indexOf(aEvent);
    return index;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfPersons()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public Person addPerson(String aName)
  {
    return null;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfRegistrations()
  {
    return 0;
  }

}