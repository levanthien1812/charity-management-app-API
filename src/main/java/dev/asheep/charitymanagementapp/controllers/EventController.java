package dev.asheep.charitymanagementapp.controllers;

import dev.asheep.charitymanagementapp.exception.ResourceExistedException;
import dev.asheep.charitymanagementapp.exception.ResourceNotFoundException;
import dev.asheep.charitymanagementapp.models.Donation;
import dev.asheep.charitymanagementapp.models.Donor;
import dev.asheep.charitymanagementapp.models.Event;
import dev.asheep.charitymanagementapp.repositories.DonorRepository;
import dev.asheep.charitymanagementapp.repositories.EventRepository;
import dev.asheep.charitymanagementapp.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;
import java.util.Set;

@RestController
@CrossOrigin
@RequestMapping("/api/events")
public class EventController {
    @Autowired
    private EventService eventService;

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private DonorRepository donorRepository;

    @PostMapping
    public ResponseEntity<?> add (@RequestBody Event event) {
        Event newEvent = eventService.createEvent(event);
        return ResponseEntity.status(HttpStatus.CREATED).body(newEvent);
    }

    @GetMapping("/{eventId}")
    public ResponseEntity<?> get(@PathVariable Integer eventId) {
        if (!eventRepository.existsById(eventId)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResourceExistedException("Event", "Id", eventId));
        }
        Event event = eventService.getEvent(eventId);
        return ResponseEntity.status(HttpStatus.OK).body(event);
    }

    @GetMapping
    public ResponseEntity<?> getAll() {
        List<Event> events = eventService.getAllEvents();
        return ResponseEntity.status(HttpStatus.OK).body(events);
    }

    @GetMapping("/{eventId}/donors")
    public  ResponseEntity<?> getByEventId(@PathVariable Integer eventId) {
        if (eventRepository.findById(eventId).isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResourceNotFoundException("Event", "Id", eventId));
        }

        List<Donor> donors = eventService.getDonorsByEventId(eventId);
        return ResponseEntity.ok(donors);
    }

    @GetMapping("/{eventId}/donations")
    public  ResponseEntity<?> getDonations(@PathVariable Integer eventId) {
        if (eventRepository.findById(eventId).isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResourceNotFoundException("Event", "Id", eventId));
        }
        Set<Donation> donations = eventService.getDonations(eventId);
        return ResponseEntity.ok(donations);
    }

    @DeleteMapping("/{eventId}")
    public ResponseEntity<?> deleteEvent(@PathVariable Integer eventId) {
        if (eventRepository.findById(eventId).isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResourceNotFoundException("Event", "Id", eventId));
        }
        eventService.deleteEvent(eventId);
        return ResponseEntity.ok("Delete event successfully");
    }

    @GetMapping("/{eventId}/donor-amount/{donorId}")
    public Double getTotalDonationAmount(@PathVariable Integer eventId,@PathVariable Integer donorId) {
        Double totalAmount = 0D;
        Event event = eventRepository.findById(eventId).get();
        Donor donor = donorRepository.findById(donorId).get();

        for (Donation donation : donor.getDonations()) {
            if (donation.getEvent().equals(event)) {
                if (donation.getTransfer() != null) {
                    totalAmount = totalAmount + donation.getTransfer().getAmount();
                } else {
                    totalAmount = totalAmount + donation.getItem().getAmount();
                }
            }
        }

        return totalAmount;
    }
}
