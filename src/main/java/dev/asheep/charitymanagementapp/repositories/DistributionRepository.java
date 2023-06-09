package dev.asheep.charitymanagementapp.repositories;

import dev.asheep.charitymanagementapp.models.Category;
import dev.asheep.charitymanagementapp.models.Distribution;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DistributionRepository extends JpaRepository<Distribution, Integer> {
    List<Distribution> findByReceiverId(Integer id);

    List<Distribution> findByItemCategory(Category category);

    List<Distribution> findByEventId(Integer id);
}
