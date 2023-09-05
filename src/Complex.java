public class Complex {
    
    private double re, im;

    public static Complex createCartesian(double re, double im) {
        return new Complex(re, im);
    }

    private Complex (double re, double im) {
        this.re = re;
        this.im = im;
    }

    public static Complex createPolar(double magnitude, double argument) {
        return new Complex(magnitude * Math.cos(argument), magnitude * Math.cos(argument));
    }

}
