package kz.forum.services;

import kz.forum.models.Articles;

import java.util.*;

public interface ArticleService {

    List<Articles> allArticles();

    Articles addArticle(Articles a);

    Articles updateArticle(Articles a);

    Articles getArticle(Long id);

    void deleteArticle(Long id);


}
