package cz.muni.fi.pb162.project.utils;

import cz.muni.fi.pb162.project.geometry.Measurable;
import cz.muni.fi.pb162.project.geometry.Triangle;

/**
 * @author Matus Jakab
 */

public class Gauger {
    /**
     *
     * @param triangle triangle
     */
    public static void printMeasurement(Triangle triangle){
        System.out.println(triangle.toString());
        printMeasurement((Measurable) triangle);
    }

    /**
     *
     * @param obj any measurable object
     */
    public static void printMeasurement(Measurable obj){
        System.out.println("Width: "+ obj.getWidth());
        System.out.println("Height: " + obj.getHeight());
    }
}
