package cz.muni.fi.pb162.project.geometry;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * @author Matus Jakab
 */
public class CollectionPolygon extends SimplePolygon {
    private final List<Vertex2D> list;

    /**
     *
     * @param array array of vertices
     */
    public CollectionPolygon(Vertex2D[] array){
        super(array);
        this.list = Arrays.asList(array.clone());
    }

    /**
     *
     * @param list list of vertices
     */
    public CollectionPolygon(List<Vertex2D> list){
        super(list.toArray(new Vertex2D[0]));
        this.list = List.copyOf(list);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CollectionPolygon that = (CollectionPolygon) o;
        return Objects.equals(list, that.list);
    }

    @Override
    public int hashCode() {
        return Objects.hash(list);
    }

    /**
     *
     * @return new CollectionPolygon without leftmost vertex
     */
    public CollectionPolygon withoutLeftmostVertices(){
        if (this.list.size() == 1){
            return null;
        }

        double minX = Double.POSITIVE_INFINITY;
        int minCounter = 0;
        for (Vertex2D vertex : list){
            if (vertex.getX() < minX) {
                minX = vertex.getX();
                minCounter = 1;
            } else if (vertex.getX() == minX){
                minCounter++;
            }
        }

        Vertex2D[] newList = new Vertex2D[list.size() - minCounter];
        int index = 0;
        for (Vertex2D vertex : list){
            if (vertex.getX() > minX){
                newList[index] = vertex;
                index++;
            }
        }

        return new CollectionPolygon(newList);
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

        return list.get(i % this.getNumVertices());
    }

    public int getNumVertices(){
        return list.size();
    }
}
