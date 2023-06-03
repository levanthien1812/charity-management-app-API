package dev.asheep.charitymanagementapp.service;

import dev.asheep.charitymanagementapp.exception.ResourceExistedException;
import dev.asheep.charitymanagementapp.exception.ResourceNotFoundException;
import dev.asheep.charitymanagementapp.models.Donation;
import dev.asheep.charitymanagementapp.models.Donor;
import dev.asheep.charitymanagementapp.models.Event;
import dev.asheep.charitymanagementapp.repositories.DonorRepository;
import dev.asheep.charitymanagementapp.repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

@Service
public class DonorServiceImpl implements DonorService{

    @Autowired
    private DonorRepository donorRepository;

    @Autowired
    private EventRepository eventRepository;
    @Override
    public Donor createDonor(Donor donor) {
        return donorRepository.save(donor);
    }

    @Override
    public List<Donor> getAllDonors(String search) {
        List<Donor> donors;
        if (search != null) {
            donors = donorRepository.findByUsernameOrName(search, search);
        } else {
            donors = donorRepository.findAll();
        }
        return donors;
    }

    @Override
    public Donor getDonor(Integer donorId) {
        return donorRepository.findById(donorId).get();
    }

    @Override
    public void deleteDonor(Integer donorId) {
        donorRepository.deleteById(donorId);
    }

    @Override
    public Set<Event> getJoinedEvents(Integer donorId) {
        Donor donor = donorRepository.findById(donorId).orElse(null);
        if (donor == null) return Collections.EMPTY_SET;
        return donor.getJoinedEvents();
    }

    @Override
    public Set<Donation> getDonations(Integer donorId) {
        Donor donor = donorRepository.findById(donorId).get();
        return donor.getDonations();
    }
}
