package Sem3;

import java.util.Optional;
import java.util.List;

interface ArticleDB {
    public Optional<Article> findArticle(String ean);
}

interface Article {
    public Optional<Double> price();
}

class Up3Pre {

    public double priceOfExpensiveArticles(List<String> eans, ArticleDB articleDB, double priceLimit) {
        double totalPrice = eans.stream()
                            .map((String s) -> articleDB.findArticle(s))
                            .flatMap(a -> a.price())
                            .filter(d -> d.orElse(0.0) > priceLimit)
                            .reduce(0.0, (d1, d2) -> d1 + d2);
        return totalPrice;
    }   
}
