package dev.asheep.charitymanagementapp.service;

import dev.asheep.charitymanagementapp.models.Category;
import dev.asheep.charitymanagementapp.models.Donor;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    public Category createCategory(Category category);
    public List<Category> getAllCategories();

    public Category updateCategoryAmount(Integer categoryId, Double amount);

    public Optional<Category> getCategoryById(Integer id);

    public Category decreaseCategoryAmount(Integer categoryId, Double amount);
}
