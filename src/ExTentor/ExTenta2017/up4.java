package ExTentor.ExTenta2017;

public class up4 {
    
}
interface Point2D {
    Point2D move(double dx, double dy);
    double distanceTo(Point2D other);
    String toString();
}

interface Robot {
    Point2D getPosition();
    void move(double dx, double dy);
}

class VacuumCleaner implements Robot {
    public VacuumCleaner (Point2D pos) {}
    public void move(double dx, double dy) {}
    public Point2D getPosition() {return null;}
}

interface RobotController {
    void run(Robot robot);
}

class RobotLogger implements Robot {
    private Robot robot;

    public RobotLogger(Robot robot) {
        this.robot = robot;
    }
    public Point2D getPosition() {
        return robot.getPosition();
    }

    public void move(double dx, double dy) {
        robot.move(dx, dy);
        System.out.println("Moving to " + getPosition().toString());
    }


}

interface RobotSupervisor {
    void alert(String message);
}

class RobotGuardian implements Robot {
    private Robot robot;
    private Point2D origin;
    private double distance;
    private RobotSupervisor supervisor;

    public RobotGuardian(Robot robot, Point2D origin, double distance, RobotSupervisor supervisor) {
        this.robot = robot;
        this.origin = origin;
        this.distance = distance;
        this.supervisor = supervisor;
    }

    @Override
    public Point2D getPosition() {
        return robot.getPosition();
    }

    @Override
    public void move(double dx, double dy) {
        robot.move(dx, dy);
        double currentDistance = origin.distanceTo(getPosition());
        if (currentDistance > 15) {
            supervisor.alert("WARNING: The robot is now " + currentDistance + " m from base.");
        }
        
    }

}

