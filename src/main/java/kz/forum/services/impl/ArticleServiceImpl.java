package kz.forum.services.impl;

import kz.forum.models.Articles;
import kz.forum.models.Categories;
import kz.forum.repos.ArticleRepository;
import kz.forum.repos.CategoryRepository;
import kz.forum.services.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Articles> allArticles() {
        return articleRepository.findAll();
    }

    private Articles recordCategoriesForArticles(Articles a) {
        List<Categories> categories = new ArrayList<>();

        if (a.getCategories() != null) {
            for (int i = 0; i < a.getCategories().size(); i++) {
                categories.add(categoryRepository.findById(a.getCategories().get(i).getId()).orElse(null));
            }
        }

        a.setCategories(categories);

        return a;
    }

    @Override
    public Articles addArticle(Articles a) {

        Articles article = recordCategoriesForArticles(a);

        return articleRepository.save(article);
    }

    @Override
    public Articles updateArticle(Articles a) {

        Articles article = recordCategoriesForArticles(a);

        return articleRepository.save(article);
    }

    @Override
    public Articles getArticle(Long id) {
        return articleRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteArticle(Long id) {
        articleRepository.deleteById(id);
    }
}
