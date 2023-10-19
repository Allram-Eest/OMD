package ExTentor.ExTenta2019;

import java.util.*;
import java.util.stream.Stream;

public class up3a {
    
    public List<String> wordsOfLength(String text, int wordLength) {
        String[] words = text.split(" ");
        return Stream.of(words)
                        .filter((s) -> s.length()==wordLength)
                        .collect(Collection, collection.toList()); 
    }
}
