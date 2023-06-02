package dev.asheep.charitymanagementapp.service;

import dev.asheep.charitymanagementapp.models.Receiver;
import dev.asheep.charitymanagementapp.models.ReceiverType;
import dev.asheep.charitymanagementapp.repositories.ReceiverRepository;
import dev.asheep.charitymanagementapp.repositories.ReceiverTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.lang.model.element.RecordComponentElement;
import java.util.List;
import java.util.Optional;

@Service
public class ReceiverServiceImpl implements ReceiverService{
    @Autowired
    private ReceiverRepository receiverRepository;
    @Autowired
    private ReceiverTypeRepository receiverTypeRepository;

    @Override
    public Receiver createReceiver(Receiver receiver){
        return receiverRepository.save(receiver);
    }

    @Override
    public List<ReceiverType> getAllReceiverType(){
        return receiverTypeRepository.findAll();
    }

    @Override
    public List<Receiver> findByPhone(String phone){
        return receiverRepository.findByPhone(phone);
    }

    @Override
    public List<Receiver> findByDocId(String docId){
        return receiverRepository.findByDocId(docId);
    }

    @Override
    public List<Receiver> getAllReceivers( ){
        return receiverRepository.findAll();
    }

    @Override
    public Optional<Receiver> getById(Integer id){
        return receiverRepository.findById(id);
    }

    @Override
    public Receiver updateReceiver(Receiver receiver, Receiver update){
        receiver.setAddress(update.getAddress() != null ? update.getAddress()  : receiver.getAddress());
        receiver.setCityprovince(update.getCityprovince() != null ? update.getCityprovince()  : receiver.getCityprovince());
        receiver.setCountry(update.getCountry() != null ? update.getCountry()  : receiver.getCountry());
        receiver.setDescription(update.getDescription() != null ? update.getDescription()  : receiver.getDescription());
        receiver.setDistrict(update.getDistrict() != null ? update.getDistrict()  : receiver.getDistrict());
        receiver.setDocId(update.getDocId() != null ? update.getDocId()  : receiver.getDocId());
        receiver.setPhone(update.getPhone() != null ? update.getPhone()  : receiver.getPhone());
        receiver.setBirthday(update.getBirthday() != null ? update.getBirthday()  : receiver.getBirthday());
        receiver.setPhoto(update.getPhoto() != null ? update.getPhoto()  : receiver.getPhoto());
        receiver.setName(update.getName() != null ? update.getName()  : receiver.getName());
        receiver.setBankName(update.getBankName() != null ? update.getBankName()  : receiver.getBankName());
        receiver.setBankNumber(update.getBankNumber() != null ? update.getBankNumber()  : receiver.getBankNumber());
        return receiverRepository.save(receiver);
    }
}
