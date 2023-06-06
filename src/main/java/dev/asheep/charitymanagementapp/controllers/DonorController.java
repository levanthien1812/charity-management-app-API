package dev.asheep.charitymanagementapp.controllers;

import dev.asheep.charitymanagementapp.exception.ResourceExistedException;
import dev.asheep.charitymanagementapp.exception.ResourceNotFoundException;
import dev.asheep.charitymanagementapp.models.Donation;
import dev.asheep.charitymanagementapp.models.Donor;
import dev.asheep.charitymanagementapp.models.Event;
import dev.asheep.charitymanagementapp.repositories.DonorRepository;
import dev.asheep.charitymanagementapp.repositories.EventRepository;
import dev.asheep.charitymanagementapp.service.DonorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@CrossOrigin
@RequestMapping("/api/donors")
public class DonorController {
    @Autowired
    private DonorService donorService;

    @Autowired
    private DonorRepository donorRepository;

    @Autowired
    private EventRepository eventRepository;

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody Donor donor) {
        if (donorRepository.existsByUsername(donor.getUsername())) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResourceExistedException("Donor", "Username", donor.getUsername()));
        }
        if (donorRepository.existsByEmail(donor.getEmail())) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResourceExistedException("Donor", "Email", donor.getEmail()));
        }
        Donor newDonor = donorService.createDonor(donor);
        return ResponseEntity.status(HttpStatus.CREATED).body(newDonor);
    }

    @GetMapping("/get-all")
    public List<Donor> getAll(@RequestParam(required = false, name = "search") String search) {
        return donorService.getAllDonors(search);
    }

    @PostMapping("/log-in")
    public ResponseEntity<?> get(@RequestParam("username") String username, @RequestParam("password") String password) {
        if (!donorRepository.existsByUsername(username) && !donorRepository.existsByEmail(username)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResourceNotFoundException("Donor", "username or email", username));
        }

        Donor donorByEmail = donorRepository.findByEmailAndPassword(username, password);
        Donor donorByUsername = donorRepository.findByUsernameAndPassword(username, password);
        Donor donor;

        if (donorByEmail == null && donorByUsername == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Exception("Password is not correct!"));
        } else {
            if (donorByUsername == null) donor = donorByEmail;
            else donor = donorByUsername;
        }

        return ResponseEntity.status(HttpStatus.OK).body(donor);
    }

    @GetMapping("/{donorId}")
    public ResponseEntity<?> get(@PathVariable Integer donorId) {
        if (donorRepository.findById(donorId).isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResourceNotFoundException("Donor", "Id", donorId));
        }
        return ResponseEntity.status(HttpStatus.OK).body(donorService.getDonor(donorId));
    }

    @DeleteMapping("/{donorId}")
    public ResponseEntity<?> delete(@PathVariable Integer donorId) {
        if (donorRepository.findById(donorId).isEmpty() == true) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResourceNotFoundException("Donor", "Id", donorId));
        }
        donorService.deleteDonor(donorId);
        return ResponseEntity.ok("Delete successfully");
    }

    @GetMapping("/{donorId}/events")
    public  ResponseEntity<?> getJoinedEvents(@PathVariable Integer donorId) {
        if (donorRepository.findById(donorId).isEmpty() == true) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResourceNotFoundException("Donor", "Id", donorId));
        }

        Set<Event> events = donorService.getJoinedEvents(donorId);
        return ResponseEntity.ok(events);
    }

    @GetMapping("/{donorId}/donations")
    public  ResponseEntity<?> getDonations(@PathVariable Integer donorId) {
        if (donorRepository.findById(donorId).isEmpty() == true) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResourceNotFoundException("Donor", "Id", donorId));
        }
        Set<Donation> donations = donorService.getDonations(donorId);
        return ResponseEntity.ok(donations);
    }
}
