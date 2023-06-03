package dev.asheep.charitymanagementapp.repositories;

import dev.asheep.charitymanagementapp.models.Donor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

//You need to create the repository that holds user records

@Repository
public interface DonorRepository extends JpaRepository<Donor, Integer> {
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
    List<Donor> findByUsernameOrName(String username, String name);
}
