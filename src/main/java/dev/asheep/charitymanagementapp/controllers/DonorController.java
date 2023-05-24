package dev.asheep.charitymanagementapp.controllers;

import dev.asheep.charitymanagementapp.models.Donor;
import dev.asheep.charitymanagementapp.service.DonorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/donors")
public class DonorController {
    @Autowired
    private DonorService donorService;

    @PostMapping("/add")
    public ResponseEntity<Donor> add(@RequestBody Donor donor) {
        return new ResponseEntity<Donor>(donorService.createDonor(donor), HttpStatus.CREATED);
    }

    @GetMapping("/get-all")
    public List<Donor> getAll() {
        return donorService.getAllDonors();
    }

    @GetMapping("/{donorId}")
    public ResponseEntity<Donor> get(@PathVariable Integer donorId) {
        return new ResponseEntity<Donor>(donorService.getDonor(donorId), HttpStatus.OK);
    }
}
