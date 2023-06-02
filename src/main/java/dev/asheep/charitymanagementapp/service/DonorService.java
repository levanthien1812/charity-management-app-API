package dev.asheep.charitymanagementapp.service;

import dev.asheep.charitymanagementapp.models.Donation;
import dev.asheep.charitymanagementapp.models.Donor;
import dev.asheep.charitymanagementapp.models.Event;

import java.util.List;
import java.util.Set;

public interface DonorService {
    public Donor createDonor(Donor donor) ;
    public List<Donor> getAllDonors(String search);
    public Donor getDonor(Integer donorId);
    public void deleteDonor(Integer donorId);
    public Set<Event> getJoinedEvents(Integer donorId);
    public Set<Donation> getDonations(Integer donorId);
}
