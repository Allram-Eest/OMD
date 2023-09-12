package Lek5;

import java.io.OutputStream;
import java.io.PrintStream;

interface PayStation {

    public void pay(String id, double amount);

}

class StatsPayStation implements PayStation {
    private PayStation decoratedPayStation;
    private double totalPay;
    private int count;

    public StatsPayStation (PayStation decoratedPayStation) {
        this.decoratedPayStation = decoratedPayStation;
    }

    public void pay(String id, double amount) {
        decoratedPayStation.pay(id, amount);
        totalPay += amount;
        count += 1;
    }

    public void averagePay() {
        System.out.println(totalPay / count);
    }
}

class LoggingPayStation implements PayStation {
    private PayStation decoratedPayStation;
    private PrintStream logFile;

    public LoggingPayStation (PayStation decoratePayStation) {
        this.decoratedPayStation = decoratedPayStation;
        try {
            logFile = new PrintStream(new OutputStream("payments.log", true));
        } catch (Exception e) {
            logFile = System.err;
        }
    }

    public void pay(String id, double amount) {
        decoratedPayStation.pay(id, amount);
        System.out.println("===> Log: " + id + ":" + amount);
       
    }
}

class AcmePayStation implements PayStation {
    public void pay(String id, double amount) {
        System.out.printf("id: %8s: %6.2f\n", id, amount);
    }
}

class Decorating {
    public static void main(String[] args) {
        new Decorating().run;
    }

    void run() {
        var ps = new StatsPayStation(new 
        LoggingPayStation(new AcmePayStation()));
        simulate(ps);
        System.out.println(ps.averagePay());
    }
}