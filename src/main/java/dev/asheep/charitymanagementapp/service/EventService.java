package dev.asheep.charitymanagementapp.service;

import dev.asheep.charitymanagementapp.models.Donor;
import dev.asheep.charitymanagementapp.models.Event;
import org.springframework.stereotype.Service;

import java.util.List;

public interface EventService {
    public Event createEvent(Event event) ;
    public List<Event> getAllEvents();
    public Event getDonor(Integer eventId);
}
