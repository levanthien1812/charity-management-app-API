package dev.asheep.charitymanagementapp.service;


import dev.asheep.charitymanagementapp.models.Distribution;
import dev.asheep.charitymanagementapp.models.ItemFrom;
import dev.asheep.charitymanagementapp.models.ItemTo;
import dev.asheep.charitymanagementapp.repositories.DistributionRepository;
import dev.asheep.charitymanagementapp.repositories.ItemFromRepository;
import dev.asheep.charitymanagementapp.repositories.ItemToRepository;
import dev.asheep.charitymanagementapp.repositories.ReceiverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DistributionServiceImpl  implements DistributionService{
    @Autowired
    private ItemFromRepository itemFromRepository;
    @Autowired
    private ItemToRepository itemToRepository;
    @Autowired
    private DistributionRepository distributionRepository;
    @Override
    public ItemFrom createItemFrom(ItemFrom itemFrom){
        return itemFromRepository.save(itemFrom);
    }
    @Override
    public ItemTo createItemTo(ItemTo itemTo){
       return itemToRepository.save(itemTo);
    }

    @Override
    public Distribution createDistribution (Distribution distribution){
        return distributionRepository.save(distribution);
    }
}
