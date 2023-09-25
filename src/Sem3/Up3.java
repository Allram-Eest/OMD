package Sem3;

import java.util.Optional;
import java.util.*;

interface ArticleDB {
    public Optional<Article> findArticle(String ean);
}

interface Article {
    public Optional<Double> price();
}

class Ex03 {

    public double priceOfExpensiveArticles(List<String> eans, ArticleDB articleDB, double priceLimit) {
        return  
            eans
            .stream() //Stream<String>
            .map(ean -> 
                articleDB
                .findArticle(ean) //Stream<Optional<Article>>
                .flatMap(article -> article.price()) //Optional<Double>>
                .orElse(0.0))
            .filter(price -> price >= priceLimit)
            .reduce(0.0, (acc, e) -> acc +e);
    }

    public double coolPriceOfExpensiveArticles(List<String> eans, ArticleDB articleDB, double priceLimit) {
        return  
            eans
            .stream() //Stream<String>
            .flatMap(ean -> 
                articleDB
                .findArticle(ean) //Stream<Optional<Article>>
                .flatMap(article -> article.price()) //Stream<Optional<Double>>
                .stream()) //Stream<Stream<Double>>
            .filter(price -> price >= priceLimit)
            .reduce(0.0, (acc, e) -> acc +e);
    }
}


