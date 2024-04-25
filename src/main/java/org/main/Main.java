package org.main;

import mandelbrot_set.Fractal;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Fractal fractal = new Fractal(255);
        fractal.run();
    }
}