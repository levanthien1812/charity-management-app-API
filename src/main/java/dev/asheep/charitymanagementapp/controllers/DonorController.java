package dev.asheep.charitymanagementapp.controllers;

import dev.asheep.charitymanagementapp.models.Donor;
import dev.asheep.charitymanagementapp.service.DonorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/donors")
public class DonorController {
    @Autowired
    private DonorService donorService;

    @PostMapping("/add")
    public String add(@RequestBody Donor donor) {
        donorService.createDonor(donor);
        return "New donor is added";
    }

    @GetMapping("/get-all")
    public List<Donor> getAll() {
        return donorService.getAllDonors();
    }

    @GetMapping("/{donorId}")
    public Donor get(@PathVariable Integer donorId) {
        return donorService.getDonor(donorId);
    }
}
