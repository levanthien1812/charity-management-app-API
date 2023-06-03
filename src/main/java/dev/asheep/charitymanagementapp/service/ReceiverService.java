package dev.asheep.charitymanagementapp.service;

import dev.asheep.charitymanagementapp.models.Receiver;
import dev.asheep.charitymanagementapp.models.ReceiverType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ReceiverService {
    public Receiver createReceiver(Receiver receiver);
    public List<ReceiverType> getAllReceiverType();

    public List<Receiver> findByPhone(String phone);

    public List<Receiver> findByDocId(String docId);

    public List<Receiver> getAllReceivers(  );

    public Optional<Receiver> getById(Integer id);

    public Receiver updateReceiver(Receiver receiver, Receiver update);
}
