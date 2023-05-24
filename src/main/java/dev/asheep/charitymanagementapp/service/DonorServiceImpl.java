package dev.asheep.charitymanagementapp.service;

import dev.asheep.charitymanagementapp.exception.ResourceNotFoundException;
import dev.asheep.charitymanagementapp.models.Donor;
import dev.asheep.charitymanagementapp.repositories.DonorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DonorServiceImpl implements DonorService{

    @Autowired
    private DonorRepository donorRepository;
    @Override
    public Donor createDonor(Donor donor) {
        return donorRepository.save(donor);
    }

    @Override
    public List<Donor> getAllDonors() {
        return donorRepository.findAll();
    }

    @Override
    public Donor getDonor(Integer donorId) {
        return donorRepository.findById(donorId).orElseThrow(() -> new ResourceNotFoundException("Donor", "Id", donorId));
    }
}
