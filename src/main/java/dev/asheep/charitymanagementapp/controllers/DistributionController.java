package dev.asheep.charitymanagementapp.controllers;

import com.google.api.client.json.Json;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import dev.asheep.charitymanagementapp.models.*;
import dev.asheep.charitymanagementapp.service.CategoryService;
import dev.asheep.charitymanagementapp.service.DistributionService;
import dev.asheep.charitymanagementapp.service.EventService;
import dev.asheep.charitymanagementapp.service.ReceiverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Controller
@CrossOrigin
@RequestMapping("/api/distribution")
public class DistributionController {
    @Autowired
    private DistributionService distributionService;
    @Autowired
    private EventService eventService;

    @Autowired
    private CategoryService categoryService;
    @Autowired
    private ReceiverService receiverService;
    @PostMapping("")
    // Create distribution with product (create itemTo_id)
    public ResponseEntity<Response> createDistributionProduct(@RequestBody DistributionListReq distributionReq){
        try {
            // find event by id
            if(distributionReq.getEvent_id() == null){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Response("failed", "Required event_id", ""));
            }
            Optional<Event> event = eventService.getEventById(distributionReq.getEvent_id());
            if(event.isPresent()){
                distributionReq.getItemList().forEach((itemTo -> {
                    // find category by id
                    Optional<Category> category = categoryService.getCategoryById(itemTo.getCategoryId());
                    // find receiver by id
                    Optional<Receiver> receiver = receiverService.getById(itemTo.getReceiverId());
                    if(category.isPresent() && receiver.isPresent()){
                        // create item-to
                        ItemTo itemto = new ItemTo();
                        itemto.setActualQuantity(0D);
                        itemto.setPlannedQuantity(itemTo.getPlannedQuantity());
                        itemto.setTime(LocalDate.now());
                        itemto.setCategory(category.get());
                        ItemTo newItemTo = distributionService.createItemTo(itemto);

                        // create distribution
                        Distribution distribution = new Distribution();
                        distribution.setEvent(event.get());
                        distribution.setStatus(distributionReq.getStatus());
                        distribution.setReceiver(receiver.get());
                        distribution.setItem(newItemTo);
                        Distribution newDist = distributionService.createDistribution(distribution);
                        // update total-amount category

                        Category updated = categoryService.decreaseCategoryAmount(itemTo.getCategoryId(), itemto.getPlannedQuantity());
                        // Add distribution to receiver
                        Receiver receiverInstance = receiver.get();
                        Collection<Distribution> col = receiverInstance.getDistributions();
                        col.add(newDist);
                        receiverInstance.setDistributions(col);
                    }
                }));
                return ResponseEntity.status(HttpStatus.OK).body(new Response("success", "Create new distribution - item-to successfully", ""));
            }else{
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Response("failed", "Event not found", ""));
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Response("failed", e.getMessage(), ""));
        }
    }

    @PostMapping("/transfer")
    // Create distribution with money (create transfer_id)
    public ResponseEntity<Response> createDistributionTransfer(@RequestBody DistributionListReq distributionReq){
        return null;
    }

    @PutMapping("/update")
    public ResponseEntity<Response> updateStatusDistribution(@RequestBody List<UpdateDistribution> updateDistributionList){
        return null;
    }

    @GetMapping("/receiver/{id}")
    public ResponseEntity<Response> getByReceiverId(@PathVariable Integer id){
        try{
            List<Distribution> list = distributionService.getAllDistributionByReceiver(id);

            return ResponseEntity.status(HttpStatus.OK).body(new Response("success", "Get Distribution List successfully", list));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Response("failed", e.getMessage(), ""));
        }
    }

    @GetMapping("/category/{id}")
    public ResponseEntity<Response> getItemTobyCategoryId(@PathVariable Integer id){
        try{
            List<Distribution> list =  distributionService.getAllDistributionByCategory(id);
            return ResponseEntity.status(HttpStatus.OK).body(new Response("success", "Get Distribution List successfully", list));
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Response("failed", e.getMessage(), ""));
        }
    }

    @GetMapping("/event/{id}")
    public ResponseEntity<Response> getDistributionByEvent(@PathVariable Integer id){
        try{
            List<Distribution> list =  distributionService.getAllDistributionByEvent(id);
            return ResponseEntity.status(HttpStatus.OK).body(new Response("success", "Get Distribution List successfully", list));
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Response("failed", e.getMessage(), ""));
        }
    }

}

class DistributionListReq {
    private Integer event_id;

    private String status;

    private List<ItemToReq> itemList;


    public DistributionListReq() {
    }

    public void setEvent_id(Integer event_id) {
        this.event_id = event_id;
    }

    public List<ItemToReq> getItemList() {
        return itemList;
    }

    public void setItemList(List<ItemToReq> itemList) {
        this.itemList = itemList;
    }

    public Integer getEvent_id() {
        return event_id;
    }

    public void setEvent_id(int event_id) {
        this.event_id = event_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}

class ItemToReq{
    private  Double plannedQuantity;

    private Integer categoryId;

    private Integer receiverId;

    public ItemToReq() {
    }


    public Double getPlannedQuantity() {
        return plannedQuantity;
    }

    public void setPlannedQuantity(Double plannedQuantity) {
        this.plannedQuantity = plannedQuantity;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(Integer receiverId) {
        this.receiverId = receiverId;
    }
}

class UpdateDistribution {
    private Integer distributionId;
    private Double actualQuantity;

    private Integer type;
    // transfer or itemTo

    public UpdateDistribution() {
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getDistributionId() {
        return distributionId;
    }

    public void setDistributionId(Integer distributionId) {
        this.distributionId = distributionId;
    }

    public Double getActualQuantity() {
        return actualQuantity;
    }

    public void setActualQuantity(Double actualQuantity) {
        this.actualQuantity = actualQuantity;
    }
}
