package dev.asheep.charitymanagementapp.repositories;

import dev.asheep.charitymanagementapp.models.Receiver;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReceiverRepository extends JpaRepository<Receiver, Integer> {
    List<Receiver> findByPhone(String phone);

    List<Receiver> findByDocId(String docId);

}
