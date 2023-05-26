package dev.asheep.charitymanagementapp.service;

import dev.asheep.charitymanagementapp.models.Event;
import dev.asheep.charitymanagementapp.repositories.EventRepository;
import org.hibernate.mapping.Join;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventServiceImpl implements EventService{
    @Autowired
    private EventRepository eventRepository;

    @Override
    public Event createEvent(Event event) {
        return eventRepository.save(event);
    }

    @Override
    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    @Override
    public void getEvent(Integer eventId) {
        eventRepository.deleteById(eventId);
    }

//    @Override
//    public List<Event> getEventsByDonorId(Integer donorId) {
//
//    }
}
