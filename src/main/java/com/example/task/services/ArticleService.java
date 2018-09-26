package com.example.task.services;

import com.example.task.entity.Article;

import java.util.List;

public interface ArticleService {
    public Article save(Article article);
    public List<Article> getAll();
}
