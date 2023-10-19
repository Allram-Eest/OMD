package ExTentor.ExTenta2016;

import java.util.*;

class Stock extends Observable {
    private double value;

    public void update(double value) {
        this.value += value;
        setChanged();
        notifyObservers();
    }

    public double value() {
        return value;
    }
}

class PortFolio extends Observable implements Observer {
    private List<Stock> stocks = new ArrayList<>();
    public PortFolio(double yieldLimit) {
        addObserver(new YieldWarner(yieldLimit));
    }

    public void add(Stock stock) {
        stock.addObserver(this);
        stocks.add(stock);
    }

    public void update(Observable o, Object arg) {
        setChanged();
        notifyObservers(currentYield());
    }

    public double currentYield() {
        double sum = 0;
        return stocks.stream()
                     .mapToDouble(s -> s.value())
                     .sum();
    }
}

class YieldWarner implements Observer {
    double yieldLimit;

    public YieldWarner(double yieldLimit) {
        this.yieldLimit = yieldLimit;
    }

    public void warn(double yield) {
        //TODO
    }

    public void update(Observable o, Object arg) {
        double yield = (double) arg;
        if (yield < yieldLimit) {
            warn(yield);
        }
    }


}