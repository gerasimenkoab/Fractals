package org.main;

import mandelbrot_set.Mandelbrot;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Mandelbrot fractal = new Mandelbrot(255);
        fractal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fractal.setSize(1000,1000);
        fractal.setVisible(true);
        fractal.manyPointTest();
    }
}