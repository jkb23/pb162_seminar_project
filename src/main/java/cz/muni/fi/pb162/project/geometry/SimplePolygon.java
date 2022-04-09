package cz.muni.fi.pb162.project.geometry;

import cz.muni.fi.pb162.project.utils.SimpleMath;

/**
 * @author Matus Jakab
 */
public abstract class SimplePolygon implements Polygon {
    public double getHeight(){
        return SimpleMath.maxY(this) - SimpleMath.minY(this);
    }

    public double getWidth(){
        return SimpleMath.maxX(this) - SimpleMath.minX(this);
    }

    /**
     *
     * @return formatted string
     */
    @Override
    public String toString(){
        StringBuilder ret = new StringBuilder("Polygon: vertices =");
        for (int i = 0; i < this.getNumVertices(); i++){
            ret.append(" ").append(this.getVertex(i) );
        }

        return ret.toString();
    }

}
