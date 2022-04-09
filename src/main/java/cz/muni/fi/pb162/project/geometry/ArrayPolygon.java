package cz.muni.fi.pb162.project.geometry;

import java.util.Arrays;

/**
 * @author Matus Jakab
 */
public class ArrayPolygon extends SimplePolygon{
    private final Vertex2D[] array;

    /**
     *
     * @param array array of vertices
     */
    public ArrayPolygon(Vertex2D[] array){
        if (array == null){
            throw new IllegalArgumentException("array is null");
        }

        for (Vertex2D v: array){
            if (v == null){
                throw new IllegalArgumentException("array contains null");
            }
        }

        if (array.length < 3){
            throw new IllegalArgumentException("arrays length is lower than 3");
        }

        this.array = Arrays.copyOf(array, array.length);
    }

    /**
     *
     * @param i index
     * @return vertex on (index modulo number of vertices)
     */
    public Vertex2D getVertex(int i){
        if (i < 0){
            throw new IllegalArgumentException("negative index");
        }

        return array[i % this.getNumVertices()];
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ArrayPolygon that = (ArrayPolygon) o;
        return Arrays.equals(array, that.array);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(array);
    }

    public int getNumVertices(){
        return array.length;
    }
}
