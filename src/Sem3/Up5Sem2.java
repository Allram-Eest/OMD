package Sem3;

import java.util.Optional;

class Optionals {
    public static <T> Optional<T> lift(T[] values, int index) {
        return
            index < values.length
            ? Optional.of(values[index])
            : Optional.empty();

    }

    public static Optional<Integer> toInt(String s) {
        try {
            return Optional.of(Integer.parseInt(s));
        } catch (Exception e) {
            return Optional.empty();
        }
    }
}

class Ex00 {

    public static void main(String[] args) {
        new Ex00().run(args);
    }

    void run(String[] args) {
        var first = 
            Optionals
            .lift(args, 0) //Optional<String>
            .flatMap(s -> Optionals.toInt(s))  //Optional<Integer>
            .orElse(0);
        var second =  
            Optionals   
            .lift(args, 0) //Optional<String>
            .flatMap(s -> Optionals.toInt(s))  //Optional<Integer>
            .orElse(0);
    }
}