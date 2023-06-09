package dev.asheep.charitymanagementapp.repositories;


import dev.asheep.charitymanagementapp.models.ItemTo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemToRepository extends JpaRepository<ItemTo, Integer> {
    List<ItemTo> findByCategoryId (Integer id);
}
