package ExTentor.ExTenta2018;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class up4 {
    
}

class Spot {
    private double angle;
    private double distance;

    public Spot (double angle, double distance) {
        this.angle = angle;
        this.distance = distance;
    }
}

class MotionDetector extends Observable{
    public void motionDetected(double distance, double angle) {
        Spot spot = new Spot(angle, distance);
        setChanged();
        notifyObservers(spot);
    }
}

class Alarm {
    public void start() {
         // . . . startar alarmet . . .
    }
}

class SurveillanceSystem implements Observer{
    private List<Alarm> alarms; 

    public SurveillanceSystem() {
        alarms = new ArrayList<>();
    }

    public void add(MotionDetector detector) {
        detector.addObserver(this); 
    }

    public void add(Alarm alarm) {
        alarms.add(alarm);
    }

    @Override
    public void update(Observable o, Object arg) {
        for (Alarm alarm : alarms) {
            alarm.start();
        }
    }
}