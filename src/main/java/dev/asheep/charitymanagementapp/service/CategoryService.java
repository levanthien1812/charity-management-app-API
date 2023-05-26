package dev.asheep.charitymanagementapp.service;

import dev.asheep.charitymanagementapp.models.Category;
import dev.asheep.charitymanagementapp.models.Donor;

import java.util.List;

public interface CategoryService {
    public Category createCategory(Category category);
    public List<Category> getAllCategories();
}
