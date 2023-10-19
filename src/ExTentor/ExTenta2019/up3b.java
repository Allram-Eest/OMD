package ExTentor.ExTenta2019;

import java.util.*;
import java.util.stream.Stream;

public class up3b {

    public boolean isInt(String s) {
        return true;
    }

    public int toInt(String s) {
        return 5;
    }
    
    public int partialSum(List<String> strings, int min, int max) {
        return strings.stream()
                        .filter((s) -> isInt(s))
                        .map((s) -> toInt(s))
                        .filter((i) -> i<=max && i>=min)
                        .reduce(0, (sum, i) -> sum + i);
    }
}
