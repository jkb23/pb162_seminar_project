package cz.muni.fi.pb162.project.geometry;

/**
 * @author Matus Jakab
 */
public enum Color {
    BLUE,
    RED,
    GREEN,
    ORANGE,
    WHITE,
    YELLOW,
    BLACK;

    @Override
    public String toString(){
        return super.toString().toLowerCase();
    }
}
