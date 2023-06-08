package dev.asheep.charitymanagementapp.service;

import dev.asheep.charitymanagementapp.models.Donation;
import dev.asheep.charitymanagementapp.models.Donor;
import dev.asheep.charitymanagementapp.models.Event;
import dev.asheep.charitymanagementapp.repositories.EventRepository;
import org.hibernate.mapping.Join;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

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
    public Event getEvent(Integer eventId) {
        return eventRepository.findById(eventId).get();
    }

    @Override
    public List<Donor> getDonorsByEventId(Integer eventId) {
        Event event = eventRepository.findById(eventId).orElse(null);
        return event.getDonations()
                .stream()
                .map(Donation::getDonor)
                .collect(Collectors.toList());
    }

    @Override
    public Set<Donation> getDonations(Integer eventId) {
        Event event = eventRepository.findById(eventId).get();
        return event.getDonations();
    }

    @Override
    public void deleteEvent(Integer eventId) {
        eventRepository.deleteById(eventId);
    }

    @Override
    public Optional<Event> getEventById(Integer id){
        return eventRepository.findById(id);
    }
}
