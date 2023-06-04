package dev.asheep.charitymanagementapp.service;

import dev.asheep.charitymanagementapp.models.Category;
import dev.asheep.charitymanagementapp.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category updateCategoryAmount(Integer categoryId, Double amount){
        Category category = categoryRepository.findById(categoryId)
                .map(cate -> {
                    cate.setTotalAmount(cate.getTotalAmount() + amount);
                    return categoryRepository.save(cate);
                }).orElseGet(() -> {
                    return null;
                });
        return category;
    }

    @Override
    public Optional<Category> getCategoryById(Integer id){
        return categoryRepository.findById(id);
    }
}
