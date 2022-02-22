package cz.muni.fi.pb162.project;

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
        Vertex2D vertex = new Vertex2D();
        vertex.setX(2);
        vertex.setY(3);

        Vertex2D vertex2 = new Vertex2D();
        vertex2.setX(1);
        vertex2.setY(1);

        vertex.move(vertex2);

        System.out.println(vertex.getInfo());
        System.out.println(vertex2.getInfo());
    }
}
