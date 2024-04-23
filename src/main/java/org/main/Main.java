package org.main;

import mandelbrot_set.Mandelbrot;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Mandelbrot fractal = new Mandelbrot(255);
        fractal.manyPointTest();
    }
}