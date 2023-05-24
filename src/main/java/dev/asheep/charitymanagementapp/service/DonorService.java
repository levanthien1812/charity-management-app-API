package dev.asheep.charitymanagementapp.service;

import dev.asheep.charitymanagementapp.models.Donor;

import java.util.List;

public interface DonorService {
    public Donor createDonor(Donor donor) ;
    public List<Donor> getAllDonors();
    public Donor getDonor(Integer donorId);
}
