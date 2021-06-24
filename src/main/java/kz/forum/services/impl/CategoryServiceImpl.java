package kz.forum.services.impl;

import kz.forum.models.Categories;
import kz.forum.repos.CategoryRepository;
import kz.forum.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Categories addCategory(Categories c) {
        return categoryRepository.save(c);
    }

    @Override
    public Categories updateCategory(Categories c) {
        return categoryRepository.save(c);
    }

    @Override
    public Categories getCategory(Long id) {
        return categoryRepository.findById(id).orElse(null);
    }

    @Override
    public List<Categories> allCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }
}
