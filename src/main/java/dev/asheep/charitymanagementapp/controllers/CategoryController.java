package dev.asheep.charitymanagementapp.controllers;

import dev.asheep.charitymanagementapp.models.Category;
import dev.asheep.charitymanagementapp.models.Response;
import dev.asheep.charitymanagementapp.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/api/categories")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @PostMapping
    public ResponseEntity<Category> add(@RequestBody Category category) {
        return new ResponseEntity<Category>(categoryService.createCategory(category), HttpStatus.CREATED);
    }

    @GetMapping
    public List<Category> getAll() {
        return categoryService.getAllCategories();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Response> getById(@PathVariable Integer id){
        try{
            Optional<Category> category = categoryService.getCategoryById(id);
            return category.isPresent()?
                    ResponseEntity.status(HttpStatus.OK).body(new Response("successfully","Query Category By ID successfully", category)) :
                    ResponseEntity.status(HttpStatus.OK).body(new Response("failed","Query Category By id failed", ""));
        }catch(Exception ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Response("failed", "Get category by id failed", "" ));
        }
    }

}
