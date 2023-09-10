package AccSem1;


interface Point {

    public double distanceTo(Point other);
}

class Point2D implements Point {

    private double x, y;

    public Point2D  (double x, double y) {
        this.x = x;
        this.y = y;
    }

    private Point2D ref(Point other) {
        return (Point2D) other;
    }

    public double distanceTo(Point other) {
        var dx = x - ref(other).x;
        var dy = y - ref(other).y;
        return Math.hypot(dx, dy);
    }
}

class Point3D implements Point {

    private double x, y, z;

    public Point3D  (double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    private Point3D ref(Point other) {
        return (Point3D) other;
    }

    public double distanceTo(Point other) {
        var dx = x - ref(other).x;
        var dy = y - ref(other).y;
        var dz = z - ref(other).z;
        return Math.hypot(Math.hypot(dx, dy), dz);
    }
}

interface PointFactory {

    public Point create(String coords);

}

class MainPoints {
    public static void main(String[] args) {
        new MainPoints().run();
    }

    void run() {
        double distance1 = Segment.distanceBetween("0.0 0.0", "3.0 4.0", new Point2Dfactory());
        double distance2 = Segment.distanceBetween("0.0 0.0 0.0", "3.0 4.0 5.0", new Point3Dfactory()); 
    }

    void distanceBetween(String s1, String s2, PointFactory pf) {
        Point p1 = pf.create(s1);
        Point p2 = pf.create(s2);
        System.out.println(p1.distanceTo(p2));
    }

}

class Point2Dfactory implements PointFactory {

    public Point create(String s) {
        var coords = s.split(" ");
        return new Point2D(Double.parseDouble(coords[0]),
                           Double.parseDouble(coords[1]));
    }
}

class Point3Dfactory implements PointFactory {

    public Point create(String s) {
        var coords = s.split(" ");
        return new Point3D(Double.parseDouble(coords[0]),
                           Double.parseDouble(coords[1]),
                           Double.parseDouble(coords[2]));
    }
}

class Segment {

    private Point p0, p1;

    public Segment  (Point p0, Point p1) {
        this.p0 = p0;
        this.p1 = p1;
    }

    public static double distanceBetween(String p1, String p2, PointFactory factory) {
        Point point1 = factory.create(p1);
        Point point2 = factory.create(p2);
        return point1.distanceTo(point2);
    }

    public double length() {
        return p0.distanceTo(p1);
    }
}