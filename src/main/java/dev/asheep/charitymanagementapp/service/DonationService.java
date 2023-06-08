package dev.asheep.charitymanagementapp.service;

import dev.asheep.charitymanagementapp.models.Donation;
import dev.asheep.charitymanagementapp.repositories.DonationRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface DonationService {
    public Donation createDonation(Donation donation);

    public List<Donation> getDonationByCategoryId(Integer id);
}
