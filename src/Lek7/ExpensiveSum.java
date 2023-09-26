package Lek7;

import java.util.stream.IntStream;

public class ExpensiveSum {
    
    public static void main(String[] args) {
        new ExpensiveSum().run();
    }

    int expensive(int k) {
        System.out.printf("Calculating f(%d)\n", k);

        try {
            Thread.sleep(1000);
        } catch (Exception e) {

        }
        return k*k;
    }

    void run() {
        var sum = 
                IntStream
                .rangeClosed(1,16)
                .parallel()
                .map(k -> expensive(k))
                .sum();
    }

    void runOldStyle() {
        var sum = 0;
        for (var k = 1; k <= 16; k +=1) {
            sum += expensive(k);
        }
        System.out.println(sum);
    }

}
