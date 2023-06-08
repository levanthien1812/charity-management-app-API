package dev.asheep.charitymanagementapp.service;


import dev.asheep.charitymanagementapp.models.Category;
import dev.asheep.charitymanagementapp.models.Distribution;
import dev.asheep.charitymanagementapp.models.ItemFrom;
import dev.asheep.charitymanagementapp.models.ItemTo;
import dev.asheep.charitymanagementapp.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DistributionServiceImpl  implements DistributionService{
    @Autowired
    private ItemFromRepository itemFromRepository;
    @Autowired
    private ItemToRepository itemToRepository;
    @Autowired
    private DistributionRepository distributionRepository;
    @Autowired
    private CategoryRepository categoryRepository;
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

    @Override
    public List<Distribution> getAllDistributionByReceiver (Integer receiverId){
        return distributionRepository.findByReceiverId(receiverId);
    }

    @Override
    public List<Distribution> getAllDistributionByCategory (Integer categoryId){
        Optional<Category> category = categoryRepository.findById(categoryId);
        if(category.isPresent()){
            return distributionRepository.findByItemCategory(category.get());
        }
        else return null;
    }

    @Override
    public List<Distribution> getAllDistributionByEvent(Integer eventId){
        return distributionRepository.findByEventId(eventId);
    }
}
