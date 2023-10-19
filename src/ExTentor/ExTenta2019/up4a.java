package ExTentor.ExTenta2019;

import java.util.logging.Logger;

public class up4a {
    public static void main(String[] args) {
        Lever printLever = new PrintingLever();
        DecoratedLever loggLever = new LoggedLever(printLever);
        loggLever.raise();
    }
}

interface Lever {
    public void raise();
}

abstract class DecoratedLever implements Lever{
    private Lever lever;


    public DecoratedLever(Lever lever) {
        this.lever = lever;
    }

    public abstract void preRaise();

    public abstract void postRaise();

    public void raise() {
        preRaise();
        lever.raise();
        postRaise();
    }
}

class LoggedLever extends DecoratedLever {

    public LoggedLever(Lever lever) {
        super(lever);
    }

    @Override
    public void preRaise() {
        System.out.println("Before raising the lever");
    }

    @Override
    public void postRaise() {
        System.out.println("After raising the lever");
    }

}

class PrintingLever implements Lever {
    public void raise() {
        System.out.println("Raising the lever");
    }
}