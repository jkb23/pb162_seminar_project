package cz.muni.fi.pb162.project.comparator;

import cz.muni.fi.pb162.project.geometry.Vertex2D;

import java.util.Comparator;

/**
 * @author Matus Jakab
 */
public class VertexInverseComparator implements Comparator<Vertex2D> {

    /**
     *
     * @param vertex1 the first object to be compared.
     * @param vertex2 the second object to be compared.
     * @return  negative int if vertex2's coordinates are bigger
     *          positive int if vertex1's coordinates are bigger
     *          0 if they are equal
     *          (at first compares X coordinate then Y)
     */
    public int compare(Vertex2D vertex1, Vertex2D vertex2){
        return - vertex1.compareTo(vertex2);
    }
}
