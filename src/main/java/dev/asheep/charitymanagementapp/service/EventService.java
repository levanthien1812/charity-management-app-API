package dev.asheep.charitymanagementapp.service;

import dev.asheep.charitymanagementapp.models.Donation;
import dev.asheep.charitymanagementapp.models.Donor;
import dev.asheep.charitymanagementapp.models.Event;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

public interface EventService {
    public Event createEvent(Event event) ;
    public List<Event> getAllEvents();
    public Event getEvent(Integer eventId);
    public Set<Donor> getDonorsByEventId(Integer eventId);
    public Set<Donation> getDonations(Integer donorId);
    public void deleteEvent(Integer eventId);
}
