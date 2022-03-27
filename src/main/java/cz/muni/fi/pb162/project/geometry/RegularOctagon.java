package cz.muni.fi.pb162.project.geometry;

/**
 * @author Matus Jakab
 */
public class RegularOctagon extends GeneralRegularPolygon {

    /**
     *
     * @param center of selected octagon
     * @param radius of selected octagon
     */
    public RegularOctagon(Vertex2D center, double radius){
        super(center, 8, radius);
    }
}
