package kz.forum.services;

import kz.forum.models.Categories;

import java.util.*;

public interface CategoryService {

    Categories addCategory(Categories c);

    Categories updateCategory(Categories c);

    Categories getCategory(Long id);

    List<Categories> allCategories();

    void deleteCategory(Long id);

}
