package dev.asheep.charitymanagementapp.controllers;

import dev.asheep.charitymanagementapp.models.*;
import dev.asheep.charitymanagementapp.service.CategoryService;
import dev.asheep.charitymanagementapp.service.DistributionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/itemfr")
public class ItemFromController {
    @Autowired
    private DistributionService distributionService;
    @Autowired
    private CategoryService categoryService;
    @PostMapping("")
    public ResponseEntity<Response> createItemFr(@RequestBody ReqItemFr reqItemFr) {
        try {
            if(reqItemFr.getCategoryId() == null){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Response("failed", "Required category_id", ""));
            }
            Optional<Category> category = categoryService.getCategoryById(reqItemFr.getCategoryId());
            if(category.isPresent()){
                ItemFrom itemFrom = new ItemFrom();
                itemFrom.setTime(LocalTime.now());
                itemFrom.setAmount(reqItemFr.getAmount());
                itemFrom.setCategory(category.get());
                // create item from
                ItemFrom newItem = distributionService.createItemFrom(itemFrom);
                // increase amount
                categoryService.updateCategoryAmount(reqItemFr.getCategoryId(), reqItemFr.getAmount());
                return ResponseEntity.status(HttpStatus.OK).body(new Response("success", "Create new item-from successfully", newItem));
            }else{
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Response("failed", "Category not found", ""));
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Response("failed", e.getMessage(), ""));
        }
    }

    @GetMapping("/category/{id}")
    public ResponseEntity<Response> getItemFrbyCategoryId(@PathVariable Integer id){
        return null;
    }

}

class ReqItemFr {
    private Double amount;
    private Integer categoryId;

    public ReqItemFr() {
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }
}
