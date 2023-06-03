package dev.asheep.charitymanagementapp.repositories;

import dev.asheep.charitymanagementapp.models.Distribution;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DistributionRepository extends JpaRepository<Distribution, Integer> {
}
