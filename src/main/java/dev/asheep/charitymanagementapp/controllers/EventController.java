package dev.asheep.charitymanagementapp.controllers;

import dev.asheep.charitymanagementapp.exception.ResourceExistedException;
import dev.asheep.charitymanagementapp.models.Event;
import dev.asheep.charitymanagementapp.repositories.EventRepository;
import dev.asheep.charitymanagementapp.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;

@RestController
@RequestMapping("/api/events")
public class EventController {
    @Autowired
    private EventService eventService;

    @Autowired
    private EventRepository eventRepository;

    @PostMapping
    public ResponseEntity<?> add (@RequestBody Event event) {
        Event newEvent = eventService.createEvent(event);
        return ResponseEntity.status(HttpStatus.CREATED).body(newEvent);
    }

    @GetMapping("/{eventId}")
    public ResponseEntity<?> get(@PathVariable Integer eventId) {
        if (eventRepository.existsById(eventId) == false) {
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
}
