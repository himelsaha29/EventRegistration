package ca.mcgill.ecse321.eventregistration.model;

import java.sql.Date;
import java.sql.Time;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Event {
  private String name;

  public void setName(String aName)
  {
    this.name = aName;
  }
  @Id
  public String getName() {
    return name;
  }

  private Date eventDate;

  public void setEventDate(Date aEventDate) {
    this.eventDate = aEventDate;
  }

  public Date getEventDate() {
    return eventDate;
  }

  private Time startTime;

  public void setStartTime(Time aStartTime) {
    this.startTime = aStartTime;
  }

  public Time getStartTime() {
    return startTime;
  }

  private Time endTime;

  public void setEndTime(Time aEndTime) {
    this.endTime = aEndTime;
  }

  public Time getEndTime() {
    return endTime;
  }
}