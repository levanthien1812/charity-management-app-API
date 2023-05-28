package dev.asheep.charitymanagementapp.service;

import dev.asheep.charitymanagementapp.models.TransferFrom;
import dev.asheep.charitymanagementapp.repositories.TransferFromRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransferFromServiceImpl implements TransferFromService{
    @Autowired
    private TransferFromRepository transferFromRepository;
    @Override
    public TransferFrom createTransferFrom(TransferFrom transferFrom) {
        return transferFromRepository.save(transferFrom);
    }
}
