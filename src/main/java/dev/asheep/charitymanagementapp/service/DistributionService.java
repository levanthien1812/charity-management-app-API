package dev.asheep.charitymanagementapp.service;

import dev.asheep.charitymanagementapp.models.Distribution;
import dev.asheep.charitymanagementapp.models.ItemTo;
import org.springframework.stereotype.Service;

@Service
public interface DistributionService {
    public ItemTo createItemTo(ItemTo itemTo);

    public Distribution createDistribution (Distribution distribution);
}
