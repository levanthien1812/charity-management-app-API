package dev.asheep.charitymanagementapp.service;

import dev.asheep.charitymanagementapp.models.Distribution;
import dev.asheep.charitymanagementapp.models.ItemFrom;
import dev.asheep.charitymanagementapp.models.ItemTo;
import org.springframework.stereotype.Service;

import java.util.List;

public interface DistributionService {
    public ItemFrom createItemFrom(ItemFrom itemFrom);
    public ItemTo createItemTo(ItemTo itemTo);

    public Distribution createDistribution (Distribution distribution);

    public List<Distribution> getAllDistributionByReceiver (Integer receiverId);

    public List<Distribution> getAllDistributionByCategory (Integer categoryId);

    public List<Distribution> getAllDistributionByEvent(Integer eventId);
}
