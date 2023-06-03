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
        donor.addDonation(newDonation);
        event.addDonation(newDonation);

//        Check if event already exists in donor, then
//        Add joined event to donor
//        Increment event quantity
        if (!donor.getJoinedEvents().contains(donation.getEvent())) {
            donor.addJoinedEvent(event);
            donor.setEventQuantity(donor.getEventQuantity() + 1);
        }

//        Check if donor already exists in event, then
//        Add joined donor to event
//        Increment donor quantity
        if (!event.getJoinedDonors().contains(donation.getDonor())) {
            event.addJoinedDonor(donor);
            event.setDonorQuantity(event.getDonorQuantity() + 1);
        }

//        Update score for donor
//        Set total transfer amount/total item amount for donor
//        Set amount got for event
        if (donation.getTransfer() != null) {
            donor.setScore((int) (donor.getScore() + (donation.getTransfer().getAmount()/10000)));
            donor.setTotalTransferAmount(donor.getTotalTransferAmount() + donation.getTransfer().getAmount());
            event.setAmountGot(donation.getTransfer().getAmount());
        }

        if (donation.getItem() != null) {
            donor.setScore((int) (donor.getScore() + donation.getItem().getAmount()));
            donor.setTotalItemAmount(donor.getTotalItemAmount() + donation.getItem().getAmount());
            event.setAmountGot(donation.getItem().getAmount());
        }

        donorRepository.save(donor);
        eventRepository.save(event);
        return ResponseEntity.status(HttpStatus.OK).body(newDonation);
    }
}
