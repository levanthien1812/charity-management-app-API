package dev.asheep.charitymanagementapp.service;

import dev.asheep.charitymanagementapp.models.Category;
import dev.asheep.charitymanagementapp.models.Donation;
import dev.asheep.charitymanagementapp.models.Donor;
import dev.asheep.charitymanagementapp.repositories.DonationRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

public interface DonationService {
    public Donation createDonation(Donation donation);

    public List<Donation> getDonationByCategoryId(Integer id);
    public List<Donation> getAllDonations();

    public Map<String, Double> getTotalAmountByCategoryForDonor(Donor donor);
}
