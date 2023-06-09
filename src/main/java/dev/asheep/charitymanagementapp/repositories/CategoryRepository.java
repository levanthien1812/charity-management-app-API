package dev.asheep.charitymanagementapp.repositories;

import dev.asheep.charitymanagementapp.models.Category;
import dev.asheep.charitymanagementapp.models.Distribution;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
