package Lek5;

import java.util.List;

interface RealValuedFunction {
    public double evaluate(double x);
}

class NumericalIntegration {
    public static double integrate(RealValuedFunction f, double a, double b) {
        var steps = 100000;
        var dx = (b-a)/steps;
        var total = 0.0;
        for (var x = a; x < b; x += dx) {
            total += f.evaluate(x)*dx;
        }
        return total;
    }
}

class Integrals {

    public static void main(String[] args) {
        new Integrals().run();
    }

    void run() {
        List<RealValuedFunction> fs = List.of(x -> x*x, x -> x*x*x, x -> x*x*x*x);
        for (var f : fs) {
            System.out.println(NumericalIntegration.integrate(f, 0, 1));
        }
    }
}
