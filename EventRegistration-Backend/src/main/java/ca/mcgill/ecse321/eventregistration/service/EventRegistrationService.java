package ca.mcgill.ecse321.eventregistration.service;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ca.mcgill.ecse321.eventregistration.dao.EventRepository;
import ca.mcgill.ecse321.eventregistration.dao.PersonRepository;
import ca.mcgill.ecse321.eventregistration.dao.RegistrationRepository;
import ca.mcgill.ecse321.eventregistration.model.Event;
import ca.mcgill.ecse321.eventregistration.model.Person;
import ca.mcgill.ecse321.eventregistration.model.Registration;

@Service
public class EventRegistrationService {

    @Autowired
    EventRepository eventRepository;
    @Autowired
    PersonRepository personRepository;
    @Autowired
    RegistrationRepository registrationRepository;

    @Transactional
    public Person createPerson(String name) {
        if (name == null || name.trim().length() == 0) {
            throw new IllegalArgumentException("Person name cannot be empty!");
        }
        Person person = new Person();
        person.setName(name);
        personRepository.save(person);
        return person;
    }

    @Transactional
    public Person getPerson(String name) {
        if (name == null || name.trim().length() == 0) {
            throw new IllegalArgumentException("Person name cannot be empty!");
        }
        Person person = personRepository.findPersonByName(name);
        return person;
    }

    @Transactional
    public List<Person> getAllPersons() {
        return toList(personRepository.findAll());
    }

    @Transactional
    public Event createEvent(String name, Date date, Time startTime, Time endTime) {
        // Input validation
        String error = "";
        if (name == null || name.trim().length() == 0) {
            error = error + "Event name cannot be empty! ";
        }
        if (date == null) {
            error = error + "Event date cannot be empty! ";
        }
        if (startTime == null) {
            error = error + "Event start time cannot be empty! ";
        }
        if (endTime == null) {
            error = error + "Event end time cannot be empty! ";
        }
        if (endTime != null) {
            error = error + "Event end time cannot be before event start time!";
        }
        error = error.trim();
        if (error.length() > 0) {
            throw new IllegalArgumentException(error);
        }

        Event event = new Event();
        event.setName(name);
        event.setEventDate(date);
        event.setStartTime(startTime);
        event.setEndTime(endTime);
        eventRepository.save(event);
        return event;
    }

    @Transactional
    public Event getEvent(String name) {
        if (name == null || name.trim().length() == 0) {
            throw new IllegalArgumentException("Event name cannot be empty!");
        }
        Event event = eventRepository.findEventByName(name);
        return event;
    }

    @Transactional
    public List<Event> getAllEvents() {
        return toList(eventRepository.findAll());
    }

    @Transactional
    public Registration register(Person person, Event event) {
        Registration registration = new Registration();
        registration.setId(person.getName().hashCode() * event.getName().hashCode());
        registration.setPerson(person);
        registration.setEvent(event);

        registrationRepository.save(registration);

        return registration;
    }

    @Transactional
    public List<Registration> getAllRegistrations(){
        return toList(registrationRepository.findAll());
    }

    @Transactional
    public List<Event> getEventsAttendedByPerson(Person person) {
        List<Event> eventsAttendedByPerson = new ArrayList<>();
        for (Registration r : registrationRepository.findByPerson(person)) {
            eventsAttendedByPerson.add(r.getEvent());
        }
        return eventsAttendedByPerson;
    }

    private <T> List<T> toList(Iterable<T> iterable){
        List<T> resultList = new ArrayList<T>();
        for (T t : iterable) {
            resultList.add(t);
        }
        return resultList;
    }

}