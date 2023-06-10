package dev.asheep.charitymanagementapp.service;

import dev.asheep.charitymanagementapp.models.Category;
import dev.asheep.charitymanagementapp.models.Donation;
import dev.asheep.charitymanagementapp.models.Donor;
import dev.asheep.charitymanagementapp.repositories.CategoryRepository;
import dev.asheep.charitymanagementapp.repositories.DonationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DonationServiceImpl implements DonationService{
    @Autowired
    private DonationRepository donationRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Donation createDonation(Donation donation) {
        return donationRepository.save(donation);
    }

    @Override
    public List<Donation> getDonationByCategoryId(Integer id) {
        return donationRepository.findByItemCategoryId(id);
    }

    @Override
    public List<Donation> getAllDonations() {
        return donationRepository.findAll();
    }

    @Override
    public Map<String , Double> getTotalAmountByCategoryForDonor(Donor donor) {
        List<Object[]> results = donationRepository.getTotalAmountByCategoryForDonor(donor);

        Map<String, Double> totalAmountByCategory = new HashMap<>();
        for (Object[] result : results) {
            Category category = (Category) result[0];
            Double totalAmount = (Double) result[1];
            totalAmountByCategory.put(category.getUnit() + " " + category.getName(), totalAmount);
        }

        return totalAmountByCategory;
    }
}
