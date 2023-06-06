package dev.asheep.charitymanagementapp.repositories;

import dev.asheep.charitymanagementapp.models.Distribution;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DistributionRepository extends JpaRepository<Distribution, Integer> {
    List<Distribution> findByReceiverId(Integer id);
}
