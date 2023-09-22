package Sem2Prework2;

import java.util.List;
import java.util.Optional;

interface ArticleDB {
    public Optional<Article> findArticle(String ean);  // returnerar artikel med given artikelkod
    // ... omissions ...
}

interface Article {
    public Optional<Double> price();    // returnerar priset på en artikel, om priset är känt
    // ... omissions ...
}

class PriceCollector {
    private PriceCollector() {

    }

    public double priceOfExpensiveArticles(List<String> eans,
                                ArticleDB articleDB,
                                double priceLimit) {
        double sum = eans.stream()
                        .peek((String ean) -> ArticleDB.findArticle(ean).stream)
                        . 

    }
}


