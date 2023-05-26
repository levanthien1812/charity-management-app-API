package dev.asheep.charitymanagementapp.controllers;

import dev.asheep.charitymanagementapp.models.Category;
import dev.asheep.charitymanagementapp.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @PostMapping("/add")
    public ResponseEntity<Category> add(@RequestBody Category category) {
        return new ResponseEntity<Category>(categoryService.createCategory(category), HttpStatus.CREATED);
    }

    @GetMapping("/get-all")
    public List<Category> getAll() {
        return categoryService.getAllCategories();
    }

}
