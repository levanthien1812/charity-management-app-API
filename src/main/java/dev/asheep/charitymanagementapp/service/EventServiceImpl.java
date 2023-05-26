package dev.asheep.charitymanagementapp.service;

import dev.asheep.charitymanagementapp.models.Event;
import dev.asheep.charitymanagementapp.repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventServiceImpl implements EventService{
    @Autowired
    private EventRepository eventRepository;

    @Override
    public Event createEvent(Event event) {
        return null;
    }

    @Override
    public List<Event> getAllEvents() {
        return null;
    }

    @Override
    public Event getDonor(Integer eventId) {
        return null;
    }
}
