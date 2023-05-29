package dev.asheep.charitymanagementapp.controllers;

import dev.asheep.charitymanagementapp.exception.ResourceNotFoundException;
import dev.asheep.charitymanagementapp.models.Donation;
import dev.asheep.charitymanagementapp.models.Donor;
import dev.asheep.charitymanagementapp.models.Event;
import dev.asheep.charitymanagementapp.repositories.CategoryRepository;
import dev.asheep.charitymanagementapp.repositories.DonorRepository;
import dev.asheep.charitymanagementapp.repositories.EventRepository;
import dev.asheep.charitymanagementapp.service.DonationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/donations")
public class DonationController {
    @Autowired
    private DonationService donationService;
    @Autowired
    private DonorRepository donorRepository;
    @Autowired
    private EventRepository eventRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    @PostMapping
    public ResponseEntity<?> add(@RequestBody Donation donation) {
        Donation newDonation = donationService.createDonation(donation);
        Donor donor = newDonation.getDonor();
        Event event = newDonation.getEvent();

//        Add donation to Event and Donor
//        Add donor to event and vice versa
        donor.addDonation(newDonation);
        donor.addJoinedEvent(event);
        event.addDonation(newDonation);
        event.addJoinedDonor(donor);

//        Update score for donor
//        Set amount got for event
        if (donation.getTransfer() != null) {
            donor.setScore((int) (donor.getScore() + (donation.getTransfer().getAmount()/10000)));
            event.setAmountGot(donation.getTransfer().getAmount());
        }

        if (donation.getItem() != null) {
            donor.setScore((int) (donor.getScore() + donation.getItem().getAmount()));
            event.setAmountGot(donation.getItem().getAmount());
        }

        donorRepository.save(donor);
        eventRepository.save(event);
        return ResponseEntity.status(HttpStatus.OK).body(newDonation);
    }
}
