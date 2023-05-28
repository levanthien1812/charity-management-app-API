package dev.asheep.charitymanagementapp.repositories;

import dev.asheep.charitymanagementapp.models.TransferFrom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransferFromRepository extends JpaRepository<TransferFrom, Integer> {
}
