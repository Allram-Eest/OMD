package Sem2Prework2;

import java.util.Random;
import java.util.Set;
import java.util.HashMap;
import java.util.Map;

public class RandomSim {
    
}

class RandomRecPrinter  {
    private Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    private int counter;

    public RandomRecPrinter () {

    }

    public int nextIntLog(int bound) {
        Random rand = new Random();
        int val = rand.nextInt(bound);
        map.put(val, map.getOrDefault(val, 0)+1);
        counter++;
        if (counter %100 == 0) {
            Set<Integer> keySet = map.keySet();
            for (Integer key : keySet) {
                System.out.println(key + ": " + map.get(key) + " occurences");
            }
        }
        return val;
    }


}