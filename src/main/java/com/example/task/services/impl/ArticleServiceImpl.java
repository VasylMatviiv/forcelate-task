package com.example.task.services.impl;

import com.example.task.entity.Article;
import com.example.task.repositories.ArticleRepository;
import com.example.task.services.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("articleService")
@Repository
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    public ArticleRepository articleRepository;

    @Override
    public Article save(Article article) {
        return articleRepository.save(article);
    }

    @Override
    public List<Article> getAll() {
        return articleRepository.findAll();
    }
}
