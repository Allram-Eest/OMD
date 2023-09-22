package Lek6;

import java.util.*;

class SumOfPrimes implements NumberConversion, PrimalityChecking, ListArithmetics {

    public static void main(String[] args) {
        new SumOfPrimes().run(args);
    }

    void run(String[] args) {
        var total = 
            Arrays
            .stream(args)
            .filter(s -> isInt(s))
            .flatMap(s -> toInt(s).stream())
            .filter(k -> isPrime(k))
            .reduce(0, (acc, e) -> acc + e);
    }

}

interface NumberConversion {

    default Optional<Integer> toInt(String s) {
        try {
            return Optional.of(Integer.parseInt(s));
        } catch (Exception e) {
            return 
        }
    }
}