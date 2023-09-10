package Sem1;

public class Up5 {
    public static void main(String[] args) {
        double distance1 = Segment.distanceBetween("0.0 0.0", "3.0 4.0", new Point2Dfactory());
        double distance2 = Segment.distanceBetween("0.0 0.0 0.0", "3.0 4.0 5.0", new Point3Dfactory()); 
        System.out.println(distance1);
        System.out.println(distance2);
    }
}

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

    public Point createPoint(String coords);

}

class Point2Dfactory implements PointFactory {

    public Point createPoint(String coords) {
        String[] coordinates = coords.split(" ");
        double x = Double.parseDouble(coordinates[0]);
        double y = Double.parseDouble(coordinates[1]);
        return new Point2D(x, y);
    }

}

class Point3Dfactory implements PointFactory {

    public Point createPoint(String coords) {
        String[] coordinates = coords.split(" ");
        double x = Double.parseDouble(coordinates[0]);
        double y = Double.parseDouble(coordinates[1]);
        double z = Double.parseDouble(coordinates[2]);
        return new Point3D(x, y, z);
    }

}

class Segment {

    private Point p0, p1;

    public Segment  (Point p0, Point p1) {
        this.p0 = p0;
        this.p1 = p1;
    }

    public static double distanceBetween(String p1, String p2, PointFactory factory) {
        Point point1 = factory.createPoint(p1);
        Point point2 = factory.createPoint(p2);
        return point1.distanceTo(point2);
    }

    public double length() {
        return p0.distanceTo(p1);
    }
}