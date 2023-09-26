package Lek7;

import java.util.Queue;
import java.util.stream.IntStream;

public class Singleton {
    
}

class QueueNumberGenerator {

    private static QueueNumberGenerator INSTANCE;

    private QueueNumberGenerator () {}

    public static QueueNumberGenerator instance() {
        if (INSTANCE == null) {
            INSTANCE = new QueueNumberGenerator();
            return INSTANCE;
        } else {
            throw new RuntimeException("Someone has already access to it...");
        }
    }

    private int current  = 0;

    public int next() {
        return ++current;
    }
}

class Singletons {

    public static void main(String[] args) {
        new Singletons().run();
    }

    void run() {
        var qng = QueueNumberGenerator.instance();
        IntStream
                .rangeClosed(1, 10)
                .forEach(k-> {
                    System.out.println(qng.next());
                });
    }
}