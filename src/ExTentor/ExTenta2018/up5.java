package ExTentor.ExTenta2018;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class up5 {
    
}

interface RealRandom {
    double next();
}

interface Simulation {
    void run(RealRandom rng);
}

interface DB {
    void addSample(double sample);
}

class NormalRandom implements RealRandom {
    private Random random;
    private double medel, avvikelse;

    public NormalRandom(double medel, double avvikelse) {
        this.medel = medel;
        this.avvikelse = avvikelse;
        random = new Random();
    }

    public double next() {
        return random.nextGaussian()*avvikelse+medel;
    }
}

class UniformRandom implements RealRandom {
    private Random random;
    private double max, min;

    public UniformRandom(double min, double max) {
        this.max = max;
        this.min = min;
        random = new Random();
    }

    public double next() {
        return random.nextDouble()*(max-min)+min;
    }
}

abstract class DecoratedRandom implements RealRandom {
    private RealRandom rng;

    public DecoratedRandom(RealRandom rng) {
        this.rng = rng;
    }

    abstract protected void process(double value);

    public double next() {
        double value = rng.next();
        process(value);
        return value;
    }

}    

class DBRandom extends DecoratedRandom {
    private DB base;

    public DBRandom(DB base, RealRandom rng) {
        super(rng);
        this.base = base;
    }

    @Override
    protected void process(double value) {
        base.addSample(value);
    }
    
}

class DeviantRandom extends DecoratedRandom {
    List<Double> entries;

    public DeviantRandom(RealRandom rng) {
        super(rng);
        entries = new ArrayList<>();
    }

    private double sum() {
        double sum = 0;
        for (Double value : entries) {
            sum += value;
        }
        return sum;
    }

    @Override
    protected void process(double value) {
        entries.add(value);
        System.out.println("Medelvärde: " + medelvärde());
        System.out.println("Standardavvikelse: " + avvikelse());
    }

    public double medelvärde() {
        return sum()/entries.size();
    }
    
    public double avvikelse() {
        double n = entries.size();
        double squaredSum = 0;
        for (Double value: entries) {
            squaredSum += value*value;
        }
        double m = medelvärde();
        return Math.sqrt((squaredSum - n*(m*m))/(n-1));
    }

    
}

class test {
    RealRandom random = new UniformRandom(0, 4);
    DecoratedRandom decoratedRandom = new DeviantRandom(random);
    BigBangSimulation.run(decoratedRandom);

}