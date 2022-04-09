package cz.muni.fi.pb162.project.utils;

import cz.muni.fi.pb162.project.geometry.Polygon;

/**
 * @author Matus Jakab
 */

public class SimpleMath {

    /**
     *
     * @param polygon polygon
     * @return smallest X coordinate of its vectors
     */
    public static double minX(Polygon polygon){
        double min = polygon.getVertex(0).getX();
        for (int i = 0; i < polygon.getNumVertices(); i++){
            double newX = polygon.getVertex(i).getX();
            if (newX < min){
                min = newX;
            }
        }
        return min;
    }

    /**
     *
     * @param polygon polygon
     * @return smallest Y coordinate of its vectors
     */
    public static double minY(Polygon polygon){
        double min = polygon.getVertex(0).getY();
        for (int i = 0; i < polygon.getNumVertices(); i++){
            double newY = polygon.getVertex(i).getY();
            if (newY < min){
                min = newY;
            }
        }
        return min;
    }

    /**
     *
     * @param polygon polygon
     * @return biggest X coordinate of its vectors
     */
    public static double maxX(Polygon polygon){
        double max = polygon.getVertex(0).getX();
        for (int i = 0; i < polygon.getNumVertices(); i++){
            double newX = polygon.getVertex(i).getX();
            if (newX > max){
                max = newX;
            }
        }
        return max;
    }

    /**
     *
     * @param polygon polygon
     * @return biggest X coordinate of its vectors
     */
    public static double maxY(Polygon polygon){
        double max = polygon.getVertex(0).getY();
        for (int i = 0; i < polygon.getNumVertices(); i++){
            double newY = polygon.getVertex(i).getY();
            if (newY > max){
                max = newY;
            }
        }
        return max;
    }
}
