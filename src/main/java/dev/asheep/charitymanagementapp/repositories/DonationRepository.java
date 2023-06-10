package dev.asheep.charitymanagementapp.repositories;

import dev.asheep.charitymanagementapp.models.Category;
import dev.asheep.charitymanagementapp.models.Donation;
import dev.asheep.charitymanagementapp.models.Donor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DonationRepository extends JpaRepository<Donation, Integer> {
    List<Donation> findByItemCategoryId(Integer id);

    @Query("SELECT d.event.category, SUM(d.item.amount) FROM Donation d WHERE d.donor = :donor GROUP BY d.event.category")
    List<Object[]> getTotalAmountByCategoryForDonor(@Param("donor") Donor donor);
}
