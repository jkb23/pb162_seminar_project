package cz.muni.fi.pb162.project.geometry;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * @author Matus Jakab
 */
public final class LabeledPolygon extends SimplePolygon implements Labelable, Sortable {
    private final SortedMap<String, Vertex2D> map;

    /**
     *
     * @param map map from builder
     */
    private LabeledPolygon(SortedMap<String, Vertex2D> map){
        super(map.values().toArray(new Vertex2D[0]));
        this.map = map;
    }

    /**
     *
     * @param num vertex index, not negative number
     * @return the index-th vertex
     */
    public Vertex2D getVertex(int num){
        if (num < 0){
            throw new IllegalArgumentException("Index lower than 0");
        }
        List<Vertex2D> list = new ArrayList<>(map.values());
        return list.get(num % list.size());
    }

    /**
     *
     * @return number of vertices
     */
    public int getNumVertices(){
        return map.size();
    }

    /**
     *
     * @param label label under which the vertex is stored
     * @return vertex which is value of given key (label)
     */
    public Vertex2D getVertex(String label){
        Vertex2D vertex = map.get(label);
        if (vertex == null){
            throw new IllegalArgumentException("Given label not in dictionary");
        }
        return vertex;
    }

    /**
     *
     * @return sorted set of all labels
     */
    public List<String> getLabels(){
        return new ArrayList<>(new HashSet<>(map.keySet()));
    }

    /**
     *
     * @param vertex vertex which labels are searched
     * @return list of vertex's labels
     */
    public List<String> getLabels(Vertex2D vertex){
        return  map.keySet().stream()
                .filter(e -> map.get(e).equals(vertex))
                .collect(Collectors.toList());
    }

    /**
     *
     * @return collection of sorted vertices
     */
    public Collection<Vertex2D> getSortedVertices(){
        return new TreeSet<>(map.values());
    }

    /**
     *
     * @param comparator comparator object used to determine the ordering
     * @return collection of sorted vertices by comparator
     */
    public Collection<Vertex2D> getSortedVertices(Comparator<Vertex2D> comparator){
        TreeSet<Vertex2D> sorted = new TreeSet<>(comparator);
        sorted.addAll(map.values());
        return sorted;
    }

    /**
     *
     * @return Collection of duplicate vertices
     */
    public Collection<Vertex2D> duplicateVertices(){
        Set<Vertex2D> ret = new HashSet<>();
        return map.values().stream()
                .filter(e -> !ret.add(e))
                .collect(Collectors.toList());
    }

    /**
     * @author Matus Jakab
     */
    public static class Builder implements Buildable {
        private final SortedMap<String, Vertex2D> map = new TreeMap<>();

        /**
         *
         * @param label name of vertex
         * @param vertex vertex to add
         * @return Builder
         */
        public Builder addVertex(String label, Vertex2D vertex){
            if (label == null || vertex == null){
                throw new IllegalArgumentException("label and vertex can't be null");
            }

            if (label.equals("")){
                throw new IllegalArgumentException("label can't an empty string");
            }

            map.put(label, vertex);
            return this;
        }

        /**
         *
         * @return built LabeledPolygon
         */
        public LabeledPolygon build(){
            return new LabeledPolygon(map);
        }
    }
}
