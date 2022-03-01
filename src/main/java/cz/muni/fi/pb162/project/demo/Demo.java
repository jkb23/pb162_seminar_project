package cz.muni.fi.pb162.project.demo;

import cz.muni.fi.pb162.project.geometry.Triangle;
import cz.muni.fi.pb162.project.geometry.Vertex2D;

/**
 * Class for running main method.
 *
 * @author Matus Jakab
 */
public class Demo {

    /**
     * Runs the code.
     *
     * @param args command line arguments, will be ignored
     */
    public static void main(String[] args) {
        Vertex2D f = new Vertex2D(-100.0, 0.0);
        Vertex2D s = new Vertex2D(0.0, 100.0);
        Vertex2D t = new Vertex2D(100.0, -100.0);

        Triangle triangle = new Triangle(f, s, t);

        System.out.println(triangle.toString());
    }
}
