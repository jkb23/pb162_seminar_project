package cz.muni.fi.pb162.project.demo;

import cz.muni.fi.pb162.project.geometry.RegularOctagon;
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
        RegularOctagon octa = new RegularOctagon(new Vertex2D(0.0, 0.0), 1);
        System.out.println(octa.toString());
    }
}
