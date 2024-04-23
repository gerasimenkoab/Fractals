package mandelbrot_set;

import static java.lang.Math.sqrt;

public class Complex {
    double re;
    double im;
    // c = re + im * I
    public Complex(double real, double imaginary){
        this.re = real;
        this.im = imaginary;
    }
    public double getRe(){
        return this.re;
    }
    public double getIm(){
        return this.im;
    }

    public double module(){
        return sqrt(re * re + im * im);
    }

    public Complex add(Complex b){
        return new Complex(this.re+b.re,this.im+b.im);
    }


    public Complex subtract(Complex b) {
        return new Complex(this.re - b.re, this.im - b.im);
    }

    public Complex multiply(Complex b) {
        return new Complex(this.re * b.re - this.im * b.im,
                this.re * b.im + this.im * b.re);
    }

    public Complex divide(Complex b) {
        double tempReal = this.re * b.re + this.im * b.im;
        double tempImaginary = this.im * b.re - this.re * b.im;
        double denominator = b.re * b.re + b.im * b.im;

        return new Complex(tempReal / denominator, tempImaginary / denominator);
    }

    @Override
    public String toString() {
        return "Complex{" +
                "real=" + this.re +
                ", imaginary=" + this.im +
                '}';
    }

}
