package cz.muni.fi.pb162.project.utils;

import cz.muni.fi.pb162.project.geometry.Triangle;
import cz.muni.fi.pb162.project.geometry.Vertex2D;

/**
 * @author Matus Jakab
 */

public class SimpleMath {

    /**
     *
     * @param triangle triangle
     * @return smallest X coordinate of its vectors
     */
    public static double minX(Triangle triangle){
        Vertex2D a = triangle.getVertex(0);
        Vertex2D b = triangle.getVertex(1);
        Vertex2D c = triangle.getVertex(2);

        return Math.min(Math.min(a.getX(), b.getX()), c.getX());
    }

    /**
     *
     * @param triangle triangle
     * @return smallest Y coordinate of its vectors
     */
    public static double minY(Triangle triangle){
        Vertex2D a = triangle.getVertex(0);
        Vertex2D b = triangle.getVertex(1);
        Vertex2D c = triangle.getVertex(2);

        return Math.min(Math.min(a.getY(), b.getY()), c.getY());
    }

    /**
     *
     * @param triangle triangle
     * @return biggest X coordinate of its vectors
     */
    public static double maxX(Triangle triangle){
        Vertex2D a = triangle.getVertex(0);
        Vertex2D b = triangle.getVertex(1);
        Vertex2D c = triangle.getVertex(2);

        return Math.max(Math.max(a.getX(), b.getX()), c.getX());
    }

    /**
     *
     * @param triangle triangle
     * @return biggest X coordinate of its vectors
     */
    public static double maxY(Triangle triangle){
        Vertex2D a = triangle.getVertex(0);
        Vertex2D b = triangle.getVertex(1);
        Vertex2D c = triangle.getVertex(2);

        return Math.max(Math.max(a.getY(), b.getY()), c.getY());
    }
}
