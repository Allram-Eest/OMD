package ExTentor.ExTenta2016;

import java.util.*;

class Stock extends Observable {
    private double value;

    public void update(double value) {
        this.value += value;
        setChanged();
        notifyObservers(value());
    }

    public double value() {
        return value;
    }
}

class PortFolio extends Observable {
    private List<Stock> stocks = new ArrayList<>();
    private double yieldLimit;
    public PortFolio(double yieldLimit) {
        this.yieldLimit = yieldLimit;
    }

    public void add(Stock stock) {
        stocks.add(stock);
    }

    public double currentYield() {
        double sum = 0;
        for (Stock stock : stocks) {
            sum += stock.value();
        }
        return sum;
    }
}