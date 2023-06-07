package dev.asheep.charitymanagementapp.controllers;

import dev.asheep.charitymanagementapp.exception.ResourceNotFoundException;
import dev.asheep.charitymanagementapp.models.Category;
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

import java.util.List;

@RestController
@CrossOrigin
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

    @GetMapping
    public ResponseEntity<?> getAll() {
        List<Donation> donations = donationService.getAllDonations();
        return ResponseEntity.ok(donations);
    }

    @PostMapping
    public ResponseEntity<?> add(@RequestBody Donation donation) {
        Donation newDonation = donationService.createDonation(donation);
        Donor donor = newDonation.getDonor();
        Event event = newDonation.getEvent();

//        Add donation to Event and Donor
        donor.addDonation(newDonation);
        event.addDonation(newDonation);

//        Update score for donor
//        Set total transfer amount/total item amount for donor
//        Set amount got for event
        if (donation.getTransfer() != null) {
            donor.setScore((int) (donor.getScore() + (donation.getTransfer().getAmount() * donation.getEvent().getCategory().getScoreExchange())));
            donor.setTotalTransferAmount(donor.getTotalTransferAmount() + donation.getTransfer().getAmount());
            event.setAmountGot(donation.getTransfer().getAmount());

            Category category = donation.getEvent().getCategory();
            category.setTotalAmount(category.getTotalAmount() + donation.getTransfer().getAmount());
        }

        if (donation.getItem() != null) {
            donor.setScore((int) (donor.getScore() + (donation.getItem().getAmount() * donation.getItem().getCategory().getScoreExchange())));
            donor.setTotalItemAmount(donor.getTotalItemAmount() + donation.getItem().getAmount());
            event.setAmountGot(donation.getItem().getAmount());

//            update category total amount
            Category category = donation.getItem().getCategory();
            category.setTotalAmount(category.getTotalAmount() + donation.getItem().getAmount());
        }

        donorRepository.save(donor);
        eventRepository.save(event);
        return ResponseEntity.status(HttpStatus.OK).body(newDonation);
    }
}
