package com.example.task.utils;

import com.example.task.entity.Article;
import com.example.task.entity.Color;
import com.example.task.entity.User;
import org.apache.commons.lang.RandomStringUtils;

import java.util.*;

public class RandomDataUtils {
    private static final List<Color> VALUES = Collections.unmodifiableList(Arrays.asList(Color.values()));
    private static final int SIZE = VALUES.size();
    private static Random RANDOM = new Random();

    public static User createUser() {
        int a = 10;
        int b = 80;
        int articlesCount = RANDOM.nextInt(5);
        List<Article> list=new ArrayList<>();
        User user = new User();
        user.setName(RandomStringUtils.randomAlphabetic(10));
        user.setAge(a + (int) (Math.random() * b));
        for (int i = 0; i < articlesCount; i++)
        {
            list.add(createArticle());
        }
        user.setArticles(list);
            return user;
    }

    public static Article createArticle() {
        Article article = new Article();
        article.setText(RandomStringUtils.randomAlphabetic(20));
        article.setColor(VALUES.get(RANDOM.nextInt(SIZE)));
        return article;
    }

}
